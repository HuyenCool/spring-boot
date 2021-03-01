package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.NewConverter;
import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.repository.CategorytyRepository;
import com.laptrinhjavaweb.repository.NewRepository;
import com.laptrinhjavaweb.service.INewService;

@Service
public class NewService implements INewService {

	@Autowired
	private NewRepository newRepository;
	
	@Autowired
	private NewConverter newConverter;
	
	@Autowired
	private CategorytyRepository categorytyRepository;
	
	@Override
	public NewDTO save_update(NewDTO newDTO) {
		NewEntity newEntity = new NewEntity();
		if(newDTO.getId()!= null) {
			NewEntity oldNewEntity = newRepository.findOne(newDTO.getId());
			newEntity = newConverter.toEntity(newDTO, oldNewEntity);
			newEntity.setCreatedBy(oldNewEntity.getCreatedBy());
			newEntity.setCreatedDate(oldNewEntity.getCreatedDate());
		}else {
			newEntity = newConverter.toEntity(newDTO);
		}

		CategoryEntity categoryEntity = categorytyRepository.findOneByCode(newDTO.getCategoryCode());
		newEntity.setCategoryEntity(categoryEntity);
		newEntity = newRepository.save(newEntity);
		return newConverter.toNewDTO(newEntity);
	}

	@Override
	public void delete(long[] ids) {
		
		for (long id: ids) {
			//1.delete comment (khoa ngoai new_id)
			//2.delete news
			newRepository.delete(id);
		}
		
	}

	@Override
	public List<NewDTO> findAll(Pageable pageable) {
		List<NewDTO> newDTOs = new ArrayList<>();
		List<NewEntity> newEntitys  = newRepository.findAll(pageable).getContent();
		for(NewEntity item : newEntitys) {
			newDTOs.add(newConverter.toNewDTO(item));
		}
		return newDTOs;
	}

	@Override
	public int getTotalItem() {
		
		return (int) newRepository.count();
	}

	@Override
	public List<NewDTO> findAll() {
		List<NewDTO> newDTOs = new ArrayList<>();
		List<NewEntity> newEntitys  = newRepository.findAll();
		for(NewEntity item : newEntitys) {
			newDTOs.add(newConverter.toNewDTO(item));
		}
		return newDTOs;
		
	}

}
