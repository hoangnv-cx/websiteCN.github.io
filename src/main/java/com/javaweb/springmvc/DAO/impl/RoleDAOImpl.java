package com.javaweb.springmvc.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaweb.springmvc.DAO.IRoleDAO;
import com.javaweb.springmvc.Entity.RoleEntity;
@Repository
public class RoleDAOImpl implements IRoleDAO{
	@Autowired
	SessionFactory factory;
	public RoleEntity findOneRolebyId(Long id) {
		return factory.getCurrentSession().get(RoleEntity.class, id);
	}
	public List<RoleEntity> findAllRole() {
		Criteria criteria=factory.getCurrentSession().createCriteria(RoleEntity.class);
		return criteria.list();
	}

	public List<RoleEntity> findOneRole(String code) {
		Criteria criteria=factory.getCurrentSession().createCriteria(RoleEntity.class);
		criteria.add(Restrictions.like("code",code));
		
		return criteria.list();
	}

}
