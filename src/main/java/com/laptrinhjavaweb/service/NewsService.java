package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.NewsEntity;

public interface NewsService {
	List<NewsEntity> findAll();
	
	List<NewsEntity> findLast();
	
	List<NewsEntity> findById(Integer cateId);
	
	NewsEntity findByIdNews(Integer newsId);
	
	List<NewsEntity> findByTitle(String titleNews);
}
