package posts.messages;

import java.util.List;

public class ReturnFollower extends BaseMessage{

    List<String> follower;

    public ReturnFollower(List<String> follower) {
        super("ReturnFollower");
        this.follower = follower;
    }

    @Override
    public Object getMessageContent() {
        return follower;
    }
}
