package com.lilei.iplay.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.lilei.iplay.common.Constants;
import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.ContentDescribeVo;
import com.lilei.iplay.service.ContentService;
import com.lilei.iplay.util.EncodingUtil;

@Controller
@RequestMapping(Constants.APP_URL_CONTENT_PREFIX)
public class ContentController {

    private static final String CONTENT_DETAIL_JSP = "content/contentDetail";
    private Logger log = Logger.getLogger(ContentController.class);

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/getContentDescribe", method = RequestMethod.POST)
    @ResponseBody
    private List<ContentDescribeVo> getContentDescribe(
            @RequestParam(value = "cityCode", defaultValue = "") String cityCode,
            @RequestParam(value = "typeId", defaultValue = "0") int typeId
            ) {
        List<ContentDescribeVo> contentDescribes = null;
        try {
            Content content = new Content();
            content.setCityCode(cityCode);
            content.setTypeId(typeId);
            contentDescribes = contentService.findContentDescribes(content);
        } catch (ParameterException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        } catch (ServiceException e) {
            log.error(e.getMessage());
            e.printStackTrace();
        }
        return contentDescribes;
    }

    @RequestMapping(value = "/saveContent", method = RequestMethod.POST)
    @ResponseBody
    private String saveContent(
            @RequestParam(value = "typeId", defaultValue = "0") int typeId,
            @RequestParam(value = "userId", defaultValue = "0") int userId,
            @RequestParam(value = "title", defaultValue = "") String title,
            @RequestParam(value = "surface", defaultValue = "") String surface,
            @RequestParam(value = "appKey", defaultValue = "") String appKey,
            @RequestParam(value = "contentDetail", defaultValue = "") String contentDetail,
            @RequestParam(value = "cityCode", defaultValue = "") String cityCode
            ) {
        if (!appKey.equals(Constants.APP_KEY)) {
            return null;
        }
        title = EncodingUtil.getEncodingString(title);
        contentDetail = EncodingUtil.getEncodingString(contentDetail);
        Content content = new Content(title, surface, contentDetail, cityCode, new Date(), typeId, userId);
        int result = 0;
        try {
            result = contentService.saveContent(content);
        } catch (ParameterException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        if (result != 0) {
            return Constants.SUCCESS;
        } else {
            return Constants.FAILURE;
        }
    }

    @RequestMapping(value = "/seeContentDetail", method = RequestMethod.GET)
    @ResponseBody
    private ModelAndView seeContentDetail(
            @RequestParam(value = "contentId", defaultValue = "0") int contentId,
            @RequestParam(value = "appKey", defaultValue = "") String appKey
            ) {
        if (!appKey.equals(Constants.APP_KEY)) {
            return null;
        }
        ContentDescribeVo contentDescribeVo = null;
        try {
            contentDescribeVo = contentService.getContentDetail(contentId);
        } catch (ParameterException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(CONTENT_DETAIL_JSP);
        modelAndView.addObject("contentDescribeVo", contentDescribeVo);
        return modelAndView;
    }
}
