package com.javaweb.springmvc.DAO.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.springmvc.DAO.ICommentDAO;
import com.javaweb.springmvc.Entity.CommentEntity;
@Repository
@Transactional
public class CommentDAOImpl implements ICommentDAO{

	@Autowired
	SessionFactory factory;
	@Override
	public void addComment(CommentEntity entity) {
		factory.getCurrentSession().save(entity);	
	}
	@Override
	public List<CommentEntity> findAllNewid(Long id) {
		Criteria criteria=factory.getCurrentSession().createCriteria(CommentEntity.class);
		criteria.add(Restrictions.lt("newid", id));
		return criteria.list();
	}
	@Override
	public void deleteComment(Long id) {
		factory.getCurrentSession().delete(findOneNewById(id));
		
	}
	@Override
	public CommentEntity findOneNewById(Long id) {
		return factory.getCurrentSession().get(CommentEntity.class, id);
		
	}
	
}
