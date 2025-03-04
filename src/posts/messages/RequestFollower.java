package posts.messages;

public class RequestFollower extends BaseMessage{
    // Anfrage für eine Liste von Usern die dem User(email) folgen
    String email;

    public RequestFollower(String email) {
        super("RequestFollower");
        this.email = email;
    }

    @Override
    public Object getMessageContent() {
        return email;
    }
}
