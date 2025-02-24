package posts.main;

import posts.benutzerverwaltung.BenutzerverwaltungScreen;
import posts.login.LoginController;
import posts.menu.MenuController;
import posts.post.PostController;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private MainController mainController;
    private MenuController menuController;

    public MainView(MainController mainController) {
        this.mainController = mainController;
        setTitle("Posts");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        LoginController loginController = new LoginController();
        cardPanel.add(loginController.getView(), "Login");

        cardPanel.add(new BenutzerverwaltungScreen(), "Benutzerverwaltung");

        PostController postController = new PostController();
        cardPanel.add(postController.getView(), "Posts");

        menuController = new MenuController();
        setJMenuBar(menuController.createMenuBar(cardLayout, cardPanel));

        add(cardPanel);
        menuController.setNavigationVisibility(false);
    }

}

