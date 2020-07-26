package com.javaweb.springmvc.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.springmvc.Entity.NewEntity;

public interface INewRepository extends JpaRepository<NewEntity, Integer> {
	//public NewEntity findByCategoryid(Long categoryId);
	public List<NewEntity> findAllByCategoryid(Long categoryId);
	List<NewEntity> findAllByOrderByIdDesc(Pageable pageable);
	List<NewEntity> findAllBycategoryidOrderByIdDesc(Pageable pageable,Long CategoryId);
	List<NewEntity> findByTitleContainingOrderByIdDesc(Pageable pageable,String title);
	List<NewEntity> findByTitleContaining(String title);
	NewEntity findOneById(Long id);
}
