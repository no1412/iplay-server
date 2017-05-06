package com.lilei.iplay.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lilei.iplay.dao.EntertainmentDao;
import com.lilei.iplay.model.Entertainment;
import com.lilei.iplay.model.EntertainmentDescribeVo;

public class EntertainmentDaoImpl extends SqlSessionDaoSupport implements EntertainmentDao {

    private static final String CLASS_NAME = Entertainment.class.getName();

    private static final String SQL_ID_FIND_ENTERTAINMENT_DESCRIBES = ".findEntertainmentDescribes";

    @Override
    public List<EntertainmentDescribeVo> findEntertainmentDescribes() {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND_ENTERTAINMENT_DESCRIBES);
    }


}
