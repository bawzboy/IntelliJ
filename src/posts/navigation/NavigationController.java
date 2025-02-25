package posts.navigation;

import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.main.ControllerInterface;
import posts.messages.*;

import javax.swing.*;
import java.awt.*;

public class NavigationController implements InterfaceCallback, ControllerInterface {
    private JMenuBar menuBar;
    private NavigationView navigationView;

    public NavigationController() {
        navigationView = new NavigationView();
    }

    public JMenuBar createMenuBar(CardLayout cardLayout, JPanel cardPanel) {
        return navigationView.getMenuBar1();
    }

    public void setNavigationVisibility(boolean visible) {
        navigationView.getObservableList1().setLoginSuccessful(visible);
        navigationView.getObservableList1().setLoginNotSuccessful(!visible);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {
        switch(baseMessage.getMessageType()) {
            case "SuccessfulLogin":
                setNavigationVisibility(true);
                break;
            case "Logout":
                setNavigationVisibility(false);
                break;
        }
    }

    @Override
    public void init() {
        System.out.println("NavigationController initialized");
        this.menuBar = createMenuBar(null, null);
        EventBus.getInstance().registerListener(this);
        EventBus.getInstance().sendMessage(new RegisterNavigation(menuBar));
    }
}
