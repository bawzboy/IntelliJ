package posts.messages;

public class UserDeleted extends BaseMessage{
    public UserDeleted() {
        super("UserDeleted");
    }

    @Override
    public Object getMessageContent() {
        return null;
    }
}
