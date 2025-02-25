package posts.messages;

public class ShowNewPage extends BaseMessage{
    String pageName;

    public ShowNewPage(String pageName) {
        super("ShowNewPage");
        this.pageName = pageName;
    }

    @Override
    public Object getMessageContent() {
        return pageName;
    }
}
