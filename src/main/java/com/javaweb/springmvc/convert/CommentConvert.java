package com.javaweb.springmvc.convert;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.springmvc.DTO.CommentModel;
import com.javaweb.springmvc.Entity.CommentEntity;
import com.javaweb.springmvc.Util.DateUtil;
@Component
public class CommentConvert {
	@Autowired
	DateUtil dateUtil;
	public CommentModel entityToDto(CommentEntity entity) {
		CommentModel model=new CommentModel();
		model.setId(entity.getId());
		model.setComments(entity.getComments());
		model.setUserid(entity.getUserid());
		model.setNewid(entity.getNewid());
		model.setUseridcomment(entity.getUseridcomment());
		//model.setCreatedBy(entity.getCreatedBy());
		//model.setCreatedDate(entity.getCreateDate());
		if(entity.getCreateDate()!=null&&entity.getCreatedBy()!=null){
			model.setDateNew(dateUtil.getDate(entity.getCreateDate()));
			model.setCreatedDate(entity.getCreateDate());
			model.setCreatedBy(entity.getCreatedBy());
			model.setTimeLine(dateUtil.getTimeLine(model.getDateNew()));
		}
		return model;
	}
	public CommentEntity dtoToEntity(CommentModel model) {
		CommentEntity entity=new CommentEntity();
		entity.setComments(model.getComments());
		entity.setUserid(model.getUserid());
		entity.setNewid(model.getNewid());
		entity.setCreatedBy(model.getUserName());
		entity.setCreateDate(new Timestamp(System.currentTimeMillis()) );
		if(model.getUseridcomment()!=null) {
			entity.setUseridcomment(model.getUseridcomment());
		}
	
		return entity;
	}
}
