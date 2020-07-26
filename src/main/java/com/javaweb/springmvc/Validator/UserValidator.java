package com.javaweb.springmvc.Validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.javaweb.springmvc.DTO.UserModel;

public class UserValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return UserModel.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		UserModel model=(UserModel) target;
		if(model.getUserName()==null||model.getUserName().length()==0) {
			errors.rejectValue("userName", "field.required");
			
		}
		ValidationUtils.rejectIfEmpty(errors, "password","field.required" );
		
		if(model.getPassword().length()<4 || model.getPassword().length()>12) {
			errors.rejectValue("password", "password.invalid");
			
		}
	}

}
