package com.javaweb.springmvc.Service;

import java.util.List;
import java.util.Map;

import com.javaweb.springmvc.DTO.CategoryModel;

public interface ICategoryService {
	List<CategoryModel> findAllCategory();
	List<CategoryModel> findOneCategory(String code);
	Map<String, String> findMapCategory();
	CategoryModel findOneCategoryCode(Long id);
	CategoryModel findOneByCode(String code);
}
