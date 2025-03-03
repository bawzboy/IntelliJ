package posts.post;

import posts.BaseController;
import posts.eventBus.EventBus;
import posts.eventBus.InterfaceCallback;
import posts.main.ControllerInterface;
import posts.messages.*;

public class PostController extends BaseController implements ControllerInterface, InterfaceCallback, InterfacePost {

        PostModel postModel;

    public PostController() {}


    @Override
    public void newTweet() {
        Tweet tweet = new Tweet();
        tweet.setUserEmail("helge@me.com"); // TODO logged in user...
        tweet.setContent(postModel.getText());
        EventBus.getInstance().sendMessage(new NewTweet(tweet));
    }

    @Override
    public void init() {
        System.out.println("PostController initialized");
        view = new PostView(this);
        postModel = ((PostView) view).getObservableList1();
        EventBus.getInstance().registerListener(this);
        EventBus.getInstance().sendMessage(new RegisterView(view, "NewPost"));
    }

    @Override
    public void handleMessage(BaseMessage baseMessage) {
        switch(baseMessage.getMessageType()) {
            case "ReturnTweet":
                ReturnTweet returnTweet = (ReturnTweet) baseMessage;
                Tweet tweet = (Tweet) returnTweet.getMessageContent();
                try {
                    postModel.setText(tweet.getContent());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;
    }
}


}

// tweetlänge auf 80 zeichen beschränken
// tweetbutton -> user = logged in user // timestamp + id = "automatisch"
//