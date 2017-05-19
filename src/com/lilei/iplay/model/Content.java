package com.lilei.iplay.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lilei.iplay.util.PropertyUtil;

/**
 * Created by ll on 2017/5/2.
 */

public class Content {
    private int id;
    private int userId;
    private String title;
    private String surface;
    private String contentDetail;
    private String cityCode;
    private String sendTime;
    private Date publishTime;
    private int typeId;

    public Content() {}

    public Content(String title, String surface, String contentDetail,
            String cityCode, Date publishTime, int typeId, int userId) {
        this.title = title;
        this.surface = surface;
        this.contentDetail = contentDetail;
        this.cityCode = cityCode;
        this.publishTime = publishTime;
        this.typeId = typeId;
        this.userId = userId;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContentDetail() {
        return contentDetail;
    }
    public void setContentDetail(String contentDetail) {
        this.contentDetail = contentDetail;
    }
    public Date getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    
    public String getSurface() {
//        if (StringUtils.isEmpty(surface)) {
//            return surface;
//        } else {
//            return PropertyUtil.getProjectUrl() + surface;
//        }
        return surface;
    }
    public void setSurface(String surface) {
        this.surface = surface;
    }
    public String getCityCode() {
        return cityCode;
    }
    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
    public int getTypeId() {
        return typeId;
    }
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    public String getSendTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String time = sdf.format(getPublishTime());
        return time.substring(0, time.length());
    }
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
