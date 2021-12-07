package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.CateEntity;

public interface CategoryRepository extends JpaRepository<CateEntity, Integer>{
	@Query(value = "select * from category", nativeQuery = true)
	List<CateEntity> findAllBy();
	
	@Query(value = "SELECT DISTINCT * FROM category JOIN news ON news.cate_id = category.cate_id WHERE news.news_id = ?1", nativeQuery = true)
	CateEntity findCateName(int newsId);
}
