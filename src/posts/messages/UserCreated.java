package posts.messages;

public class UserCreated extends BaseMessage{

    public UserCreated() {
        super("UserCreated");
    }

    @Override
    public Object getMessageContent() {
        return null;
    }
}
