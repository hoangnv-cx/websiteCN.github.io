package com.javaweb.springmvc.DAO.impl;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.springmvc.DAO.INewDAO;
import com.javaweb.springmvc.Entity.NewEntity;
@Transactional
@Repository
public class NewDAOImpl implements INewDAO{

	@Autowired
	SessionFactory factory;
	
	public void addNew(NewEntity entity) {
		factory.getCurrentSession().save(entity);
		
	}

	public void updateNew(NewEntity entity) {
		factory.getCurrentSession().merge(entity);
		
	}

	public void deleteNew(Long id) {
		factory.getCurrentSession().delete(findOneNewById(id));
		
	}

	public NewEntity findOneNewById(Long id) {
		
		return factory.getCurrentSession().get(NewEntity.class, id);
	}


}
