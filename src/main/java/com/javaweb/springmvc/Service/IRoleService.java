package com.javaweb.springmvc.Service;

import com.javaweb.springmvc.DTO.RoleModel;

public interface IRoleService {
	RoleModel findOneRolebyId(Long id);
	
}
