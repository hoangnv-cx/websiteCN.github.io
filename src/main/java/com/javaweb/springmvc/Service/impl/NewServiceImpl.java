package com.javaweb.springmvc.Service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.javaweb.springmvc.DAO.ICategoryDAO;
import com.javaweb.springmvc.DAO.ICommentDAO;
import com.javaweb.springmvc.DAO.INewDAO;
import com.javaweb.springmvc.DTO.NewModel;
import com.javaweb.springmvc.Entity.CategoryEntity;
import com.javaweb.springmvc.Entity.CommentEntity;
import com.javaweb.springmvc.Entity.NewEntity;
import com.javaweb.springmvc.Repository.ICategoryRepository;
import com.javaweb.springmvc.Repository.ICommentRepository;
import com.javaweb.springmvc.Repository.INewRepository;
import com.javaweb.springmvc.Service.INewService;
import com.javaweb.springmvc.Util.SecurityUtils;
import com.javaweb.springmvc.convert.NewConvert;

@Service
public class NewServiceImpl implements INewService {
	@Autowired
	INewRepository newRepository;
	@Autowired
	ICategoryRepository catRepository;
	@Autowired
	ICategoryDAO catDAO;
	@Autowired
	INewDAO newDAO;
	@Autowired
	NewConvert newConvert;
	@Autowired
	ICommentRepository commentRepository;
	@Autowired
	ICommentDAO commentDAO;

	public void addNew(NewModel model) {
		NewEntity entity = new NewEntity();
		CategoryEntity catEntity = catRepository.findOneByCode(model.getCategoryCode());
		entity = newConvert.dtoToEntity(model);
		entity.setCategoryid(catEntity.getId());
		newDAO.addNew(entity);
	}

	public void updateNew(NewModel model) {
		NewEntity entity = new NewEntity();
		CategoryEntity catEntity = catRepository.findOneByCode(model.getCategoryCode());
		NewEntity entity2 = newDAO.findOneNewById(model.getId());
		if (entity2 != null) {
			entity = newConvert.dtoToEntity(model);
			entity.setCategoryid(catEntity.getId());
			entity.setCreateDate(entity2.getCreateDate());
			entity.setCreatedBy(entity2.getCreatedBy());
			entity.setModifiedBy(SecurityUtils.getName());
			entity.setModifiedDate(new Timestamp(System.currentTimeMillis()));
			newDAO.updateNew(entity);
		}
	}

	public void deleteNew(Long id) {
		NewEntity entity = newDAO.findOneNewById(id);

		if (entity != null) {
			List<CommentEntity> entities = commentRepository.findAllByNewid(id);
			if (entities != null) {
				for (CommentEntity entity2 : entities) {
					commentDAO.deleteComment(entity2.getId());
				}
			}
			// commentRepository.deleteByNewid(id);
			newDAO.deleteNew(id);
		}
	}

	public NewModel findOneNewById(Long id) {
		NewEntity entity = newDAO.findOneNewById(id);
		NewModel model = new NewModel();

		model = newConvert.entityToDto(entity);

//		List<CommentModel> models=new ArrayList<CommentModel>();
//		List<CommentEntity> entities=entity.getComments();
//		for(CommentEntity comEntity:entities ) {
//			CommentModel commentModel=new CommentModel();
//			commentModel.setComments(comEntity.getComments());
//			commentModel.setUser(comEntity.getUserComment().getUserName());
//			models.add(commentModel);
//		}
//		
//	
//		model.setCommentModels(models);
		return model;
	}

	public int count() {

		return (int) newRepository.count();
	}

	public void deleteList(long[] ids) {

	}

	@Override
	public NewModel findByCategoryid(Long categoryId) {

		return null;
	}

	@Override
	public List<NewModel> findAllByCategoryid(Long categoryId) {
		List<NewEntity> listEntity = newRepository.findAllByCategoryid(categoryId);
		List<NewModel> listModel = new ArrayList<NewModel>();

		for (NewEntity entity : listEntity) {

			if (entity != null) {
				NewModel model = new NewModel();
				model = newConvert.entityToDto(entity);
				listModel.add(model);
			}
		}

		return listModel;
	}

	@Override
	public List<NewModel> find(Pageable pageable) {
		List<NewEntity> entitys = newRepository.findAllByOrderByIdDesc(pageable);
		List<NewModel> models = new ArrayList<NewModel>();
		for (NewEntity entity : entitys) {
			NewModel model = new NewModel();
			model = newConvert.entityToDto(entity);
			model.setCategoryName(catRepository.findOneById(entity.getCategoryid()).getName());
			
			models.add(model);
		}
		return models;
	}

	@Override
	public List<NewModel> findAllBycategoryidOrderByIdDesc(Pageable pageable, Long CategoryId) {

		List<NewEntity> listEntity = newRepository.findAllBycategoryidOrderByIdDesc(pageable, CategoryId);

		List<NewModel> listModel = new ArrayList<NewModel>();
		for (NewEntity entity : listEntity) {

			if (entity != null) {
				NewModel model = new NewModel();
				model = newConvert.entityToDto(entity);
				model.setCategoryName(catRepository.findOneById(entity.getCategoryid()).getName());
				listModel.add(model);
			}
		}

		return listModel;
	}

	@Override
	public int countByCategory(Long CategoryId) {
		List<NewEntity> entities = newRepository.findAllByCategoryid(CategoryId);
		int count = entities.size() + 1;
		return count;
	}

	@Override
	public List<NewModel> findByTitleContaining(Pageable pageable, String title) {
		List<NewEntity> entities = newRepository.findByTitleContainingOrderByIdDesc(pageable, title);

		List<NewModel> models = new ArrayList<NewModel>();
		for (NewEntity entity : entities) {
			NewModel model = new NewModel();
			model = newConvert.entityToDto(entity);
			models.add(model);
		}
		return models;
	}

	@Override
	public int countBySearch(String title) {
		List<NewEntity> entities2 = newRepository.findByTitleContaining(title);
		int count = entities2.size() + 1;
		return count;
	}

}
