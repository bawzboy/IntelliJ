package posts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PostsView extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public PostsView() {
        setTitle("CardLayout Beispiel");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(new LoginScreen(), "Login");
        cardPanel.add(new JLabel("Benutzerverwaltung"), "Benutzerverwaltung");
        cardPanel.add(new JLabel("Posts"), "Posts");

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

