package com.lilei.iplay.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lilei.iplay.dao.ContentDao;
import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.ContentDescribeVo;

public class ContentDaoImpl extends SqlSessionDaoSupport implements ContentDao {

    private static final String CLASS_NAME = Content.class.getName();

    private static final String SQL_ID_FIND_CONTENT_DESCRIBES = ".findContentDescribes";

    @Override
    public List<ContentDescribeVo> findContentDescribes(Content content) {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND_CONTENT_DESCRIBES, content);
    }

}
