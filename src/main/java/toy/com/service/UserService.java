package toy.com.service;

import toy.com.entity.User;

public interface UserService {
    User insertUser(User user);
    User updateUser(User user);
    User selectUser(User user);

    User logIn(User user);
}
