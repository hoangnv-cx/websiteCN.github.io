package com.javaweb.springmvc.convert;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.springmvc.DTO.UserModel;
import com.javaweb.springmvc.Entity.UserEntity;
import com.javaweb.springmvc.Util.DateUtil;
import com.javaweb.springmvc.Util.SecurityUtils;
@Component
public class UserConvert {
	@Autowired
	DateUtil dateUtil;
	public UserEntity dtoToEntity(UserModel model) {
		UserEntity entity=new UserEntity();
		entity.setId(model.getId());
		entity.setUserName(model.getUserName());
		entity.setEmail(model.getEmail());
		entity.setFullName(model.getFullName());
		entity.setSdt(model.getSdt());
		entity.setStatus(1);
		entity.setImage(model.getImage());
		entity.setRole(model.getRoleCode());
		entity.setSex(model.getSex());
		entity.setCreatedBy(SecurityUtils.getName());
		entity.setCreateDate(new Timestamp(System.currentTimeMillis()));
		return entity;
	}
	public UserModel entityToDto(UserEntity entity) {
		UserModel model=new UserModel();
		model.setId(entity.getId());
		model.setUserName(entity.getUserName());
		model.setPassword(entity.getPassword());
		model.setRoleid(entity.getRoleid());
		model.setEmail(entity.getEmail());
		model.setFullName(entity.getFullName());
		model.setSdt(entity.getSdt());
		model.setStatus(entity.getStatus());
		model.setImage(entity.getImage());
		model.setSex(entity.getSex());
		model.setDateofbirth(entity.getDateofbirth());
		if(entity.getModifiedBy()!=null&&entity.getModifiedDate()!=null) {
			model.setCreatedBy(entity.getCreatedBy());
			model.setModifiedBy(entity.getModifiedBy());
			
			//model.setTime(dateUtil.getTime(entity.getModifiedDate()));
		//	model.setTime(dateUtil.getDate(entity.getModifiedDate()));
			model.setDateUpdate(dateUtil.getDate(entity.getModifiedDate()));
			model.setDateNew(dateUtil.getDate(entity.getCreateDate()));
			
			model.setModifiedDate(entity.getModifiedDate());
			
			model.setTimeLine(dateUtil.getTimeLine(model.getDateUpdate()));
		}else if(entity.getCreateDate()!=null&&entity.getCreatedBy()!=null){
			//model.setTime(dateUtil.getDate(entity.getCreateDate()));
			model.setDateNew(dateUtil.getDate(entity.getCreateDate()));
			model.setCreatedDate(entity.getCreateDate());
			model.setCreatedBy(entity.getCreatedBy());
			model.setTimeLine(dateUtil.getTimeLine(model.getDateNew()));
		}
		return model;
	}
	
}
