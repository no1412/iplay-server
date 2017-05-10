package com.lilei.iplay.dao;

import java.util.List;

import com.lilei.iplay.model.User;

public interface UserDao {

    public List<String> findUserPhoneNumber();
    public int saveUserInfo(User user);
}
