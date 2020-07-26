package com.javaweb.springmvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.springmvc.Entity.CategoryEntity;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long>{
	public CategoryEntity findOneByCode(String code);
	CategoryEntity findOneById(Long id);
}
