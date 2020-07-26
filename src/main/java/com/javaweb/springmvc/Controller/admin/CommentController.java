package com.javaweb.springmvc.Controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.springmvc.DTO.CommentModel;
import com.javaweb.springmvc.Service.ICommentService;

@Controller
public class CommentController {
	@Autowired
	ICommentService commentService;
	@RequestMapping(value = "/admin-comment",method = RequestMethod.GET)
	public String adminComment(HttpServletRequest request,@RequestParam(value = "page")int page,@RequestParam(value = "limit")int limit) {
		Pageable pageable=PageRequest.of(page-1, limit);
		List<CommentModel> models=commentService.findAll(pageable);
		CommentModel model=new CommentModel();
		int totalItem=commentService.countComment();
		model.setPage(page);
		model.setTotalPage((int) Math.ceil((double) totalItem / limit));
		request.setAttribute("models", models);
		request.setAttribute("model", model);
		return "commentList";
	}
	@RequestMapping(value = "/admin-delete-comment",method = RequestMethod.GET)
	public String deleteComment(HttpServletRequest request,@RequestParam(value = "id") Long id) {
		commentService.deleteComment(id);
		return "redirect:/admin-comment?page=1&limit=4&message=delete_success";
	}
	@RequestMapping(value = "/admin-detail-comment",method = RequestMethod.GET)
	public String detailComment(HttpServletRequest request,@RequestParam(value = "id") Long id) {
		CommentModel model=commentService.findById(id);
		request.setAttribute("model", model);
		request.setAttribute("modelUser", commentService.findAllUserCommentUser(model.getId()));
		return "commentDetail";
	}
	
}
