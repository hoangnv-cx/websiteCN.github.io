package com.javaweb.springmvc.DAO;

import java.util.List;

import com.javaweb.springmvc.Entity.UserEntity;

public interface IUserDAO {

	
	void addUser(UserEntity entity);
	void updateUser(UserEntity entity);
	void deleteUser(Long id);
	UserEntity findOneUserById(Long id);
	List<UserEntity> findAllUser();	
	List<UserEntity> findUserPaging(int offset,int limit);
	List<UserEntity> findOneUser(String user);
	
}
