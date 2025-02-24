package posts.main;

import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.messages.BaseMessage;

import javax.swing.*;

public class MainController implements InterfaceCallback {
    MainView view;

    public MainController() {
        this.view = new MainView(this);
        EventBus.getInstance().registerListener(this);
        view.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainController::new);
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {

    }
}
