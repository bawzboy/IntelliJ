package posts.messages;

public class TextMessage extends BaseMessage{
    String message;

    public TextMessage(String message) {
        super("TextMessage");
        this.message = message;
    }

    @Override
    public Object getMessageContent() {
        return message;
    }
}
