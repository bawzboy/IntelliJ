package user;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class UserSelectionModel {

    private transient final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public UserSelectionModel() {
    }

    private String selectedEmail;
    private List<String> allEmails;

    public String getSelectedEmail() {
        return selectedEmail;
    }

    public void setSelectedEmail(String selectedEmail) {
        String old = this.selectedEmail;
        this.selectedEmail = selectedEmail;
        support.firePropertyChange("selectedEmail", old, this.selectedEmail);
    }

    public List<String> getAllEmails() {
        return allEmails;
    }

    public void setAllEmails(List<String> allEmails) {
        List<String> old = this.allEmails;
        this.allEmails = allEmails;
        support.firePropertyChange("allEmails", old, this.allEmails);
    }
}
