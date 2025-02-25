package posts.main;

import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.messages.BaseMessage;
import posts.messages.RegisterViewMessage;

import javax.swing.*;

public class MainController implements InterfaceCallback, ControllerInterface {
    MainView view;

    public MainController() {
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {
        switch(baseMessage.getMessageType()) {
            case "RegisterViewMessage":
                RegisterViewMessage registerViewMessage = (RegisterViewMessage) baseMessage;
                String name = registerViewMessage.getNameView();
                JPanel clientView = (JPanel) registerViewMessage.getMessageContent();
                view.addJPanel(clientView, name);
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
