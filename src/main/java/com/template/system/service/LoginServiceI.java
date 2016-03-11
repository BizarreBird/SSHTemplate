package com.template.system.service;

import com.template.system.entity.User;

/** 
* @ClassName: LoginServiceI 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Peter Jia
* @date 2016年3月9日 下午12:47:03 
*  
*/
public interface LoginServiceI {

	public User Login(User user);
	
	public User IsExist(User user);
	
	public User LoginOut();
	
}
