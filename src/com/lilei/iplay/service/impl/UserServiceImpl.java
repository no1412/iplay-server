package com.lilei.iplay.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lilei.iplay.dao.UserDao;
import com.lilei.iplay.model.User;
import com.lilei.iplay.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public boolean verifyPhoneNumberIsExist(String phoneNumber) {
        List<String> userPhoneNumbers = userDao.findUserPhoneNumber();
        if (userPhoneNumbers != null) {
            if (userPhoneNumbers.contains(phoneNumber)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public int saveUserInfors(User user) {
        return userDao.saveUserInfo(user);
    }

    @Override
    public User verifyUserLogin(User user) {
        return userDao.getUserByPhoneNumerPassword(user.getPhoneNumber(), user.getPassword());
    }

}
