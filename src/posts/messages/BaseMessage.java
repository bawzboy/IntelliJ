package posts.messages;

public abstract class BaseMessage {
    final String messageType;

    public BaseMessage(String messageType) {
        this.messageType = messageType;
    }

    public String getMessageType() {
        return messageType;
    }

    abstract public Object getMessageContent();
}
