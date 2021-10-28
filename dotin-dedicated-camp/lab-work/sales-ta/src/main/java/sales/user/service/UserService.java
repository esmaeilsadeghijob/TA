package sales.user.service;

import sales.user.User;

import java.io.IOException;
import java.util.Set;

public interface UserService {
    void saveUser(User user) throws IOException;

    void updateUser(User user);

    Set<User> getAll();
}
