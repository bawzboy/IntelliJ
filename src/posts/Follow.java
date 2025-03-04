package posts;

import java.util.Objects;

public class Follow {
    private String loggedInUser;
    private String userToFollow;

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public String getUserToFollow() {
        return userToFollow;
    }

    public void setUserToFollow(String userToFollow) {
        this.userToFollow = userToFollow;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Follow follow = (Follow) o;
        return Objects.equals(loggedInUser, follow.loggedInUser) && Objects.equals(userToFollow, follow.userToFollow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loggedInUser, userToFollow);
    }
}
