package posts.messages;

import posts.post.Tweet;

public class NewTweet extends BaseMessage{

    Tweet tweet;

    public NewTweet(Tweet tweet) {
        super("NewTweet");
        this.tweet = tweet;
    }

    @Override
    public Object getMessageContent() {
        return tweet;
    }
}
