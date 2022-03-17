package com.web.dao;

import com.web.bean.User;
import org.springframework.stereotype.Repository;

// This interface is implemented by mybatis at mapper.xml
@Repository
public interface UserDao {

    User checkUserForLogin(User user);

    void insertUserForRegister(User user);

    User checkUsernameExistForRegister(String username);
}
