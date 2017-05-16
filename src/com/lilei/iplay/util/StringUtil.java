package com.lilei.iplay.util;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtil {

	/**
	 * @Title: isEmpty 
	 * @Description: TODO(判断字符串是不是为空) 
	 * @param @param str
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public static boolean isEmpty(String str) {
		if (str == null || str.equals("")) {
			return true;
		}
		return false;
	}
	/**
	 * @Title: createFileName 
	 * @Description: TODO(创建一个随机文件的名字 time+hashcode) 
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	public static String createFileName() {
	    Date date = new Date();
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String time = sdf.format(date);
	    time = time.replaceAll("-", "").replaceAll(" ", "").replaceAll(":", "");
	    return (time + time.hashCode()).replace("-", "_");
	}
}