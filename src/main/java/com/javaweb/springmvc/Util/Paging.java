package com.javaweb.springmvc.Util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.springmvc.Service.INewService;

@Component
public class Paging {
	@Autowired
	INewService newService;
	public int get() {

		return 0;
	}
	
}
