package com.javaweb.springmvc.DAO;

import java.util.List;

import com.javaweb.springmvc.Entity.CommentEntity;

public interface ICommentDAO {
	void addComment(CommentEntity entity);
	List<CommentEntity> findAllNewid(Long id);
	void deleteComment(Long id);
	CommentEntity findOneNewById(Long id);
	
}
