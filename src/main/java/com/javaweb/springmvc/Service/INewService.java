package com.javaweb.springmvc.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.javaweb.springmvc.DTO.NewModel;

public interface INewService {
	void addNew(NewModel model);
	void updateNew(NewModel model);
	void deleteNew(Long id);
	NewModel findOneNewById(Long id);
	//List<NewModel> findAllNew();
	void deleteList(long [] ids);
	int count();
	//List<NewModel> find(int offset,int limit);
	public NewModel findByCategoryid(Long categoryId);
	List<NewModel> findAllByCategoryid(Long categoryId);
	List<NewModel> find(Pageable pageable);
	List<NewModel> findAllBycategoryidOrderByIdDesc(Pageable pageable,Long CategoryId);
	int countByCategory(Long CategoryId);
	List<NewModel> findByTitleContaining(Pageable pageable,String title);
	int countBySearch(String title);
	
}
