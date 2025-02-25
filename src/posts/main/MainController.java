package posts.main;

import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.messages.BaseMessage;
import posts.messages.RegisterNavigation;
import posts.messages.RegisterView;
import posts.messages.ShowNewPage;

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
                view.showNewPage(pageName);
                break;
        }
//        view.revalidate();
//        view.repaint();
    }

    @Override
    public void init() {
        System.out.println("MainController initialized");
        this.view = new MainView(this);
        EventBus.getInstance().registerListener(this);
        view.setVisible(true);
    }
}
