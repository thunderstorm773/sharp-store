package sharpStore.models.viewModels;

import sharpStore.enums.Role;

public class ShowUser {

    private String username;

    private Role role;

    public ShowUser() {
    }

    public ShowUser(String username, Role role) {
        this.username = username;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
