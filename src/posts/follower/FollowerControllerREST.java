package posts.follower;

import posts.BaseController;
import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.main.ControllerInterface;
import posts.messages.BaseMessage;

public class FollowerControllerREST extends BaseController implements ControllerInterface, InterfaceCallback {

    @Override
    public void init() {
        System.out.println("FollowerControllerREST initialized");
        EventBus.getInstance().registerListener(this);
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {

    }
}
