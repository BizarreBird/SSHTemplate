package com.template.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 
* @ClassName: IndexController 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author Peter Jia
* @date 2016年3月9日 上午12:20:50 
*  
*/
@Controller
@RequestMapping("/system")
public class IndexController {

	@RequestMapping(value="/mainMapper", method = RequestMethod.GET)
	public String main(){
		System.out.println(123);
		return "views/system/layout/main";
	}
	
	@RequestMapping(value="/northMapper", method = RequestMethod.GET)
	public String north(){
		return "views/system/layout/north";
	}
	
	@RequestMapping(value="/westMapper", method = RequestMethod.GET)
	public String west(){
		return "views/system/layout/west";
	}
	
	@RequestMapping(value="/eastMapper", method = RequestMethod.GET)
	public String east(){
		return "views/system/layout/east";
	}
	
	@RequestMapping(value="/centerMapper", method = RequestMethod.GET)
	public String center(){
		return "views/system/layout/center";
	}
}
