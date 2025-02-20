package posts;

import java.util.Objects;

public class User {
    String email;
    String name;
    String passwort;
    String role;

    /**
     * default Constructor
     */
    public User() {

    }

    /**
     * @param email
     * @param name
     * @param passwort
     * @param role
     */
    public User(String email, String name, String passwort, String role) {
        super();
        this.email = email;
        this.name = name;
        this.passwort = passwort;
        this.role = role;
    }

    public User(User user) {
        this.email = new String(user.getEmail());
        this.name = new String(user.getName());
        this.passwort = new String(user.getPasswort());
        this.role = new String(user.getRole());
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPasswort() {
        return passwort;
    }
    public void setPasswort(String passwort) {
        this.passwort = passwort;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(email, user.email) && Objects.equals(name, user.name) && Objects.equals(passwort, user.passwort) && Objects.equals(role, user.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, name, passwort, role);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", passwort='" + passwort + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
