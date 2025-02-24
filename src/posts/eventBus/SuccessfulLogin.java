package posts.eventBus;

public class SuccessfulLogin extends BaseMessage{
    String email;

    public SuccessfulLogin(String email) {
        super("SuccessfulLogin");
        this.email = email;
    }

    @Override
    public Object getMessageContent() {
        return email;
    }
}
