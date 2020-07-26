package com.javaweb.springmvc.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.javaweb.springmvc.DAO.IRoleDAO;
import com.javaweb.springmvc.DAO.IUserDAO;
import com.javaweb.springmvc.DTO.UserModel;
import com.javaweb.springmvc.Entity.RoleEntity;
import com.javaweb.springmvc.Entity.UserEntity;
import com.javaweb.springmvc.Repository.IRoleRepository;
import com.javaweb.springmvc.Repository.IUserRepository;
@Service

public class MyUserDetailsService implements UserDetailsService {
	@Autowired
	IUserRepository user;
	@Autowired
	IRoleRepository role;
	@Autowired
	IUserDAO dao;

	@Autowired
	IRoleDAO roleDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity entitys=user.findByUserName(username);
		if (entitys == null) {
            throw new UsernameNotFoundException("User not found");
        }
		//List<UserEntity> entitys=dao.findOneUser(username);
		//List<UserModel> models=new ArrayList<UserModel>();
		//for(UserEntity entity:entitys) {
	//	UserEntity userEntity=user.findOneByCode(username);
			UserModel model=new UserModel();
			model.setId(entitys.getId());
			model.setUserName(entitys.getUserName());
			model.setPassword(entitys.getPassword());
			//passwordEncoder.encode(
			model.setRoleid(entitys.getRoleid());
			model.setRoleCode(entitys.getRole());
		//	models.add(model);
		///}
		//UserModel model=models.get(0);
		//RoleEntity roleEntities=role.findOneByCode(model.getRoleCode());
		RoleEntity roleEntities=role.findOneById(model.getRoleid());
	//	Optional<RoleEntity> roleEntities=role.findById(model.getRoleid());
		 List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
		 if(roleEntities!= null)  {
	           
	                // ROLE_USER, ROLE_ADMIN,..
	                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" +roleEntities.getCode());
	                grantList.add(authority);
	           
	        }
		 UserDetails userDetails = (UserDetails) new User(model.getUserName(), 
	                model.getPassword(),grantList);
		return userDetails;
	}

}
