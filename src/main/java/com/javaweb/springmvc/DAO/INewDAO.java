package com.javaweb.springmvc.DAO;

import com.javaweb.springmvc.Entity.NewEntity;

public interface INewDAO {
	void addNew(NewEntity entity);
	void updateNew(NewEntity entity);
	void deleteNew(Long id);
	NewEntity findOneNewById(Long id);
	//List<NewEntity> findAllNew();
//	List<NewEntity> find(int offset,int limit);
	//Long count(Long categoryId);
}
