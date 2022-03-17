package com.web.service;

import com.web.bean.User;
import com.web.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User checkForLogin(User user) {

        return userDao.checkUserForLogin(user);
    }

    @Override
    public void insertUserForRegister(User user) {

        userDao.insertUserForRegister(user);
    }

    @Override
    public User checkUsernameExistForRegister(String username) {

        return userDao.checkUsernameExistForRegister(username);
    }
}
