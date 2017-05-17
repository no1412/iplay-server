package com.lilei.iplay.service.impl;

import java.util.List;

import com.lilei.iplay.dao.ContentDao;
import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.ContentDescribeVo;
import com.lilei.iplay.service.ContentService;

public class ContentServiceImpl implements ContentService {

    private ContentDao contentDao;
    
    @Override
    public List<ContentDescribeVo> findContentDescribes(Content content) throws ParameterException, ServiceException {
        return contentDao.findContentDescribes(content);
    }

    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }

}
