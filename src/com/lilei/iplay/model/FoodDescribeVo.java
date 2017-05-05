package com.lilei.iplay.model;

import com.lilei.iplay.util.PropertyUtil;

public class FoodDescribeVo extends Food {

    private String nickName;
    private String headPicUrl;

    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
    public String getHeadPicUrl() {
        return PropertyUtil.getProjectUrl() + headPicUrl;
    }
    public void setHeadPicUrl(String headPicUrl) {
        this.headPicUrl = headPicUrl;
    }
}
