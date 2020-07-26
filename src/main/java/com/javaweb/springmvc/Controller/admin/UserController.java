package com.javaweb.springmvc.Controller.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.javaweb.springmvc.DTO.RoleModel;
import com.javaweb.springmvc.DTO.UserModel;
import com.javaweb.springmvc.Service.IRoleService;
import com.javaweb.springmvc.Service.IUserService;
import com.javaweb.springmvc.Util.MessengerUtil;

@Controller
public class UserController {
	@Autowired
	IUserService userService;
	@Autowired
	IRoleService roleService;
	
	
		//trang quản trị tài khoản
		@RequestMapping(value = "/admin-list-user",method = RequestMethod.GET)
		public ModelAndView listUSer(HttpServletRequest request,@RequestParam(value = "page")int page
				,@RequestParam(value = "limit") int limit) {
			int offset=((page-1)*limit);
			List<UserModel> list=userService.findUserPaging(offset, limit);
			UserModel model=new UserModel();
			int totalItem=userService.count();
			model.setPage(page);
			model.setTotalPage((int) Math.ceil((double) totalItem / limit));
			request.setAttribute("user", list);
			request.setAttribute("model", model);
			MessengerUtil.showMessage(request);
			return new ModelAndView("adminListUser");
		}
		//admin-thêm tài khoarn	khoản
		@RequestMapping(value = "/admin-add-user",method = RequestMethod.GET)
		public ModelAndView addUserNew(HttpServletRequest request) {
			UserModel model=new UserModel();
			request.setAttribute("user", model);
			request.setAttribute("rolec", userService.findMapRole());	
			return new ModelAndView("adminAddUser");
		}
		//admin-cập nhật tài khoản
		@RequestMapping(value = "/admin-edit-user",method = RequestMethod.GET)
		public ModelAndView getUSer(HttpServletRequest request,@RequestParam(value = "id")Long id ) {
			UserModel model=userService.findOneUserById(id);
			RoleModel role=roleService.findOneRolebyId(model.getRoleid());
			model.setRoleCode(role.getCode());
			request.setAttribute("user",model );
			request.setAttribute("rolec", userService.findMapRole());	
			return new ModelAndView("adminEditUser");
		}
		//admin-api thêm tài khoản
		@RequestMapping(value = "/admin-put-edit-user",method = RequestMethod.POST)
		public String putUser(HttpServletRequest request,@ModelAttribute(value = "user")UserModel user
				,@RequestParam(value = "passwordNew")String pass,@RequestParam(value = "retypePassword")String retype) {	
			if(pass.equals(retype)&pass!=user.getPassword()) {
				user.setPassword(pass);
				userService.updateUser(user);
			}
			return "redirect:/admin-list-user?page=1&limit=4";
			
		}
		@RequestMapping(value = "/admin-detail-user",method = RequestMethod.GET)
		public ModelAndView detailUSer(HttpServletRequest request,@RequestParam(value = "id")Long id ) {
			
			UserModel model=userService.findOneUserById(id);
			
			request.setAttribute("userModel", model);	
			return new ModelAndView("adminDetailUser");
		}
		
		
}
