package com.javaweb.springmvc.Controller.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.javaweb.springmvc.DTO.UserModel;
@Controller
public class LoginController {
	
	//trang đăng nhập
	@RequestMapping(value = "/login" ,method = RequestMethod.GET)
	public ModelAndView login() {		
		
		return new ModelAndView("login");
	}
	
	//trang đăng kí
	@RequestMapping(value = "/signin" ,method = RequestMethod.GET)
	public ModelAndView signin(HttpServletRequest request) {		
		request.setAttribute("user", new UserModel());
		return new ModelAndView("signin");
	}

}
