package posts.main;

import javax.swing.*;

public class MainController {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainView().setVisible(true));
    }
}
