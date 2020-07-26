package com.javaweb.springmvc.Controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaweb.springmvc.DTO.CommentModel;
import com.javaweb.springmvc.Service.ICommentService;

@Controller
public class CommentWebController {
	@Autowired
	ICommentService commentService;
	@RequestMapping(value = "/api-post-comment-user",method = RequestMethod.POST)
	public ModelAndView postComment(@RequestParam(value = "comments")String comments,
								@RequestParam(value = "userName")String userName,
								@RequestParam(value = "newid")Long newid,
								@RequestParam(value = "useridcomment")Long useridcomment){
		if(userName.equals("anonymousUser")) {
			return new ModelAndView("redirect:/login");
		}
		CommentModel model=new CommentModel();
		model.setComments(comments);
		model.setUserName(userName);
		model.setNewid(newid);
		model.setUseridcomment(useridcomment);
		commentService.addComment(model);
		return new ModelAndView("redirect:/web-item?id="+model.getNewid()+"");
		
	}
}
