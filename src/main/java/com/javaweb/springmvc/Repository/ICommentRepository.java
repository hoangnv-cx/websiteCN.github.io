package com.javaweb.springmvc.Repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.javaweb.springmvc.Entity.CommentEntity;

public interface ICommentRepository extends JpaRepository<CommentEntity, Long>{
	//List<CommentEntity> findBycomments(Long id);
	List<CommentEntity> findAllByNewid(Long id);
	List<CommentEntity> findAllByOrderByIdDesc(Pageable pageable);
	void deleteByUseridcomment(Long id);
	List<CommentEntity> findAllByUseridcomment(Long id);
	CommentEntity findOneById(Long id);
}
