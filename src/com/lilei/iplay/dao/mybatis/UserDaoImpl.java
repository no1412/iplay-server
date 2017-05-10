package com.lilei.iplay.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lilei.iplay.dao.UserDao;
import com.lilei.iplay.model.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    private static final String CLASS_NAME = User.class.getName();

    private static final String SQL_ID_FIND_USER_PHONE_NUMBER= ".findUserPhoneNumber";
    
    @Override
    public List<String> findUserPhoneNumber() {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND_USER_PHONE_NUMBER);
    }

}
