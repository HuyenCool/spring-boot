package com.laptrinhjavaweb.service;



import java.util.List;

import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.NewDTO;



public interface INewService {
	NewDTO save_update(NewDTO newDTO);
	void delete(long[] ids);
	List<NewDTO> findAll(Pageable pageable);
	List<NewDTO> findAll();
	int getTotalItem();
}
