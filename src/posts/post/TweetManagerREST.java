package posts.post;

import com.google.gson.Gson;
import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.main.ControllerInterface;
import posts.messages.BaseMessage;
import posts.messages.RequestTweet;
import posts.messages.ReturnTweet;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class TweetManagerREST implements InterfaceCallback, ControllerInterface {
    private final String baseUrl = "http://localhost:8080/tweets";
    private HttpClient httpClient;
    private Gson gson;

    public TweetManagerREST() {}

    public Tweet getTweet(Integer id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/" + id))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode() == 200 ? gson.fromJson(response.body(), Tweet.class) : null;
    }

    public void createTweet(Tweet tweet) throws Exception {
        String requestBody = gson.toJson(tweet);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void updateTweet(int id, Tweet tweet) throws Exception {
        String requestBody = gson.toJson(tweet);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/" + id))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void deleteTweet(int id) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/" + id))
                .DELETE()
                .build();
        httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {
        switch(baseMessage.getMessageType()) {
            case "RequestTweet":
                RequestTweet requestTweet = (RequestTweet) baseMessage;
                int id = (int) requestTweet.getMessageContent();
                try {
                    Tweet tweet = this.getTweet(id);
                    EventBus.getInstance().sendMessage(new ReturnTweet(tweet));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    public void init() {
        System.out.println("TweetManagerREST initialized");
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
        EventBus.getInstance().registerListener(this);
    }
}
