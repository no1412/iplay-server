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

@Controller
@RequestMapping(Constants.APP_URL_USER_PREFIX)
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);

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
            return Constants.FAILURE;
        }
        User user = new User();
        boolean flag = userService.verifyPhoneNumberIsExist(phoneNumber);
        if (flag) {
            return Constants.SUCCESS;
        } else {
            return Constants.FAILURE;
        }
    }
}
