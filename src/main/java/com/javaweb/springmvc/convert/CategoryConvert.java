package com.javaweb.springmvc.convert;

import org.springframework.stereotype.Component;

import com.javaweb.springmvc.DTO.CategoryModel;
import com.javaweb.springmvc.Entity.CategoryEntity;
@Component
public class CategoryConvert {

	public CategoryModel entityToDto(CategoryEntity entity) {
		CategoryModel model=new CategoryModel();
		model.setId(entity.getId());
		model.setCode(entity.getCode());
		model.setName(entity.getName());
		return model;
	}
	public CategoryEntity dtoToEntity(CategoryModel model) {
		CategoryEntity entity=new CategoryEntity();
		entity.setId(model.getId());
		entity.setCode(model.getCode());
		entity.setName(model.getName());
		return entity;
	}
}
