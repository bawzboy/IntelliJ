package posts.eventBus;

public interface InterfaceEventBus {

    void sendMessage(String string);

    void registerListener(InterfaceCallback callback);
}
