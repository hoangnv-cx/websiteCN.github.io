package com.javaweb.springmvc.DAO.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.springmvc.DAO.IHelpDAO;
import com.javaweb.springmvc.Entity.HelpEntity;
@Repository
@Transactional
public class HelpDAOImlp implements IHelpDAO{

	@Autowired
	SessionFactory factory;
	@Override
	public void addHelp(HelpEntity entity) {
		factory.getCurrentSession().save(entity);
		
	}
	@Override
	public void updateHelp(HelpEntity entity) {
		factory.getCurrentSession().merge(entity);
		
	}

}
