package com.web.service;

import com.web.bean.User;

public interface UserService {

    // check username and password for login
    User checkForLogin(User user);

    // user register
    void insertUserForRegister(User user);

    // check if user existed when registering
    User checkUsernameExistForRegister(String username);
}
