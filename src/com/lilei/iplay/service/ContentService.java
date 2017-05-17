package com.lilei.iplay.service;

import java.util.List;

import com.lilei.iplay.exception.ParameterException;
import com.lilei.iplay.exception.ServiceException;
import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.ContentDescribeVo;

public interface ContentService {

    public List<ContentDescribeVo> findContentDescribes(Content content) throws ParameterException, ServiceException;
}
