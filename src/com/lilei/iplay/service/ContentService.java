package com.lilei.iplay.service;

import java.util.List;

import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.ContentDescribeVo;
import com.lilei.iplay.model.ContentVo;

public interface ContentService {

    public List<ContentDescribeVo> findContentDescribes(Content content) throws ParameterException, ServiceException;

    public List<ContentDescribeVo> searchContentDescribes(ContentVo contentVo) throws ParameterException, ServiceException;

    public int saveContent(Content content) throws ParameterException, ServiceException;

    public ContentDescribeVo getContentDetail(int contentId) throws ParameterException, ServiceException;
}
