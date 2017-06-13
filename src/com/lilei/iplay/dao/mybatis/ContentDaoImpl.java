package com.lilei.iplay.dao.mybatis;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.lilei.iplay.dao.ContentDao;
import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.ContentDescribeVo;
import com.lilei.iplay.model.ContentVo;

public class ContentDaoImpl extends SqlSessionDaoSupport implements ContentDao {

    private static final String CLASS_NAME = Content.class.getName();

    private static final String SQL_ID_FIND_CONTENT_DESCRIBES = ".findContentDescribes";
    private static final String SQL_ID_SEARCH_CONTENT_DESCRIBES = ".searchContentDescribes";
    private static final String SQL_ID_SAVE_CONTENT = ".saveContent";
    private static final String SQL_GET_CONTENT_DETAIL = ".getContentDetail";

    @Override
    public List<ContentDescribeVo> findContentDescribes(Content content) {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_FIND_CONTENT_DESCRIBES, content);
    }

    @Override
    public int saveContent(Content content) {
        return getSqlSession().insert(CLASS_NAME + SQL_ID_SAVE_CONTENT, content);
    }

    @Override
    public ContentDescribeVo getContentDetail(int contentId) {
        return getSqlSession().selectOne(CLASS_NAME + SQL_GET_CONTENT_DETAIL, contentId);
    }

    @Override
    public List<ContentDescribeVo> searchContentDescribes(ContentVo contentVo) {
        return getSqlSession().selectList(CLASS_NAME + SQL_ID_SEARCH_CONTENT_DESCRIBES, contentVo);
    }

}
