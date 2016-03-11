package com.template.system.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.druid.util.StringUtils;
import com.template.commons.utils.ResponseMessage;
import com.template.system.entity.User;
import com.template.system.service.LoginServiceI;

/**
 * @ClassName: LoginController
 * @Description: (登录相关)
 * @author Peter Jia
 * @date 2016年3月9日 下午12:45:24
 * 
 */
@Controller
@RequestMapping("/system")
public class LoginController {

	private ResponseMessage responseMessage;

	@Autowired
	private LoginServiceI loginService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage Login(User user, HttpServletRequest req, HttpServletResponse res) {
		responseMessage = new ResponseMessage();
		if(StringUtils.isEmpty(user.getUsername()) || StringUtils.isEmpty(user.getPassword())){
			responseMessage.setCode(400);
			responseMessage.setMessage("用户名与密码不能为空!");
			return responseMessage;
		}
		User u = loginService.Login(user);
		if (u == null) {
			responseMessage.setCode(404);
			responseMessage.setMessage("输入的密码不正确!");
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("user", u);
			responseMessage.setCode(200);
		}
		return responseMessage;
	}

	@RequestMapping(value = "/isExist", method = RequestMethod.POST)
	@ResponseBody
	public ResponseMessage IsExist(User user) {
		responseMessage = new ResponseMessage();
		User u = loginService.IsExist(user);
		if (u == null) {
			responseMessage.setCode(404);
			responseMessage.setMessage("用户名不存在");
		} else {
			responseMessage.setCode(200);
			responseMessage.setMessage("用户名存在");
		}
		return responseMessage;
	}

}
