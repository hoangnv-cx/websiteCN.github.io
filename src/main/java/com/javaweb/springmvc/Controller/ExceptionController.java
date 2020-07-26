package com.javaweb.springmvc.Controller;

import org.springframework.beans.factory.BeanCreationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionController {

//	@ExceptionHandler(value= {NoHandlerFoundException.class})
//	public String exceptionHandler(Exception exception) {
//		System.out.println(exception);
//		return "Error";
//	}
	@ExceptionHandler(value= {Exception.class})
	public String exceptionAll(Exception exception) {
		System.out.println(exception);
		return "Error";
	}
	@ExceptionHandler(value= {BeanCreationException.class})
	public String exceptionBean(Exception exception) {
		System.out.println(exception);
		return "Error";
	}
}
