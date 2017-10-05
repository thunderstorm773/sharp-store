package sharpStore.repositories.api;

import sharpStore.entities.User;

public interface UserRepository {

    boolean addUser(User user);

    User findUserByUsernameAndPassword(String username, String password);
}
