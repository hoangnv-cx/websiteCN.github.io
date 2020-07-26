package com.javaweb.springmvc.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.springmvc.DTO.HelpModel;
import com.javaweb.springmvc.Service.IHelpService;
import com.javaweb.springmvc.Util.SecurityUtils;

@RestController
public class HelpControllerAPI {

	@Autowired
	IHelpService helpService;
	@RequestMapping(value = "/api-put-help",method = RequestMethod.PUT)
	public HelpModel putHelp(@RequestBody HelpModel model) {
			helpService.updateHelp(model);
		return model;
	}
	//web-trang trợ giúp
			@PostMapping(value = "/web-help")
			public HelpModel webHelpPost(@RequestBody HelpModel model) {
				
				if(SecurityUtils.getName()!=null) {
					model.setUser(SecurityUtils.getName());
				}
				
				helpService.addHelp(model);
				
				
				return model;		
			}
}
