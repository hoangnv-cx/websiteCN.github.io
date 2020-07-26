package com.javaweb.springmvc.Service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.javaweb.springmvc.DTO.HelpModel;

public interface IHelpService {

	void addHelp(HelpModel model);
	void updateHelp(HelpModel model);
	List<HelpModel> findAll(Pageable pageable);
	int countHelp();
	HelpModel findOneById(Long id);
}
