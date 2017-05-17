package com.lilei.iplay.dao;

import java.util.List;

import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.ContentDescribeVo;

public interface ContentDao {

    public List<ContentDescribeVo> findContentDescribes(Content content); 
}
