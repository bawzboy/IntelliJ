package posts.login;

import posts.BaseController;
import posts.db.User;
import posts.db.UserManagerJDBC;
import posts.messages.BaseMessage;
import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.messages.SuccessfulLogin;

public class LoginController extends BaseController implements InterfaceCallback, InterfaceLogin {

    LoginModel loginModel;

    public LoginController() {
        view = new LoginView(this);
        loginModel = ((LoginView) view).getObservableList1();
        EventBus.getInstance().registerListener(this);
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {
        switch(baseMessage.getMessageType()) {
            default:
                break;
        }
    }

    @Override
    public boolean passwordCheck() {
        User user = UserManagerJDBC.getInstance().readUser(loginModel.getEmail());
        if (user == null) {
            return false;
        }
        if (user.getPasswort().equals(loginModel.getPassword())) {
            EventBus.getInstance().sendMessage(new SuccessfulLogin(loginModel.getEmail()));
        }
        return false;
    }
}
