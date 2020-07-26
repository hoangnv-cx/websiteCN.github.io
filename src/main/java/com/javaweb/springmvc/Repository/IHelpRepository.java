package com.javaweb.springmvc.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.springmvc.Entity.HelpEntity;

public interface IHelpRepository extends JpaRepository<HelpEntity, Long>{
	List<HelpEntity> findAllByOrderByIdDesc(Pageable pageable);
	HelpEntity findOneById(Long id);
}
