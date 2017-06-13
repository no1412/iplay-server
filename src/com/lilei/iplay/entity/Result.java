package com.lilei.iplay.entity;

import org.apache.log4j.Logger;

/**
 * @ClassName: Result 
 * @Description: TODO(服务器返回文本) 
 * @author lilei 
 * @date 2017年5月23日 下午4:58:13
 */
public class Result {
    private Logger log = Logger.getLogger(Result.class);
	public static final String SUCCESS = "1";
	public static final String FAILED = "0";
	
	private String status = SUCCESS;
	private String tipCode = "";
	private String tipMsg = "";
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		if(status == null  ||  (!status.equals(SUCCESS) &&  !status.equals(FAILED))){
			log.error("status只允许以下值：" + SUCCESS + "、" + FAILED);
			throw new IllegalArgumentException("status只允许以下值：" + SUCCESS + "、" + FAILED);
		}
		this.status = status;
	}
	public String getTipCode() {
		return tipCode;
	}
	public void setTipCode(String tipCode) {
		this.tipCode = tipCode;
	}
	public String getTipMsg() {
		return tipMsg;
	}
	public void setTipMsg(String tipMsg) {
		this.tipMsg = tipMsg;
	}
}
