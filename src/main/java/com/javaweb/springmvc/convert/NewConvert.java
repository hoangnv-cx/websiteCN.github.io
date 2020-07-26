package com.javaweb.springmvc.convert;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.springmvc.DTO.NewModel;
import com.javaweb.springmvc.Entity.NewEntity;
import com.javaweb.springmvc.Util.DateUtil;
import com.javaweb.springmvc.Util.SecurityUtils;
@Component
public class NewConvert {
	@Autowired
	DateUtil dateUtil;
	public NewEntity dtoToEntity(NewModel model) {
		NewEntity entity=new NewEntity();
		entity.setId(model.getId());
		entity.setTitle(model.getTitle());
		entity.setContent(model.getContent());	
		entity.setShortDescription(model.getShortDescription());
		entity.setThumbnail(model.getThumbnail());	
		entity.setCreatedBy(SecurityUtils.getName());
		entity.setCreateDate(new Timestamp(System.currentTimeMillis()));
		return entity;
	}
	public NewModel entityToDto(NewEntity entity) {
		NewModel model=new NewModel();
		model.setId(entity.getId());
		model.setTitle(entity.getTitle());
		model.setContent(entity.getContent());
		model.setCategoryid(entity.getCategoryid());
		model.setShortDescription(entity.getShortDescription());
		model.setThumbnail(entity.getThumbnail());
		if(entity.getModifiedBy()!=null&&entity.getModifiedDate()!=null) {
			model.setCreatedBy(entity.getCreatedBy());
			model.setModifiedBy(entity.getModifiedBy());
			
			//model.setTime(dateUtil.getTime(entity.getModifiedDate()));
		//	model.setTime(dateUtil.getDate(entity.getModifiedDate()));
			model.setDateUpdate(dateUtil.getDate(entity.getModifiedDate()));
			model.setDateNew(dateUtil.getDate(entity.getCreateDate()));
			
			model.setModifiedDate(entity.getModifiedDate());
			
			model.setTimeLine(dateUtil.getTimeLine(model.getDateUpdate()));
		}else {
			//model.setTime(dateUtil.getDate(entity.getCreateDate()));
			model.setDateNew(dateUtil.getDate(entity.getCreateDate()));
			model.setCreatedDate(entity.getCreateDate());
			model.setCreatedBy(entity.getCreatedBy());
			model.setTimeLine(dateUtil.getTimeLine(model.getDateNew()));
		}
		
		return model;
	}
}
