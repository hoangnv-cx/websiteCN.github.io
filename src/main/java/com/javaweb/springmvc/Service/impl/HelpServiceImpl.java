package com.javaweb.springmvc.Service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javaweb.springmvc.DAO.IHelpDAO;
import com.javaweb.springmvc.DTO.HelpModel;
import com.javaweb.springmvc.Entity.HelpEntity;
import com.javaweb.springmvc.Entity.UserEntity;
import com.javaweb.springmvc.Repository.IHelpRepository;
import com.javaweb.springmvc.Repository.IUserRepository;
import com.javaweb.springmvc.Service.IHelpService;
import com.javaweb.springmvc.Util.SecurityUtils;
import com.javaweb.springmvc.Util.SendEmail;
import com.javaweb.springmvc.convert.HelpConvert;
@Service
public class HelpServiceImpl implements IHelpService{

	@Autowired
	IHelpRepository helpRepository;
	@Autowired
	IHelpDAO helpDAO;
	@Autowired
	SendEmail sendMail;
	@Autowired
	IUserRepository userRepository;
	@Autowired
	HelpConvert helpConvert;
	@Override
	public void addHelp(HelpModel model) {
		HelpEntity entity=new HelpEntity();
		entity=helpConvert.dtoToEntity(model);
	//	UserEntity userEntity=userRepository.findOneById(model.getUserid());
	//	model.setAdmin(userEntity.getUserName());
		//0->chua xu li
		entity.setStatus("0");
		//helpRepository.save(entity);
		helpDAO.addHelp(entity);
	}
	@Override
	public List<HelpModel> findAll(Pageable pageable) {
		List<HelpEntity> entities=helpRepository.findAllByOrderByIdDesc(pageable);
		List<HelpModel> models=new ArrayList<HelpModel>();
		
		for(HelpEntity entity:entities) {
			HelpModel model=new HelpModel();

			model=helpConvert.entityToDto(entity);
			if(model.getUserid()!=null) {
				UserEntity userEntity=userRepository.findOneById(model.getUserid());
			
				model.setAdmin(userEntity.getUserName());
			}
			
			models.add(model);
		}
		return models;
	}
	@Override
	public int countHelp() {
		
		return (int) helpRepository.count();
	}
	@Override
	public HelpModel findOneById(Long id) {
		HelpEntity entity=helpRepository.findOneById(id);
		HelpModel model=new HelpModel();
//		model.setId(entity.getId());
//		model.setUser(entity.getUser());
//		model.setFirstName(entity.getFirstName());
//		model.setMessage(entity.getMessage());
//		
//		  if(entity.getUsers()!=null) {
//			  model.setAdmina(entity.getUsers().getUserName()); 
//		  }
//		 
//		model.setSubject(entity.getSubject());
//		model.setEmail(entity.getEmail());
//		if(entity.getStatus().equals("0")) {
//			model.setStatus("Chưa xử lý");
//		}else {
//			model.setStatus("Đã xử lý");
//		}
//
//		model.setTitle(entity.getTitle());
//		model.setReply(entity.getReply());
//		model.setAdmin(entity.getAdmin());
		model=helpConvert.entityToDto(entity);
		if(model.getUserid()!=null) {
			UserEntity userEntity=userRepository.findOneById(model.getUserid());
		
			model.setAdmin(userEntity.getUserName());
		}
		return model;
	}
	@Override
	public void updateHelp(HelpModel model) {
		UserEntity user=userRepository.findByUserName(SecurityUtils.getName());
		HelpEntity entity=new HelpEntity();
		HelpEntity entity2=helpRepository.findOneById(model.getId());
		entity=helpConvert.dtoToEntity(model);
		if (entity2 != null) {
			
			entity.setCreateDate(entity2.getCreateDate());
			entity.setCreatedBy(entity2.getCreatedBy());
			entity.setModifiedBy(SecurityUtils.getName());
			entity.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			entity.setStatus("1");
			

			
			entity.setUsers(user);
			
			helpDAO.updateHelp(entity);
			//helpRepository.save(entity);
			sendMail.sendEmailTest(model.getEmail() ,model.getTitle(),model.getReply());
		}
		
		//sendMail.sendEmail(model.getEmail() ,model.getTitle(),model.getReply());
		
	}
	
	
}