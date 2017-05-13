package com.lilei.iplay.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lilei.iplay.dao.UserDao;
import com.lilei.iplay.model.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    private static final String CLASS_NAME = User.class.getName();

    private static final String SQL_ID_FIND_USER_PHONE_NUMBER = ".findUserPhoneNumber";
    private static final String SQL_ID_SAVE_USER_INFOR = ".saveUserInfo";
    private static final String SQL_ID_GET_USER_BY_PHONE_NUMBER_password = ".getUserByPhoneNumerPassword";

    @Override
    public List<String> findUserPhoneNumber() {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND_USER_PHONE_NUMBER);
    }

    @Override
    public int saveUserInfo(User user) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("user", user);
        getSqlSession().insert(CLASS_NAME + SQL_ID_SAVE_USER_INFOR, params);
        return user.getId();
    }

    @Override
    public User getUserByPhoneNumerPassword(String phoneNumber, String password) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("phoneNumber", phoneNumber);
        params.put("password", password);
        return getSqlSession().selectOne(CLASS_NAME + SQL_ID_GET_USER_BY_PHONE_NUMBER_password, params);
    }

}
