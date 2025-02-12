package user;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Objects;

public class UserModel {

    private transient final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public UserModel() {
    }

    public UserModel(String nickname, String email, String password) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    private  String nickname;
    private  String email;
    private  String password;
    private String statusInfo = "Status Infos";

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        String old = this.nickname;
        this.nickname = nickname;
        support.firePropertyChange("nickname", old, nickname);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        String old = this.email;
        this.email = email;
        support.firePropertyChange("email", old, email);
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        String old = this.password;
        this.password = password;
        support.firePropertyChange("password", old, password);
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return Objects.equals(nickname, userModel.nickname) && Objects.equals(email, userModel.email) && Objects.equals(password, userModel.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nickname, email, password);
    }

    @Override
    public String toString() {
        return "User: " + nickname + "\n" +
                "email: " + email + "\n" +
                "password: " + password + "\n";
    }

}
