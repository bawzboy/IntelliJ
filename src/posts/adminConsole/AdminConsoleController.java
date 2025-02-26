package posts.adminConsole;

import posts.BaseController;
import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.main.ControllerInterface;
import posts.messages.BaseMessage;
import posts.messages.RegisterView;

public class AdminConsoleController extends BaseController implements ControllerInterface, InterfaceCallback {

    @Override
    public void init() {
        System.out.println("AdminConsoleController initialized");
        view = new AdminConsoleView();
        EventBus.getInstance().registerListener(this);
        EventBus.getInstance().sendMessage(new RegisterView(view, "AdminConsole"));
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {

    }
}
