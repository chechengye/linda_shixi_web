package service;

import pojo.User;

public interface UserService {
    void registerUser(User user);

    User checkLogin(String username, String password);
}
