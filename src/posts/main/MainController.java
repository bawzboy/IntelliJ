package posts.main;

import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.messages.*;

import javax.swing.*;

public class MainController implements InterfaceCallback, ControllerInterface {
    MainView view;

    public MainController() {
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {
        switch(baseMessage.getMessageType()) {
            case "RegisterView":
                RegisterView registerView = (RegisterView) baseMessage;
                String name = registerView.getNameView();
                JPanel clientView = (JPanel) registerView.getMessageContent();
                view.addJPanel(clientView, name);
                break;
            case "RegisterNavigation":
                RegisterNavigation registerNavigation = (RegisterNavigation) baseMessage;
                JMenuBar navigationBar = (JMenuBar) registerNavigation.getMessageContent();
                view.addJMenuBar(navigationBar);
                break;
            case "ShowNewPage":
                ShowNewPage showNewPage = (ShowNewPage) baseMessage;
                String pageName = (String) showNewPage.getMessageContent();
                if (pageName.equals("Login")) {
                    EventBus.getInstance().sendMessage(new Logout());
                }
                view.showNewPage(pageName);
                break;
            case "SuccessfulLogin":
                SuccessfulLogin successfulLogin = (SuccessfulLogin) baseMessage;
                String loggedInUser = (String) successfulLogin.getMessageContent();
                view.showNewPage("NewPost");
                EventBus.getInstance().sendMessage(new RequestTweets(loggedInUser));
                break;
        }
    }

    @Override
    public void init() {
        System.out.println("MainController initialized");
        this.view = new MainView(this);
        EventBus.getInstance().registerListener(this);
        view.setVisible(true);
    }
}
