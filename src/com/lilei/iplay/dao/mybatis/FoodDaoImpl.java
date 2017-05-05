package com.lilei.iplay.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lilei.iplay.dao.FoodDao;
import com.lilei.iplay.model.Food;
import com.lilei.iplay.model.FoodDescribeVo;

public class FoodDaoImpl extends SqlSessionDaoSupport implements FoodDao {

    private static final String CLASS_NAME = Food.class.getName();

    private static final String SQL_ID_FIND_FOOD_DESCRIBES = ".findFoodDescribes";

    @Override
    public List<FoodDescribeVo> findFoodDescribes() {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND_FOOD_DESCRIBES);
    }

}
