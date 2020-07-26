package com.javaweb.springmvc.convert;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.springmvc.DTO.HelpModel;
import com.javaweb.springmvc.Entity.HelpEntity;
import com.javaweb.springmvc.Util.DateUtil;
import com.javaweb.springmvc.Util.SecurityUtils;
@Component
public class HelpConvert {
	@Autowired
	DateUtil dateUtil;
	public HelpEntity dtoToEntity(HelpModel model) {
		HelpEntity entity=new HelpEntity();
		entity.setId(model.getId());
		entity.setUser(model.getUser());
		entity.setFirstName(model.getFirstName());
		entity.setMessage(model.getMessage());		
		entity.setSubject(model.getSubject());
		entity.setEmail(model.getEmail());
		entity.setTitle(model.getTitle());
		entity.setReply(model.getReply());
		entity.setCreatedBy(SecurityUtils.getName());
		entity.setCreateDate(new Timestamp(System.currentTimeMillis()));
		return entity;
	}
	public HelpModel entityToDto(HelpEntity entity) {
		HelpModel model=new HelpModel();
		model.setId(entity.getId());
		model.setUser(entity.getUser());
		model.setFirstName(entity.getFirstName());
		model.setMessage(entity.getMessage());
		
		  if(entity.getUsers()!=null) {
			  model.setAdmin(entity.getUsers().getUserName()); 
		  }
		 
		model.setSubject(entity.getSubject());
		model.setEmail(entity.getEmail());
		if(entity.getStatus().equals("0")) {
			model.setStatus("Chưa xử lý");
		}else {
			model.setStatus("Đã xử lý");
		}

		model.setTitle(entity.getTitle());
		model.setReply(entity.getReply());
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
