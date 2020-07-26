package com.javaweb.springmvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.springmvc.Entity.RoleEntity;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long>{
	public RoleEntity findOneByCode(String code);
	public RoleEntity findOneById(Long id);
	

}
