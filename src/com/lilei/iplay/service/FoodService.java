package com.lilei.iplay.service;

import java.util.List;

import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.FoodDescribeVo;

public interface FoodService {

    public List<FoodDescribeVo> findFoodDescribes() throws ParameterException, ServiceException;
}
