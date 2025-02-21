package posts.post;

import posts.BaseController;

import javax.swing.*;

public class PostController extends BaseController {

        PostModel postModel;

    public PostController() {
        view = new PostView();
        postModel = ((PostView) view).getObservableList1();
    }

}
