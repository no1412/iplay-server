package com.lilei.iplay.dao;

import java.util.List;

import com.lilei.iplay.model.Content;
import com.lilei.iplay.model.ContentDescribeVo;
import com.lilei.iplay.model.ContentVo;

public interface ContentDao {

    public List<ContentDescribeVo> findContentDescribes(Content content);

    public List<ContentDescribeVo> searchContentDescribes(ContentVo contentVo);

    public int saveContent(Content content);

    public ContentDescribeVo getContentDetail(int contentId);
}
