package com.lilei.iplay.service.impl;

import java.util.List;

import com.lilei.iplay.dao.FoodDao;
import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.FoodDescribeVo;
import com.lilei.iplay.service.FoodService;

public class FoodServiceImpl implements FoodService {

    private FoodDao foodDao;

    @Override
    public List<FoodDescribeVo> findFoodDescribes() throws ParameterException,
            ServiceException {
        return foodDao.findFoodDescribes();
    }

    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

}
