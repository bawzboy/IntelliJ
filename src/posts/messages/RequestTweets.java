package posts.messages;

public class RequestTweets extends BaseMessage{
    String userEmail;

    public RequestTweets(String userEmail) {
        super("RequestTweets");
        this.userEmail = userEmail;
    }

    @Override
    public Object getMessageContent() {
        return userEmail;
    }
}
