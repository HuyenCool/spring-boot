package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.NewEntity;

public interface CategorytyRepository extends JpaRepository<CategoryEntity, Long> {

	CategoryEntity findOneByCode(String code);
	
}
