package posts;

import javax.swing.*;

public class PostsController {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PostsView().setVisible(true));
    }
}
