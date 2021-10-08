package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.CateEntity;

public interface CategoryRepository extends JpaRepository<CateEntity, Integer>{
	CateEntity findOneByCid(CateEntity cateEntity);
}
