package posts.messages;

import javax.swing.*;

public class RegisterViewMessage extends BaseMessage{
    JPanel view;
    String nameView;

    public RegisterViewMessage(JPanel view, String nameView) {
        super("RegisterViewMessage");
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
