package com.lilei.iplay.model;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import com.lilei.iplay.util.PropertyUtil;

/**
 * Created by ll on 2017/5/2.
 */

public class Entertainment {
    private int id;
    private String title;
    private String entertainmentSurface;
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
    public String getEntertainmentSurface() {
        if (StringUtils.isEmpty(entertainmentSurface)) {
            return entertainmentSurface;
        } else {
            return PropertyUtil.getProjectUrl() + entertainmentSurface;
        }
    }
    public void setEntertainmentSurface(String entertainmentSurface) {
        this.entertainmentSurface = entertainmentSurface;
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
    public String getSendTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");
        String time = sdf.format(getPublishTime());
        return time.substring(0, time.length());
    }
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }
}
