package posts.post;

import posts.ModelChangeSupport;

import java.util.List;

public class PostModel extends ModelChangeSupport {
    String text;
    String tweets;

    public String getTweets() {
        return tweets;
    }

    public void setTweets(String tweets) {
        String old = this.tweets;
        this.tweets = tweets;
        changeSupport.firePropertyChange("tweets", old, tweets);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        String old = this.text;
        this.text = text;
        changeSupport.firePropertyChange("text", old, text);
    }
}
