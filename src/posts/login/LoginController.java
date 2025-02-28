package posts.login;

import posts.BaseController;
import posts.rest.User;
import posts.main.ControllerInterface;
import posts.messages.*;
import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;

public class LoginController extends BaseController implements InterfaceCallback, InterfaceLogin, ControllerInterface {

    LoginModel loginModel;

    public LoginController() {}

    @Override
    public void handleMessage(BaseMessage baseMessage) {
        switch(baseMessage.getMessageType()) {
            case "ReturnUser":
                ReturnUser returnUser = (ReturnUser) baseMessage;
                User user = (User) returnUser.getMessageContent();
                if (user == null) {
                    System.out.println("User not found");
                    return;
                }
                if (user.getPasswort().equals(loginModel.getPasswort())) {
                    EventBus.getInstance().sendMessage(new SuccessfulLogin(loginModel.getEmail()));
                }
                break;
        }
    }

    @Override
    public void passwordCheck() {
        EventBus.getInstance().sendMessage(new RequestUser(loginModel.getEmail()));
    }

    @Override
    public void init() {
        System.out.println("LoginController initialized");
        EventBus.getInstance().registerListener(this);
        view = new LoginView(this);
        loginModel = ((LoginView) view).getObservableList1();
        EventBus.getInstance().sendMessage(new RegisterView(view, "Login"));
    }
}
