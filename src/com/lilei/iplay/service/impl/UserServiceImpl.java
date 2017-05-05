package com.lilei.iplay.service.impl;

import org.springframework.stereotype.Service;

import com.lilei.iplay.dao.UserDao;
import com.lilei.iplay.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    
}
