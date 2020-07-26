package com.javaweb.springmvc.admin.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.javaweb.springmvc.DAO.ICategoryDAO;
import com.javaweb.springmvc.DTO.NewModel;
import com.javaweb.springmvc.Service.INewService;

@RestController
public class NewControllerAPI {
	@Autowired
	INewService newService;
	@Autowired
	ICategoryDAO dao;
	

	
	//api thêm bài viết ở trang admin
	@RequestMapping(value = "/post-new",method = RequestMethod.POST)
	public NewModel postNew(@RequestBody NewModel model) {

		newService.addNew(model);
		return model;
	}
	@RequestMapping(value = "/api-file-upload",method = RequestMethod.POST)
	public MultipartFile postFile(@RequestParam(value = "uploadingFiles")MultipartFile file) {
		
		try {
			File newFile =new File("D:/images/"+file.getOriginalFilename());
			FileOutputStream fileOutputStream=new FileOutputStream(newFile);
			fileOutputStream.write(file.getBytes());
			fileOutputStream.close();
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {
			
		}
		return file;
	}
	
	//sửa bài viết ở trang admin
	@RequestMapping(value = "/post-new",method = RequestMethod.PUT)
	public NewModel putNew(@RequestBody NewModel model) {
		
		newService.updateNew(model);
		return model;
	}
	//xóa bài viết theo mảng ở trang admin
	//@RequestMapping(value = "/post-new",method = RequestMethod.DELETE)
	@DeleteMapping(value = "/post-new")
	public void deleteNew(@RequestBody long[] ids) {
		
		newService.deleteList(ids);
	}
	

}
