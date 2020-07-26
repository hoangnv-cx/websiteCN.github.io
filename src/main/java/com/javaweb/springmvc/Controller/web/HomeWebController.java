package com.javaweb.springmvc.Controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaweb.springmvc.DTO.CategoryModel;
import com.javaweb.springmvc.DTO.CommentModel;
import com.javaweb.springmvc.DTO.HelpModel;
import com.javaweb.springmvc.DTO.NewModel;
import com.javaweb.springmvc.DTO.UserModel;
import com.javaweb.springmvc.Service.ICategoryService;
import com.javaweb.springmvc.Service.ICommentService;
import com.javaweb.springmvc.Service.IHelpService;
import com.javaweb.springmvc.Service.INewService;
import com.javaweb.springmvc.Service.IUserService;
import com.javaweb.springmvc.Util.MessengerUtil;
import com.javaweb.springmvc.Util.SecurityUtils;
import com.javaweb.springmvc.Util.SendEmail;

@Controller

public class HomeWebController {
	@Autowired
	INewService newService;
	@Autowired 
	ICategoryService categoryService;
	@Autowired
	IUserService userService;
	@Autowired
	SendEmail sendMail;
	@Autowired
    JavaMailSender emailSender;
	@Autowired
	IHelpService helpService;
	@Autowired
	ICommentService commentService;
	
	//trang chủ chính
	@RequestMapping(value = "/web",method = RequestMethod.GET)
	public String t(HttpServletRequest request,@RequestParam(value = "page")int page
			,@RequestParam(value = "limit")int limit) {
		
		Pageable pageable=PageRequest.of(page-1, limit);
		List<NewModel> listModel1=newService.find(pageable);
		NewModel model=new NewModel();
		int totalItem=newService.count();
		model.setPage(page);
		model.setTotalPage((int) Math.ceil((double) totalItem / limit));
		request.setAttribute("model", model);
		request.setAttribute("listCat", categoryService.findAllCategory());
		//Pageable pageables=PageRequest.of(1, 5);
		//List<NewModel> list=newService.find(pageables);
		request.setAttribute("newTop", listModel1);
		request.setAttribute("dataNew", listModel1);
		MessengerUtil.showMessage(request);
		return "homeWeb";
		
	}
	//trang 1 bài viết
		@RequestMapping(value = "/web-item",method = RequestMethod.GET)
		public String itemNew(HttpServletRequest request,@RequestParam(value = "id")Long id) {
			NewModel model=newService.findOneNewById(id);
			CategoryModel categoryModel=categoryService.findOneCategoryCode(model.getCategoryid());
			Pageable pageable=PageRequest.of(1, 3);
			List<NewModel> listModel1=newService.find(pageable);
			model.setCategoryName(categoryModel.getName());
			request.setAttribute("ListNew", listModel1);
			request.setAttribute("newModel", model);
		//	request.setAttribute("itemCat", categoryModel);
			request.setAttribute("listCat", categoryService.findAllCategory());
			request.setAttribute("comment", new CommentModel());
			List<CommentModel> commentModels=commentService.findAllNewComment(id);
			request.setAttribute("listComment", commentModels);
			List<CommentModel> commentModelUser=commentService.findAllNewCommentUser(id);
			request.setAttribute("listCommentUser", commentModelUser);
			
			return "itemNew";
			
		}
		//trang thể loại
		@RequestMapping(value = "/web-category",method = RequestMethod.GET)
		public String categoryNew(HttpServletRequest request,@RequestParam(value = "CategoryCode")String CategoryCode
				,@RequestParam(value = "page")int page
				,@RequestParam(value = "limit")int limit) {
			CategoryModel model1=categoryService.findOneByCode(CategoryCode);
			
			
			
			NewModel model=new NewModel();
			Pageable pageable=PageRequest.of(page-1, limit);
			List<NewModel> list1=newService.findAllBycategoryidOrderByIdDesc(pageable, model1.getId());
			
			int totalItem=newService.countByCategory(model1.getId());
			
			model.setPage(page);
			model.setTotalPage((int) Math.ceil((double) totalItem / limit));
			request.setAttribute("model", model);
			
			request.setAttribute("modelCategory", model1.getName());
			request.setAttribute("listCat", categoryService.findAllCategory());	
			request.setAttribute("listNew", list1);
			request.setAttribute("CategoryCode", CategoryCode);
			
			return "category";
					
		}
		//web-trang thông tin
		@RequestMapping(value = "/web-about",method = RequestMethod.GET)
		public String webAbout(HttpServletRequest request) {
			
			request.setAttribute("listCat", categoryService.findAllCategory());	
			
			
			return "about";
					
		}
		//web-trang trợ giúp
		@RequestMapping(value = "/web-help",method = RequestMethod.GET)
		public String webHelp(HttpServletRequest request) {
			
			request.setAttribute("listCat", categoryService.findAllCategory());	
			request.setAttribute("mail", new HelpModel());
			MessengerUtil.showMessage(request);
			return "help";
					
		}
		
		//web-trang quản lí tài khoản
		@RequestMapping(value = "/web-user",method = RequestMethod.GET)
		public String user(HttpServletRequest request) {
			String name=SecurityUtils.getName();
			UserModel model=userService.findByUserName(name);
			request.setAttribute("user", model);
			return "user";
		}
		//web-tìm kiếm
		@RequestMapping(value = "/web-search",method = RequestMethod.GET)
		public String search(HttpServletRequest request,@RequestParam(value = "search") String search
				,@RequestParam(value = "page")int page
				,@RequestParam(value = "limit")int limit) {
			
			NewModel model=new NewModel();
			Pageable pageable=PageRequest.of(page-1, limit);
			List<NewModel> models=newService.findByTitleContaining(pageable,search);
			int totalItem=newService.countBySearch(search);
			model.setPage(page);
			model.setTotalPage((int) Math.ceil((double) totalItem / limit));
			request.setAttribute("model", model);
			request.setAttribute("newSearch", models);
			request.setAttribute("search", search);
			return "search";
		}
		
		
}
