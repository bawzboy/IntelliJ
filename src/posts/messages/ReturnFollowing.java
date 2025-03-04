package posts.messages;

import java.util.List;

public class ReturnFollowing extends BaseMessage{

    List<String> following;

    public ReturnFollowing(List<String> following) {
        super("ReturnFollowing");
        this.following = following;
    }

    @Override
    public Object getMessageContent() {
        return following;
    }
}
