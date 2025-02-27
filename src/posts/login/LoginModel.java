package posts.login;

import posts.ModelChangeSupport;

public class LoginModel extends ModelChangeSupport {
    String email = "helge@me.com";
    String password;

    public LoginModel() {
    }

    public LoginModel(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String old = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", old, email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String old = this.password;
        this.password = password;
        changeSupport.firePropertyChange("password", old, password);
    }
}
