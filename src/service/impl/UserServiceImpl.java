package service.impl;

import dao.UserDao;
import pojo.User;
import service.UserService;

import java.util.UUID;

public class UserServiceImpl implements UserService {


    @Override
    public void registerUser(User user) {
        user.setUid(UUID.randomUUID().toString().replace("-",""));
        UserDao userDao = new UserDao();
        userDao.registerUser(user);
    }
}
