package com.lilei.iplay.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lilei.iplay.common.Constants;
import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.EntertainmentDescribeVo;
import com.lilei.iplay.service.EntertainmentService;
import com.lilei.iplay.service.FoodService;

@Controller
@RequestMapping(Constants.APP_URL_ENTERTAINMENT_PREFIX)
public class EntertainmentController {

    private Logger log = Logger.getLogger(EntertainmentController.class);

    @Autowired
    private EntertainmentService entertainmentService;

    @RequestMapping(value = "/getEntertainmentDescribe", method = RequestMethod.GET)
    @ResponseBody
    private List<EntertainmentDescribeVo> getFoodDescribe() {
        List<EntertainmentDescribeVo> entertainmentDescribes = null;
        try {
            entertainmentDescribes = entertainmentService.findEntertainmentDescribes();
        } catch (ParameterException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return entertainmentDescribes;
    }
}
