package com.javaweb.springmvc.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.javaweb.springmvc.DTO.CommentModel;

public interface ICommentService {
	void addComment(CommentModel model);
	List<CommentModel> findAllNewComment(Long id);
	List<CommentModel> findAllNewCommentUser(Long id);
	List<CommentModel> findAll(Pageable pageable);
	int countComment();
	void deleteComment(Long id);
	CommentModel findById(Long id) ;
	List<CommentModel> findAllUserCommentUser(Long id);
}
