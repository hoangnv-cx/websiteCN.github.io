package com.javaweb.springmvc.Service;


import java.util.List;
import java.util.Map;

import com.javaweb.springmvc.DTO.UserModel;

public interface IUserService {
	void addUser(UserModel model);
	void updateUser(UserModel model);
	void deleteUser(Long id);
	UserModel findOneUserById(Long id);
	List<UserModel> findAllUser();
	//List<RoleModel> findAllRole();
	Map<String , String> findMapRole();
//	List<RoleModel> findOneRole(String code);
	List<UserModel> findUserPaging(int offset,int limit);
	int count();
	UserModel findByUserName(String name);

	
}
