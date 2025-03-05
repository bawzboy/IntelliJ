package posts.follower;

import posts.ModelChangeSupport;

import java.util.List;
import java.util.Objects;

public class FollowerModel extends ModelChangeSupport {

    public FollowerModel() {
    }

    private List<String> follower;
    private String selectedFollower;

    private List<String> following;
    private String selectedFollowing;

    private List<String> userToFollow;
    private String selectedUserToFollow;
    private List<String> selectedUsersToFollow;

    public List<String> getFollower() {
        return follower;
    }

    public void setFollower(List<String> follower) {
        List<String> old = this.follower;
        this.follower = follower;
        changeSupport.firePropertyChange("followers", old, follower);
    }

    public List<String> getFollowing() {
        return following;
    }

    public void setFollowing(List<String> following) {
        List<String> old = this.following;
        this.following = following;
        changeSupport.firePropertyChange("following", old, following);
    }

    public List<String> getUserToFollow() {
        return userToFollow;
    }

    public void setUserToFollow(List<String> userToFollow) {
        List<String> old = this.userToFollow;
        this.userToFollow = userToFollow;
        changeSupport.firePropertyChange("userToFollow", old, userToFollow);
    }

    public String getSelectedFollower() {
        return selectedFollower;
    }

    public void setSelectedFollower(String selectedFollower) {
        String old = this.selectedFollower;
        this.selectedFollower = selectedFollower;
        changeSupport.firePropertyChange("selectedFollower", old, selectedFollower);
    }

    public String getSelectedFollowing() {
        return selectedFollowing;
    }

    public void setSelectedFollowing(String selectedFollowing) {
        String old = this.selectedFollowing;
        this.selectedFollowing = selectedFollowing;
        changeSupport.firePropertyChange("selectedFollowing", old, selectedFollowing);
    }

    public String getSelectedUserToFollow() {
        return selectedUserToFollow;
    }

    public void setSelectedUserToFollow(String selectedUserToFollow) {
        String old = this.selectedUserToFollow;
        this.selectedUserToFollow = selectedUserToFollow;
        changeSupport.firePropertyChange("selectedUserToFollow", old, selectedUserToFollow);
    }

    public List<String> getSelectedUsersToFollow() {
        return selectedUsersToFollow;
    }

    public void setSelectedUsersToFollow(List<String> selectedUsersToFollow) {
        List<String> old = this.selectedUsersToFollow;
        this.selectedUsersToFollow = selectedUsersToFollow;
        changeSupport.firePropertyChange("selectedUsersToFollow", old, selectedUsersToFollow);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FollowerModel that = (FollowerModel) o;
        return Objects.equals(follower, that.follower) && Objects.equals(selectedFollower, that.selectedFollower) && Objects.equals(following, that.following) && Objects.equals(selectedFollowing, that.selectedFollowing) && Objects.equals(userToFollow, that.userToFollow) && Objects.equals(selectedUserToFollow, that.selectedUserToFollow) && Objects.equals(selectedUsersToFollow, that.selectedUsersToFollow);
    }

    @Override
    public int hashCode() {
        return Objects.hash(follower, selectedFollower, following, selectedFollowing, userToFollow, selectedUserToFollow, selectedUsersToFollow);
    }
}
