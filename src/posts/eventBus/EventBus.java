package posts.eventBus;

import java.util.ArrayList;
import java.util.List;

public class EventBus implements InterfaceEventBus{

    private static EventBus eventBus;

    public static EventBus getInstance() {
        if(eventBus == null) {
            eventBus = new EventBus();
        }
        return eventBus;
    }

    private EventBus() {}

    private List<InterfaceCallback> callbacks = new ArrayList<>();

    public void sendMessage(String message) {
        for(InterfaceCallback callback : callbacks) {
            callback.handleMessage(message);
        }
    }

    @Override
    public void registerListener(InterfaceCallback  callback) {
        this.callbacks.add(callback);

    }

}
