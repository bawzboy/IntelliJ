package posts.messages;

import javax.swing.*;

public class RegisterView extends BaseMessage{
    JPanel view;
    String nameView;

    public RegisterView(JPanel view, String nameView) {
        super("RegisterView");
        this.view = view;
        this.nameView = nameView;
    }

    @Override
    public Object getMessageContent() {
        return view;
    }

    public String getNameView() {
        return nameView;
    }

}
