package com.lilei.iplay.controller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lilei.iplay.common.Constants;
import com.lilei.iplay.model.User;
import com.lilei.iplay.service.UserService;
import com.lilei.iplay.util.EncodingUtil;

@Controller
@RequestMapping(Constants.APP_URL_USER_PREFIX)
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    private static final String PHONE_NUMBER_EXIST_ERROR_CODE = "10";

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/verifyPhoneNumberIsExist", method = RequestMethod.GET)
    @ResponseBody
    private String verifyPhoneNumberIsExist(
            @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
            @RequestParam(value = "appKey", defaultValue = "") String appKey
            ) {
        if (StringUtils.isEmpty(appKey) || !appKey.equals(Constants.APP_KEY)) {
            return Constants.FAILURE;
        }
        boolean flag = userService.verifyPhoneNumberIsExist(phoneNumber);
        if (flag) {
            return Constants.SUCCESS;
        } else {
            return Constants.FAILURE;
        }
    }
    
    @RequestMapping(value = "/userRegister", method = RequestMethod.POST)
    @ResponseBody
    private String userRegister(
            @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
            @RequestParam(value = "nickName", defaultValue = "") String nickName,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "appKey", defaultValue = "") String appKey
            ) {
        if (!appKey.equals(Constants.APP_KEY)) {
            return PHONE_NUMBER_EXIST_ERROR_CODE;
        }
        nickName = EncodingUtil.getEncodingString(nickName);
        User user = new User(password, "", "", nickName, phoneNumber);
        int userId = userService.saveUserInfors(user);
        if (userId != 0) {
            log.info(nickName + " 注册成功");
            return Constants.SUCCESS;
        } else {
            log.info(nickName + " 注册失败");
            return Constants.FAILURE;
        }
    }

    @RequestMapping(value = "/verifyUserLogin", method = RequestMethod.POST)
    @ResponseBody
    private User verifyUserLogin(
            @RequestParam(value = "phoneNumber", defaultValue = "") String phoneNumber,
            @RequestParam(value = "password", defaultValue = "") String password,
            @RequestParam(value = "appKey", defaultValue = "") String appKey
            ) {
        if (!appKey.equals(Constants.APP_KEY)) {
            return null;
        }
        User user = new User();
        user.setPhoneNumber(phoneNumber);
        user.setPassword(password);
        user = userService.verifyUserLogin(user);
        if (user != null) {
            user.setResponseCode(Constants.SUCCESS);
            log.info(user.getNickName() + " 登录成功");
            return user;
        } else {
            user = new User();
            user.setResponseCode(Constants.FAILURE);
            log.info("手机号或者密码不正确");
            return user;
        }
    }
}
