package com.javaweb.springmvc.Service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javaweb.springmvc.DAO.ICommentDAO;
import com.javaweb.springmvc.DTO.CommentModel;
import com.javaweb.springmvc.Entity.CommentEntity;
import com.javaweb.springmvc.Entity.UserEntity;
import com.javaweb.springmvc.Repository.ICommentRepository;
import com.javaweb.springmvc.Repository.INewRepository;
import com.javaweb.springmvc.Repository.IUserRepository;
import com.javaweb.springmvc.Service.ICommentService;
import com.javaweb.springmvc.convert.CommentConvert;
@Service
public class CommentService implements ICommentService{

	@Autowired
	IUserRepository userRepository;
	@Autowired
	INewRepository newRepository;
	@Autowired
	ICommentDAO commentDAO;
	@Autowired
	ICommentRepository commentRepository;
	@Autowired
	CommentConvert commentConvert;
	@Override
	public void addComment(CommentModel model) {
		UserEntity userEntity= userRepository.findByUserName(model.getUserName()) ;
	//	NewEntity newEntity= newRepository.findOneById(model.getNews());
		CommentEntity entity=new CommentEntity();
		entity=commentConvert.dtoToEntity(model);
		//entity.setComments(model.getComments());
		//entity.setUserid(userEntity.getId());
		//entity.setNewid(newEntity.getId());
		entity.setUserid(userEntity.getId());
		commentDAO.addComment(entity);
	}
	@Override
	public List<CommentModel> findAllNewComment(Long id) {
		List<CommentEntity> entities=commentRepository.findAllByNewid(id);
		List<CommentModel> models=new ArrayList<CommentModel>();
		for(CommentEntity entity:entities) {
			CommentModel model=new CommentModel();
			if(entity.getUseridcomment()==null) {
				model=commentConvert.entityToDto(entity);
				UserEntity entity2=userRepository.findOneById(entity.getUserid());
				model.setUserName(entity2.getUserName());
				models.add(model);
			}
		}
		return models;
	}
	@Override
	public List<CommentModel> findAllNewCommentUser(Long id) {
		List<CommentEntity> entities=commentRepository.findAllByNewid(id);
		List<CommentModel> models=new ArrayList<CommentModel>();
		for(CommentEntity entity:entities) {
			CommentModel model=new CommentModel();
			if(entity.getUseridcomment()!=null) {
				model=commentConvert.entityToDto(entity);
				UserEntity entity2=userRepository.findOneById(entity.getUserid());
				model.setUserName(entity2.getUserName());
				model.setUseridcomment(entity.getUseridcomment());
				models.add(model);
			}
		}
		return models;
	}
	@Override
	public List<CommentModel> findAll(Pageable pageable) {
		List<CommentEntity> entities=commentRepository.findAllByOrderByIdDesc(pageable);
		List<CommentModel> models=new ArrayList<CommentModel>();
		for(CommentEntity entity:entities) {
			CommentModel model=new CommentModel();
			model=commentConvert.entityToDto(entity);
			model.setUserName(userRepository.findOneById(entity.getUserid()).getUserName());
			if(model.getUseridcomment()!=null) {
				model.setRepComments(commentRepository.findOneById(model.getUseridcomment()).getComments());
			}
			models.add(model);
		}
		return models;
	}
	@Override
	public int countComment() {
		return (int) commentRepository.count();
	
	}
	@Override
	public void deleteComment(Long id) {
		List<CommentEntity> list=commentRepository.findAllByUseridcomment(id);
		for(CommentEntity entity:list) {
			commentDAO.deleteComment(entity.getId());
		}
		//commentRepository.deleteByUseridcomment(id);
		commentDAO.deleteComment(id);
		
	}
	@Override
	public CommentModel findById(Long id) {
		CommentEntity entity=commentRepository.findOneById(id);
		CommentModel model=new CommentModel();
		model=commentConvert.entityToDto(entity);
		model.setUserName(userRepository.findOneById(model.getUserid()).getUserName());
		return model;
	}
	@Override
	public List<CommentModel> findAllUserCommentUser(Long id) {
		List<CommentEntity> entities=commentRepository.findAllByUseridcomment(id);
		List<CommentModel> models=new ArrayList<CommentModel>();
		for(CommentEntity entity: entities) {
			CommentModel model=new CommentModel();
			model=commentConvert.entityToDto(entity);
			model.setUserName(userRepository.findOneById(model.getUserid()).getUserName());
			models.add(model);
		}
		return models;
	}

	
}
