package posts.messages;
import posts.post.Tweet;

public class ReturnTweet extends BaseMessage{
    Tweet tweet;

    public ReturnTweet(Tweet tweet) {
        super("ReturnTweet");
        this.tweet = tweet;
    }

    @Override
    public Object getMessageContent() {
        return tweet;
    }
}
