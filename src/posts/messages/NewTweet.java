package posts.messages;

public class NewTweet extends BaseMessage{
// TODO eigentlich sollte ein ganzer Tweet übergeben werden...
// wenn ich weder timestamp noch id übergebe, sollte die db das regeln? über bruno sieht es nicht danach aus...


    String tweetText;

    public NewTweet(String tweetText) {
        super("NewTweet");
        this.tweetText = tweetText;
    }

    @Override
    public Object getMessageContent() {
        return tweetText;
    }
}
