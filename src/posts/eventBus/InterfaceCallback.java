package posts.eventBus;

import posts.messages.BaseMessage;

public interface InterfaceCallback {

    public void handleMessage(BaseMessage baseMessage);
}
