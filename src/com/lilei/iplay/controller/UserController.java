package com.lilei.iplay.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lilei.iplay.common.Constants;
import com.lilei.iplay.entity.Result;
import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.User;
import com.lilei.iplay.service.UserService;
import com.lilei.iplay.util.EncodingUtil;
import com.lilei.iplay.util.PropertyUtil;
import com.lilei.iplay.util.StringUtil;

@Controller
@RequestMapping(Constants.APP_URL_USER_PREFIX)
public class UserController {

    private Logger log = Logger.getLogger(UserController.class);
    private static final String PHONE_NUMBER_EXIST_ERROR_CODE = "10";

    @Autowired
    private UserService userService;

    /**
     * @Title: verifyPhoneNumberIsExist 
     * @Description: TODO(验证手机号是否存在) 
     * @param @param phoneNumber
     * @param @param appKey
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
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
    
    /**
     * @Title: userRegister 
     * @Description: TODO(用户注册) 
     * @param @param phoneNumber
     * @param @param nickName
     * @param @param password
     * @param @param appKey
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
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
        boolean flag = userService.verifyPhoneNumberIsExist(phoneNumber);
        if (flag) {
            return PHONE_NUMBER_EXIST_ERROR_CODE;
        }
        nickName = EncodingUtil.getEncodingString(nickName);
        User user = new User(password, "", Constants.DEFAULT_USER_HEAD_URL, nickName, phoneNumber);
        int userId = userService.saveUserInfors(user);
        if (userId != 0) {
            log.info(nickName + " 注册成功");
            return Constants.SUCCESS;
        } else {
            log.info(nickName + " 注册失败");
            return Constants.FAILURE;
        }
    }

    /**
     * @Title: verifyUserLogin 
     * @Description: TODO(验证用户登录) 
     * @param @param phoneNumber
     * @param @param password
     * @param @param appKey
     * @param @return    设定文件 
     * @return User    返回类型 
     * @throws
     */
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

    /**
     * 
     * @Title: updateUserInfos 
     * @Description: TODO(更新用户信息) 
     * @param @param userNickName
     * @param @param userPhone
     * @param @param userEmail
     * @param @param appKey
     * @param @return    设定文件 
     * @return User    返回类型 
     * @throws
     */
    @RequestMapping(value = "/updateUserInfos", method = RequestMethod.POST)
    @ResponseBody
    private User updateUserInfos(
            @RequestParam(value = "userId", defaultValue = "0") int userId,
            @RequestParam(value = "userNickName", defaultValue = "") String userNickName,
            @RequestParam(value = "userPhone", defaultValue = "") String userPhone,
            @RequestParam(value = "headPicUrl", defaultValue = "") String headPicUrl,
            @RequestParam(value = "userEmail", defaultValue = "") String userEmail,
            @RequestParam(value = "appKey", defaultValue = "") String appKey
            ) {
        if (!appKey.equals(Constants.APP_KEY)) {
            return null;
        }
        userNickName = EncodingUtil.getEncodingString(userNickName);
        User user = new User();
        user.setId(userId);
        user.setNickName(userNickName);
        user.setPhoneNumber(userPhone);
        user.setEmail(userEmail);
        user.setHeadPicUrl(headPicUrl);

        user = userService.updateUserInfos(user);
        return user;
    }

    /**
     * @Title: uploadUserImg 
     * @Description: TODO(更新用户头像uploadUserImg) 
     * @param @param filedata
     * @param @param request
     * @param @return    设定文件 
     * @return String    返回类型 
     * @throws
     */
    @RequestMapping(value = "/uploadUserImg", method = RequestMethod.POST)
    @ResponseBody
    public String uploadUserImg(
            @RequestParam(value = "image") MultipartFile filedata,
            HttpServletRequest request
            ) {
        String savePath = request.getServletContext().getRealPath("/" + Constants.UPLOAD_USER_FOLDER);
        String fileName = StringUtil.createFileName() + ".png";
        try {
            // 生成jpg图片
            OutputStream out = new FileOutputStream(new File(savePath, fileName));
            out.write(filedata.getBytes());
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imageURL = PropertyUtil.getProjectUrl() + Constants.UPLOAD_USER_FOLDER + fileName; 
        return imageURL;
    }
}
