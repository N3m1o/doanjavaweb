package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.NewsEntity;

public interface NewsService {
	List<NewsEntity> findAll();
	
	List<NewsEntity> findLast();
	
	List<NewsEntity> findById(Integer cateId);
	
	List<NewsEntity> findNewsForRight(Integer cateId);
	
	List<NewsEntity> findNewsForLeft(Integer cateId);
	
	NewsEntity findByIdNews(Integer newsId);
	
	List<NewsEntity> search(String titleNews);
	
	void save(NewsEntity newsEntity);
	
	void delete(NewsEntity newsEntity);
	
	NewsEntity editNews(int newsId, NewsEntity newsEntity);
	
	List<NewsEntity> findNewsByUserId(int userId);
	
	List<NewsEntity> findNewsRandom();
	
	List<NewsEntity> relatestPost(int cateId);
}
