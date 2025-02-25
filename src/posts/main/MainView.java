package posts.main;

import posts.adminConsole.AdminConsoleView;
import posts.login.LoginController;
import posts.navigation.NavigationController;
import posts.post.PostController;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private MainController mainController;
    private NavigationController navigationController;



    public MainView(MainController mainController) {
        this.mainController = mainController;
        setTitle("Posts");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

//        LoginController loginController = new LoginController();
//        cardPanel.add(loginController.getView(), "Login");
//
//        cardPanel.add(new AdminConsoleView(), "Benutzerverwaltung");

//        PostController postController = new PostController();
//        cardPanel.add(postController.getView(), "Posts");

        cardPanel.add(new JPanel(), "Hugo");

        navigationController = new NavigationController();
        setJMenuBar(navigationController.createMenuBar(cardLayout, cardPanel));

        add(cardPanel);
        navigationController.setNavigationVisibility(false);
    }

    public void addJPanel(JPanel view, String text) {
        cardPanel.add(view, text);
        cardLayout.show(cardPanel, text);
    }

}

