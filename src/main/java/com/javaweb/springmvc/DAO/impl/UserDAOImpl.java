package com.javaweb.springmvc.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaweb.springmvc.DAO.IUserDAO;
import com.javaweb.springmvc.Entity.UserEntity;
@Repository
public class UserDAOImpl implements IUserDAO{
	@Autowired
	SessionFactory factory;
	public void addUser(UserEntity entity) {
		factory.getCurrentSession().save(entity);
		
	}

	public void updateUser(UserEntity entity) {
		factory.getCurrentSession().merge(entity);
		
		
	}

	public void deleteUser(Long id) {
		factory.getCurrentSession().delete(findOneUserById(id));
		
	}

	public UserEntity findOneUserById(Long id) {
		
		return (UserEntity) factory.getCurrentSession().get(UserEntity.class, id);
	}

	public List<UserEntity> findAllUser() {
		
		Criteria criteria=factory.getCurrentSession().createCriteria(UserEntity.class);
		return criteria.list();
	}

	

	public List<UserEntity> findUserPaging(int offset, int limit) {
		Criteria criteria=factory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.setFirstResult(offset);
		criteria.setMaxResults(limit);
		return criteria.list();
	}

	@Override
	public List<UserEntity> findOneUser(String user) {
		Criteria criteria=factory.getCurrentSession().createCriteria(UserEntity.class);
		criteria.add(Restrictions.like("user",user));
		
		return criteria.list();
	}

	
	
	
	
	



}
