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

import com.javaweb.springmvc.DTO.HelpModel;
import com.javaweb.springmvc.Service.IHelpService;
import com.javaweb.springmvc.Service.IUserService;
import com.javaweb.springmvc.Util.MessengerUtil;

@Controller
public class HelpController {

	@Autowired
	IUserService userService;
	@Autowired
	IHelpService helpService;
	
	//admin-trang list trợ giúp
	@RequestMapping(value = "/admin-help",method = RequestMethod.GET)
	public ModelAndView getListHelp(HttpServletRequest request,@RequestParam(value = "page")int page
			,@RequestParam(value = "limit")int limit) {
		Pageable pageable=PageRequest.of(page-1, limit);
		List<HelpModel> listModel=helpService.findAll(pageable);
		HelpModel model=new HelpModel();
		int totalItem=helpService.countHelp();
		model.setPage(page);
		model.setTotalPage((int) Math.ceil((double) totalItem / limit));
		request.setAttribute("model", model);
		request.setAttribute("help", listModel);
		MessengerUtil.showMessage(request);
		return new ModelAndView("helpList");
	}
	//admin-trang xử lí trả lời mail
	@RequestMapping(value = "/admin-help-edit",method = RequestMethod.GET)
	public String editHelp(HttpServletRequest request,@RequestParam(value = "id") Long id) {
		HelpModel model=helpService.findOneById(id);
		request.setAttribute("model", model);
		return "helpEdit";
	}
	@RequestMapping(value = "/admin-detail-help",method = RequestMethod.GET)
	public String detailHelp(HttpServletRequest request,@RequestParam(value = "id") Long id) {
		HelpModel model=helpService.findOneById(id);
		request.setAttribute("model", model);
		return "helpDetail";
	}
}
