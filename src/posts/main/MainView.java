package posts.main;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;
    private MainController mainController;

    public MainView(MainController mainController) {
        this.mainController = mainController;
        setTitle("Posts");
        setSize(400, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

//        cardPanel.add(new JPanel(), "Hugo");

        add(cardPanel);
    }

    public void addJPanel(JPanel view, String text) {
        cardPanel.add(view, text);
        cardLayout.show(cardPanel, text);
    }

    public void addJMenuBar(JMenuBar navigationBar) {
        setJMenuBar(navigationBar);
    }

    public void showNewPage(String pageName) {
        cardLayout.show(cardPanel, pageName);
    }
}

