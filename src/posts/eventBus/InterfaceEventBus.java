package posts.eventBus;

public interface InterfaceEventBus {

    void sendMessage(BaseMessage baseMessage);

    void registerListener(InterfaceCallback callback);
}
