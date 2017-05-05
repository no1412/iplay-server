package com.lilei.iplay.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.lilei.iplay.util.PropertyUtil;

/**
 * Created by ll on 2017/5/2.
 */

public class Food {
    private int id;
    private String title;
    private String foodSurface;
    private String content;
    private Date publishTime;
    private String sendTime;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
    public Date getPublishTime() {
        return publishTime;
    }
    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }
    public String getFoodSurface() {
        return PropertyUtil.getProjectUrl() + foodSurface;
    }
    public void setFoodSurface(String foodSurface) {
        this.foodSurface = foodSurface;
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
