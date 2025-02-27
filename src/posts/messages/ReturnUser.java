package posts.messages;

import posts.rest.User;

public class ReturnUser extends BaseMessage{
    User user;

    public ReturnUser(User user) {
        super("ReturnUser");
        this.user = user;
    }

    @Override
    public Object getMessageContent() {
        return user;
    }
}
