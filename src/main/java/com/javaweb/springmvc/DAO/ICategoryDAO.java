package com.javaweb.springmvc.DAO;

import java.util.List;

import com.javaweb.springmvc.Entity.CategoryEntity;

public interface ICategoryDAO {

	List<CategoryEntity> findAllCategory();
	List<CategoryEntity> findOneCategory(String code);
	CategoryEntity findOneCategoryCode(Long id);
}
