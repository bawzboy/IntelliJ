package posts.eventBus;

import posts.messages.BaseMessage;

public interface InterfaceEventBus {

    void sendMessage(BaseMessage baseMessage);

    void registerListener(InterfaceCallback callback);
}
