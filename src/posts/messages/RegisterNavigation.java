package posts.messages;

import javax.swing.*;

public class RegisterNavigation extends BaseMessage {
    JMenuBar navigationBar;

    public RegisterNavigation(JMenuBar navigationBar) {
        super("RegisterNavigation");
        this.navigationBar = navigationBar;
    }

    @Override
    public Object getMessageContent() {
        return navigationBar;
    }
}
