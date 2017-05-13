package com.lilei.iplay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lilei.iplay.common.Constants;

@Controller
@RequestMapping(Constants.APP_URL_UPLOAD_PREFIX)
public class UploadController {

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(
            @RequestParam(value = "photo") MultipartFile filedata) {
                return null;
        
    }
}
