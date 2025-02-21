package posts;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public MainView() {
        setTitle("Posts");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(new LoginView(), "Login");
        cardPanel.add(new JLabel("Benutzerverwaltung"), "Benutzerverwaltung");
        cardPanel.add(new PostView(), "Posts");

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Navigation");

        JMenuItem benutzerverwaltungItem = new JMenuItem("Benutzer anzeigen");
        JMenuItem postsItem = new JMenuItem("Neuen Post erstellen");
        JMenuItem logoutItem = new JMenuItem("Logout");

        benutzerverwaltungItem.addActionListener(e -> cardLayout.show(cardPanel, "Benutzerverwaltung"));
        postsItem.addActionListener(e -> cardLayout.show(cardPanel, "Posts"));
        logoutItem.addActionListener(e -> cardLayout.show(cardPanel, "Login"));

        menu.add(benutzerverwaltungItem);
        menu.add(postsItem);
        menu.add(logoutItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        add(cardPanel);
    }

}

