package com.lilei.iplay.model;

import org.apache.commons.lang.StringUtils;

import com.lilei.iplay.common.Constants;
import com.lilei.iplay.util.PropertyUtil;

public class User {

    private int id;
    private String password;
    private String email;
    private String headPicUrl;
    private String nickName;
    private String phoneNumber;
    private String responseCode;

    public User() {}

    public User(String password, String email, String headPicUrl,
            String nickName, String phoneNumber) {
        super();
        this.password = password;
        this.email = email;
        this.headPicUrl = headPicUrl;
        this.nickName = nickName;
        this.phoneNumber = phoneNumber;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getHeadPicUrl() {
        if (StringUtils.isEmpty(headPicUrl)) {
            return headPicUrl;
        } else {
            return PropertyUtil.getProjectUrl() + headPicUrl;
        }
    }
    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }
    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
}
