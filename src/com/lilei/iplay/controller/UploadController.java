package com.lilei.iplay.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.lilei.iplay.common.Constants;
import com.lilei.iplay.util.PropertyUtil;
import com.lilei.iplay.util.StringUtil;

@Controller
@RequestMapping(Constants.APP_URL_UPLOAD_PREFIX)
public class UploadController {

    @RequestMapping(value = "/uploadImg", method = RequestMethod.POST)
    @ResponseBody
    public String uploadImg(
            @RequestParam(value = "image") MultipartFile filedata,
            HttpServletRequest request
            ) {
        String savePath = request.getServletContext().getRealPath("/" + Constants.UPLOAD_FOLDER);
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
        String imageURL = PropertyUtil.getProjectUrl() + Constants.UPLOAD_FOLDER + fileName; 
        return imageURL;
    }
}
