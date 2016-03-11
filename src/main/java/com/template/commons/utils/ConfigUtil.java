package com.template.commons.utils;

import java.util.ResourceBundle;

/** 
* @ClassName: ConfigUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Peter Jia
* @date 2016年3月9日 上午10:39:38 
*  
*/
public class ConfigUtil {

	private static final ResourceBundle bundle = java.util.ResourceBundle.getBundle("config");

	/**
	 * 获得sessionInfo名字
	 * 
	 * @return
	 */
	public static final String getSessionInfoName() {
		return bundle.getString("sessionInfoName");
	}

	/**
	 * 通过键获取值
	 * 
	 * @param key
	 * @return
	 */
	public static final String get(String key) {
		return bundle.getString(key);
	}

}