package posts.login;

import posts.ModelChangeSupport;

public class LoginModel extends ModelChangeSupport {
    String email = "helge@me.com";
    String passwort = "Passw0rd!";

    public LoginModel() {
    }

    public LoginModel(String email, String passwort) {
        this.email = email;
        this.passwort = passwort;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String old = this.email;
        this.email = email;
        changeSupport.firePropertyChange("email", old, email);
    }

    public String getPasswort() {
        return passwort;
    }

    public void setPasswort(String passwort) {
        String old = this.passwort;
        this.passwort = passwort;
        changeSupport.firePropertyChange("passwort", old, passwort);
    }
}
