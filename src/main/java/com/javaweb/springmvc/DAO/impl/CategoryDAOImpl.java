package com.javaweb.springmvc.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.springmvc.DAO.ICategoryDAO;
import com.javaweb.springmvc.Entity.CategoryEntity;

@Repository
@Transactional
public class CategoryDAOImpl implements ICategoryDAO{

	@Autowired
	SessionFactory factory;
	public List<CategoryEntity> findAllCategory() {
		Criteria criteria= factory.getCurrentSession().createCriteria(CategoryEntity.class);
		return criteria.list();
	}

	public List<CategoryEntity> findOneCategory(String code) {
		Criteria criteria= factory.getCurrentSession().createCriteria(CategoryEntity.class);
		criteria.add(Restrictions.like("code",code));
		return criteria.list();
	}

	public CategoryEntity findOneCategoryCode(Long id) {
			
		return factory.getCurrentSession().get(CategoryEntity.class, id);
	}

}
