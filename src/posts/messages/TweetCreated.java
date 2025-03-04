package posts.messages;

public class TweetCreated extends BaseMessage{

    public TweetCreated() {
        super("TweetCreated");
    }

    @Override
    public Object getMessageContent() {
        return null;
    }
}
