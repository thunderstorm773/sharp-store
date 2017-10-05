package sharpStore.repositories.impl;

import sharpStore.entities.User;
import sharpStore.repositories.api.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private List<User> users;

    private Long currentIndex;

    private static UserRepositoryImpl userRepository;

    private UserRepositoryImpl() {
        this.users = new ArrayList<>();
        currentIndex = 1L;
    }

    public static UserRepository getInstance() {
        if (userRepository == null) {
            userRepository = new UserRepositoryImpl();
        }

        return userRepository;
    }

    @Override
    public boolean addUser(User user) {
        if (isUserExists(user)) {
            return false;
        }

        user.setId(this.currentIndex++);
        this.users.add(user);
        return true;
    }

    @Override
    public User findUserByUsernameAndPassword(String username, String password) {
        User user = null;
        Optional<User> candidateUser = this.users.stream()
                .filter(u -> u.getUsername().equals(username) &&
                        u.getPassword().equals(password))
                .findAny();
        if (candidateUser.isPresent()) {
            user = candidateUser.get();
        }

        return user;
    }

    private boolean isUserExists(User user) {
        return this.users.stream()
                .anyMatch(u -> u.getUsername().equals(user.getUsername()));
    }
}
