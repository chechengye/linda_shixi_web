package service.impl;

import dao.UserDao;
import pojo.User;
import service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    public UserServiceImpl() {
        userDao = new UserDao();
    }

    @Override
    public void registerUser(User user) {
        user.setUid(UUID.randomUUID().toString().replace("-",""));
        userDao.registerUser(user);
    }

    @Override
    public User checkLogin(String username, String password) {
        return userDao.checkLogin(username , password);
    }
}
