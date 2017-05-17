package com.lilei.iplay.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lilei.iplay.common.Constants;
import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.ContentDescribeVo;
import com.lilei.iplay.service.ContentService;

@Controller
@RequestMapping(Constants.APP_URL_CONTENT_PREFIX)
public class ContentController {

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
}
