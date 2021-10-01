package sales.user.service;

import sales.user.User;

import java.util.Set;

public interface UserService {
    void saveUser(User user);

    void updateUser(User user);

    Set<User> getAll();
}
