package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.NewDTO;
import com.laptrinhjavaweb.entity.NewEntity;

@Component
public class NewConverter {

	public NewEntity toEntity(NewDTO newDTO) {
		
		NewEntity  newEntity = new NewEntity();
		newEntity.setTitle(newDTO.getTitle());
		newEntity.setThumbnail(newDTO.getThumbnail());
		newEntity.setShortDescription(newDTO.getShortDescription());
		newEntity.setContent(newDTO.getContent());
		
		return newEntity;
	}
	
	public NewDTO toNewDTO(NewEntity newEntity) {
		
		NewDTO newDTO = new NewDTO();
		
		if(newEntity.getId()!= null) {
			newDTO.setId(newEntity.getId());
		}
		newDTO.setTitle(newEntity.getTitle());
		newDTO.setThumbnail(newEntity.getThumbnail());
		newDTO.setShortDescription(newEntity.getShortDescription());
		newDTO.setContent(newEntity.getContent());
		newDTO.setCreatedBy(newEntity.getCreatedBy());
		newDTO.setModifiedBy(newEntity.getModifiedBy());
		newDTO.setCreatedDate(newEntity.getCreatedDate());
		newDTO.setModifiedDate(newEntity.getModifiedDate());
		return newDTO;
		
	}
	
	public NewEntity toEntity(NewDTO newDTO, NewEntity oldNewEntity) {

		oldNewEntity.setTitle(newDTO.getTitle());
		oldNewEntity.setThumbnail(newDTO.getThumbnail());
		oldNewEntity.setShortDescription(newDTO.getShortDescription());
		oldNewEntity.setContent(newDTO.getContent());
		
		return oldNewEntity;
	}
}
