package com.javaweb.springmvc.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.springmvc.DTO.UserModel;
import com.javaweb.springmvc.Service.IUserService;
@RestController
@Controller
public class UserControllerAPI {

	@Autowired
	IUserService userService;
	
	//thêm user ở trang admin
	@PostMapping(value = "/api-user")
	//@RequestMapping(value = "/api-user",method = RequestMethod.POST)
	public UserModel addUserAPI(@RequestBody UserModel model) {
		userService.addUser(model);
		return model;
	}
	//thêm user ở trang web
	@RequestMapping(value = "/api-user-web",method = RequestMethod.POST)
	public UserModel addUserAPIUser(@RequestBody UserModel model) {
		model.setStatus(1);
		model.setRoleCode("USER");
		model.setRoleid(2L);
		if(model.getPassword().equals(model.getRepeatPassword())) {
			userService.addUser(model);
		}
		return model;
		
	}
	
}
