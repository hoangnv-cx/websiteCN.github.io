package com.javaweb.springmvc.DAO;

import java.util.List;

import com.javaweb.springmvc.Entity.RoleEntity;

public interface IRoleDAO {
	RoleEntity findOneRolebyId(Long id);
	List<RoleEntity> findAllRole();
	List<RoleEntity> findOneRole(String code);
}
