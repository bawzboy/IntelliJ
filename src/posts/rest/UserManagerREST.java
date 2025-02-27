package posts.rest;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;
import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.main.ControllerInterface;
import posts.messages.BaseMessage;
import posts.messages.RequestUser;
import posts.messages.ReturnUser;

public class UserManagerREST implements InterfaceCallback, ControllerInterface {
    private final String baseUrl = "http://localhost:8080/users";
    private HttpClient httpClient;
    private Gson gson;

    /**
     * Erstellt eine Instanz von UserManager mit einem HTTP-Client und Gson.
     */
    public UserManagerREST() {
    }


    /**
     * Ruft einen Benutzer anhand der E-Mail ab.
     * @param email Die E-Mail des Benutzers.
     * @return Das Benutzerobjekt oder null, falls nicht gefunden.
     * @throws Exception Falls die HTTP-Anfrage fehlschlägt.
     */
    public User getUser(String email) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/" + email))
                .GET()
                .build();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        return response.statusCode() == 200 ? gson.fromJson(response.body(), User.class) : null;
    }

    /**
     * Erstellt einen neuen Benutzer über die REST-API.
     * @param user Das Benutzerobjekt, das gespeichert werden soll.
     * @throws Exception Falls die HTTP-Anfrage fehlschlägt.
     */
    public void createUser(User user) throws Exception {
        String requestBody = gson.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Aktualisiert einen Benutzer.
     * @param email Die E-Mail des Benutzers.
     * @param user Das aktualisierte Benutzerobjekt.
     * @throws Exception Falls die HTTP-Anfrage fehlschlägt.
     */
    public void updateUser(String email, User user) throws Exception {
        String requestBody = gson.toJson(user);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/" + email))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();
        httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    /**
     * Löscht einen Benutzer anhand der E-Mail-Adresse.
     * @param email Die E-Mail des Benutzers.
     * @throws Exception Falls die HTTP-Anfrage fehlschlägt.
     */
    public void deleteUser(String email) throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/" + email))
                .DELETE()
                .build();
        httpClient.send(request, HttpResponse.BodyHandlers.ofString());
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {
        switch(baseMessage.getMessageType()) {
            case "RequestUser":
                RequestUser requestUser = (RequestUser) baseMessage;
                String email = (String) requestUser.getMessageContent();
                try {
                    User user = this.getUser(email);
                    EventBus.getInstance().sendMessage(new ReturnUser(user));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
        }
    }

    @Override
    public void init() {
        System.out.println("UserManagerREST initialized");
        this.httpClient = HttpClient.newHttpClient();
        this.gson = new Gson();
        EventBus.getInstance().registerListener(this);
    }
}
