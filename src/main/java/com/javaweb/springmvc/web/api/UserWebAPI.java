package com.javaweb.springmvc.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.springmvc.DTO.UserModel;
import com.javaweb.springmvc.Service.IUserService;

@RestController
public class UserWebAPI {
	
	@Autowired
	IUserService userService;
	@RequestMapping(value = "/post-web-user", method = RequestMethod.POST)
	public void updateWebUser(@RequestBody UserModel model ) {
		
		userService.updateUser(model);
	//	return "redirect:/web-user";
	}
}
