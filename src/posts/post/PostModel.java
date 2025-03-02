package posts.post;

import posts.ModelChangeSupport;

public class PostModel extends ModelChangeSupport {
    String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        String old = this.text;
        this.text = text;
        changeSupport.firePropertyChange("text", old, text);
    }
}
