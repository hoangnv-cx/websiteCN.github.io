package com.javaweb.springmvc.Service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.springmvc.DAO.ICategoryDAO;
import com.javaweb.springmvc.DTO.CategoryModel;
import com.javaweb.springmvc.Entity.CategoryEntity;
import com.javaweb.springmvc.Repository.ICategoryRepository;
import com.javaweb.springmvc.Service.ICategoryService;
import com.javaweb.springmvc.convert.CategoryConvert;
@Service
public class CategoryServiceImpl implements ICategoryService{

	@Autowired
	ICategoryDAO dao;
	@Autowired
	CategoryConvert categoryConvert;
	@Autowired
	ICategoryRepository categoryRepository;
	public List<CategoryModel> findAllCategory() {
		List<CategoryEntity> listEntity=dao.findAllCategory();
		List<CategoryModel> models=new ArrayList<CategoryModel>();
		for(CategoryEntity entity:listEntity) {
			CategoryModel model=new CategoryModel();
			model=categoryConvert.entityToDto(entity);
			models.add(model);
		}
		return models;
	}

	public List<CategoryModel> findOneCategory(String code) {
		List<CategoryEntity> listEntity=dao.findOneCategory(code);
		List<CategoryModel> models=new ArrayList<CategoryModel>();
		for(CategoryEntity entity:listEntity) {
			CategoryModel model=new CategoryModel();
			model=categoryConvert.entityToDto(entity);
			models.add(model);
		}
		return models;
	}

	public Map<String, String> findMapCategory() {
		List<CategoryEntity> list=dao.findAllCategory();
		Map<String, String> map=new HashMap<String, String>();
		for(CategoryEntity cat:list) {
			map.put(cat.getCode(), cat.getName());
		}
		return map;
	}

	public CategoryModel findOneCategoryCode(Long id) {
		
		CategoryEntity entity=categoryRepository.findOneById(id);
		CategoryModel model=new CategoryModel();
		model=categoryConvert.entityToDto(entity);
		return model;
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		CategoryEntity entity=categoryRepository.findOneByCode(code);
		CategoryModel model=new CategoryModel();
		if(entity!=null) {
			model=categoryConvert.entityToDto(entity);
			
		}
		return model;
	}

}
