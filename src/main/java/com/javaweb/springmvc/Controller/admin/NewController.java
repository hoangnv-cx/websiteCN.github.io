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
import org.springframework.web.servlet.ModelAndView;

import com.javaweb.springmvc.DTO.CategoryModel;
import com.javaweb.springmvc.DTO.NewModel;
import com.javaweb.springmvc.Service.ICategoryService;
import com.javaweb.springmvc.Service.INewService;
import com.javaweb.springmvc.Util.MessengerUtil;
@Controller
public class NewController {

	@Autowired
	INewService newService;
	@Autowired
	ICategoryService categoryService;
	//admin-danh sách bài viết
	@RequestMapping(value = "/admin-list-new",method = RequestMethod.GET)
	public ModelAndView getListNew(HttpServletRequest request,@RequestParam(value = "page")int page
			,@RequestParam(value = "limit")int limit) {
		Pageable pageable=PageRequest.of(page-1, limit);
		List<NewModel> listModel1=newService.find(pageable);
		NewModel model=new NewModel();
		int totalItem=newService.count();
		model.setPage(page);
		model.setTotalPage((int) Math.ceil((double) totalItem / limit));
		MessengerUtil.showMessage(request);
		request.setAttribute("model", model);
		request.setAttribute("news", listModel1);
		return new ModelAndView("adminListNew");
	}
	//admin-thêm bài viết
	@RequestMapping(value = "/admin-add-new",method = RequestMethod.GET)
	public ModelAndView getEditNewadd(HttpServletRequest request) {	
		NewModel model=new NewModel();		
		request.setAttribute("categorys", categoryService.findMapCategory());
		request.setAttribute("model", model);
		return new ModelAndView("adminEditNew");
	}
	//admin-sửa bài viết
	@RequestMapping(value = "/admin-update-new",method = RequestMethod.GET)
	public ModelAndView getEditNew(HttpServletRequest request
			,@RequestParam(value = "id")Long id) {
			NewModel model=newService.findOneNewById(id);
			CategoryModel cat=categoryService.findOneCategoryCode(model.getCategoryid());
			model.setCategoryCode(cat.getCode());
			request.setAttribute("categorys", categoryService.findMapCategory());
			request.setAttribute("model", model);	
			return new ModelAndView("adminEditNew");
	}
	//admin-xóa 1 bài viết
	@RequestMapping(value = "/admin-delete-one-new",method = RequestMethod.GET)
	public ModelAndView deleteNew(HttpServletRequest request
			,@RequestParam(value = "id")Long id) {
		newService.deleteNew(id);

		return new ModelAndView("redirect:/admin-list-new?page=1&limit=4&message=delete_success");
	}
	//admin-chi tiết một bài viết
	@RequestMapping(value = "/admin-detail-new",method = RequestMethod.GET)
	public ModelAndView detailNew(HttpServletRequest request
			,@RequestParam(value = "id")Long id) {
			NewModel model=newService.findOneNewById(id);
			CategoryModel cat=categoryService.findOneCategoryCode(model.getCategoryid());
			
			
			model.setCategoryName(cat.getName());
			request.setAttribute("model", model);	
			return new ModelAndView("adminDetailNew");
	}
	
}
