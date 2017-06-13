package com.lilei.iplay.service;

import com.lilei.iplay.model.User;

public interface UserService {

    public boolean verifyPhoneNumberIsExist(String phoneNumber);

    public int saveUserInfors(User user);

    public User verifyUserLogin(User user);
    
    public User updateUserInfos(User user);
}
