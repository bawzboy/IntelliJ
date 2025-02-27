package posts.messages;

public class RequestUser extends BaseMessage{
    String email;

    public RequestUser(String email) {
        super("RequestUser");
        this.email = email;
    }

    @Override
    public Object getMessageContent() {
        return email;
    }
}
