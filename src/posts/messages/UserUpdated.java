package posts.messages;

public class UserUpdated extends BaseMessage{
    public UserUpdated() {
        super("UserUpdated");
    }

    @Override
    public Object getMessageContent() {
        return null;
    }
}
