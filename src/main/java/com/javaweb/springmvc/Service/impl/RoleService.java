package com.javaweb.springmvc.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.springmvc.DAO.IRoleDAO;
import com.javaweb.springmvc.DTO.RoleModel;
import com.javaweb.springmvc.Entity.RoleEntity;
import com.javaweb.springmvc.Repository.IRoleRepository;
import com.javaweb.springmvc.Service.IRoleService;
@Service
@Transactional
public class RoleService implements IRoleService{
	@Autowired
	IRoleDAO roleDAO;
	@Autowired
	IRoleRepository roleRepository;
	public RoleModel findOneRolebyId(Long id) {
		RoleEntity entity=roleDAO.findOneRolebyId(id);
		//RoleEntity entity=roleRepository.getOne(id);
		RoleModel model=new RoleModel();
		model.setId(entity.getId());
		model.setCode(entity.getCode());
		model.setName(entity.getName());
		return model;
	}
	
}
