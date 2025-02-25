package posts.post;

import posts.BaseController;
import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.main.ControllerInterface;
import posts.messages.BaseMessage;
import posts.messages.RegisterView;

public class PostController extends BaseController implements ControllerInterface, InterfaceCallback {

        PostModel postModel;

    public PostController() {}

    @Override
    public void init() {
        System.out.println("PostController initialized");
        view = new PostView();
        postModel = ((PostView) view).getObservableList1();
        EventBus.getInstance().registerListener(this);
        EventBus.getInstance().sendMessage(new RegisterView(view, "NewPost"));
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {

    }
}
