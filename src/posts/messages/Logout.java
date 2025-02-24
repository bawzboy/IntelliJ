package posts.messages;

public class Logout extends BaseMessage{

    public Logout() {
        super("Logout");
    }
    @Override
    public Object getMessageContent() {
        return null;
    }
}
