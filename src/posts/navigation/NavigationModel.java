package posts.navigation;

import posts.ModelChangeSupport;

public class NavigationModel extends ModelChangeSupport {
    boolean loginSuccessful;
    boolean loginNotSuccessful;

    public boolean isLoginSuccessful() {
        return loginSuccessful;
    }

    public void setLoginSuccessful(boolean loginSuccessful) {
        boolean old = this.loginSuccessful;
        this.loginSuccessful = loginSuccessful;
        changeSupport.firePropertyChange("loginSuccessful", old, loginSuccessful);
    }

    public boolean isLoginNotSuccessful() {
        return loginNotSuccessful;
    }

    public void setLoginNotSuccessful(boolean loginNotSuccessful) {
        boolean old = this.loginNotSuccessful;
        this.loginNotSuccessful = loginNotSuccessful;
        changeSupport.firePropertyChange("loginNotSuccessful", old, loginNotSuccessful);
    }
}
