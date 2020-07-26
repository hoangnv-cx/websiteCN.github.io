package com.javaweb.springmvc.Service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaweb.springmvc.DAO.IRoleDAO;
import com.javaweb.springmvc.DAO.IUserDAO;
import com.javaweb.springmvc.DTO.UserModel;
import com.javaweb.springmvc.Entity.RoleEntity;
import com.javaweb.springmvc.Entity.UserEntity;
import com.javaweb.springmvc.Repository.IRoleRepository;
import com.javaweb.springmvc.Repository.IUserRepository;
import com.javaweb.springmvc.Service.IUserService;
import com.javaweb.springmvc.Util.SecurityUtils;
import com.javaweb.springmvc.convert.UserConvert;
@Service
@Transactional
public class UserServiceImpl implements IUserService{
	@Autowired
	IRoleDAO roleDao;
	@Autowired
	IUserDAO daoImpl;
	@Autowired
	IRoleRepository roleRepository;
	@Autowired
	IUserRepository userRepository;
	@Autowired
	UserConvert userConvert;
  @Autowired 
  private PasswordEncoder passwordEncoder;

	public void addUser(UserModel model) {
		
		UserEntity entitys=userRepository.findByUserName(model.getUserName());
		if(entitys!=null) {
			
		}else {
			RoleEntity roleEntity=roleRepository.findOneByCode(model.getRoleCode());
			UserEntity entity=new UserEntity();
			entity=userConvert.dtoToEntity(model);
			entity.setPassword(passwordEncoder.encode(model.getPassword()));
			entity.setRoleid(roleEntity.getId());

			daoImpl.addUser(entity);
			//userRepository.save(entity);
		}
		
		
	}

	public void updateUser(UserModel model) {
		UserEntity entity=new UserEntity();
		RoleEntity roleEntity=roleRepository.findOneByCode(model.getRoleCode());
		UserEntity entity2=userRepository.findOneById(model.getId());
		if(entity2!=null) {
			entity=userConvert.dtoToEntity(model);
			
			entity.setPassword(passwordEncoder.encode(model.getPassword()));
			entity.setRoleid(roleEntity.getId());
			entity.setCreateDate(entity2.getCreateDate());
			entity.setCreatedBy(entity2.getCreatedBy());
			entity.setModifiedBy(SecurityUtils.getName());
			entity.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			daoImpl.updateUser(entity);
		}
		
	}

	public void deleteUser(Long id) {
		UserEntity entity=daoImpl.findOneUserById(id);
		if(entity!=null) {
			daoImpl.deleteUser(id);
		}
	}

	public UserModel findOneUserById(Long id) {
		UserEntity entity=daoImpl.findOneUserById(id);
		UserModel model=new UserModel();

		model=userConvert.entityToDto(entity);
		model.setRoleName(roleRepository.findOneById(model.getRoleid()).getName());
		return model;
	}

	public List<UserModel> findAllUser() {
		List<UserEntity> list=daoImpl.findAllUser();
		List<UserModel> models=new ArrayList<UserModel>();
		
		for(UserEntity user:list) {
			
			UserModel model=new UserModel();

			model=userConvert.entityToDto(user);
			models.add(model);
		}
		return models;
	}



	public Map<String, String> findMapRole() {
		List<RoleEntity> list=roleDao.findAllRole();
		Map<String , String> map=new HashMap<String, String>();
		for(RoleEntity role:list) {
			map.put(role.getCode(), role.getName());
		}
		return map;
	}



	public List<UserModel> findUserPaging(int offset, int limit) {
		List<UserEntity> entities=daoImpl.findUserPaging(offset, limit);
		List<UserModel> models=new ArrayList<UserModel>();
		for(UserEntity user:entities) {
			UserModel model=new UserModel();
			

			model=userConvert.entityToDto(user);
			model.setRoleName(roleRepository.findOneById(model.getRoleid()).getName());
			models.add(model);
		}
		return models;
	}

	public int count() {
		return (int) userRepository.count();
	}

	@Override
	public UserModel findByUserName(String name) {
		UserEntity user=userRepository.findByUserName(name);
		if(user!=null) {
			UserModel model=new UserModel();

			model=userConvert.entityToDto(user);
			return model;
		}
		return null;
	}

	


}
