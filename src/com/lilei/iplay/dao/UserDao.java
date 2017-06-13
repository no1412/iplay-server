package com.lilei.iplay.dao;

import java.util.List;

import com.lilei.iplay.model.User;

public interface UserDao {

    public List<String> findUserPhoneNumber();

    public int saveUserInfo(User user);

    public User getUserByPhoneNumerPassword(String phoneNumber, String password); 
    
    public int updateUserInfors(User user);
    
    public User getUserById(int id);
}
