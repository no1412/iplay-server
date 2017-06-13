package com.lilei.iplay.service.impl;

import java.util.List;

import com.lilei.iplay.dao.ContentDao;
import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.ContentDescribeVo;
import com.lilei.iplay.model.ContentVo;
import com.lilei.iplay.service.ContentService;

public class ContentServiceImpl implements ContentService {

    private ContentDao contentDao;

    @Override
    public List<ContentDescribeVo> findContentDescribes(Content content)
            throws ParameterException, ServiceException {
        return contentDao.findContentDescribes(content);
    }

    @Override
    public int saveContent(Content content)
            throws ParameterException, ServiceException {
        contentDao.saveContent(content);
        return content.getId();
    }

    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }

    @Override
    public ContentDescribeVo getContentDetail(int contentId)
            throws ParameterException, ServiceException {
        return contentDao.getContentDetail(contentId);
    }

    @Override
    public List<ContentDescribeVo> searchContentDescribes(ContentVo contentVo)
            throws ParameterException, ServiceException {
        return contentDao.searchContentDescribes(contentVo);
    }

}
