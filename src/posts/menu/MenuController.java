package posts.menu;

import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.messages.BaseMessage;
import posts.messages.Logout;

import javax.swing.*;
import java.awt.*;

public class MenuController implements InterfaceCallback {
    private JMenuBar menuBar;

    public MenuController() {
        this.menuBar = new JMenuBar();
        EventBus.getInstance().registerListener(this);
    }

    public JMenuBar createMenuBar(CardLayout cardLayout, JPanel cardPanel) {
        JMenu menu = new JMenu("Navigation");

        JMenuItem benutzerverwaltungItem = new JMenuItem("Benutzer anzeigen");
        JMenuItem postsItem = new JMenuItem("Neuen Post erstellen");
        JMenuItem logoutItem = new JMenuItem("Logout");

        benutzerverwaltungItem.addActionListener(e -> cardLayout.show(cardPanel, "Benutzerverwaltung"));
        postsItem.addActionListener(e -> cardLayout.show(cardPanel, "Posts"));
        logoutItem.addActionListener(e -> {
            cardLayout.show(cardPanel, "Login");
            EventBus.getInstance().sendMessage(new Logout());
        });

        menu.add(benutzerverwaltungItem);
        menu.add(postsItem);
        menu.add(logoutItem);
        menuBar.add(menu);

        return menuBar;
    }

    public void setNavigationVisibility(boolean visible) {
        menuBar.setVisible(visible);
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
}
