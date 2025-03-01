package posts.messages;

public class RequestTweet extends BaseMessage{
    int id;

    public RequestTweet(int id) {
        super("RequestTweet");
        this.id = id;
    }

    @Override
    public Object getMessageContent() {
        return id;
    }
}
