package com.javaweb.springmvc.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.springmvc.Entity.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long>{
	public UserEntity findByUserName(String name);
	UserEntity findOneById(Long id);

	
}
