package com.javaweb.springmvc.admin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.springmvc.DTO.CommentModel;
import com.javaweb.springmvc.Service.ICommentService;

@RestController
public class CommentControllerAPI {
	@Autowired
	ICommentService commentService;
	@RequestMapping(value = "/api-comment",method = RequestMethod.POST)
	public CommentModel postComment(@RequestBody CommentModel model) {
		if(model.getUserName().equals("anonymousUser")) {
			
			return null;
		}
		commentService.addComment(model);
		return model;
		
	}
}
