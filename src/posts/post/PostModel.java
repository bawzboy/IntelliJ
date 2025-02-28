package posts.post;

import posts.ModelChangeSupport;

public class PostModel extends ModelChangeSupport {
    String tweet;

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        String old = this.tweet;
        this.tweet = tweet;
        changeSupport.firePropertyChange("tweet", old, tweet);
    }
}
