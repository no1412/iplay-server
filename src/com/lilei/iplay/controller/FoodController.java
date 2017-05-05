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
import com.lilei.iplay.model.FoodDescribeVo;
import com.lilei.iplay.service.FoodService;

@Controller
@RequestMapping(Constants.APP_URL_FOOD_PREFIX)
public class FoodController {

    private Logger log = Logger.getLogger(FoodController.class);

    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/getFoodDescribe", method = RequestMethod.GET)
    @ResponseBody
    private List<FoodDescribeVo> getFoodDescribe() {
        List<FoodDescribeVo> foodDescribes = null;
        try {
            foodDescribes = foodService.findFoodDescribes();
        } catch (ParameterException e) {
            e.printStackTrace();
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return foodDescribes;
    }
}
