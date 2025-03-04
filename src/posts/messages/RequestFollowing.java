package posts.messages;

public class RequestFollowing extends BaseMessage{
    // Anfrage für eine Liste von Usern denen der User(email) folgt
    String email;

    public RequestFollowing(String email) {
        super("RequestFollowing");
        this.email = email;
    }

    @Override
    public Object getMessageContent() {
        return email;
    }
}
