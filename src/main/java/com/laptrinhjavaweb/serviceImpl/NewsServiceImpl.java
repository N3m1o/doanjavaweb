package com.laptrinhjavaweb.serviceImpl;

import java.util.List;

import org.hibernate.engine.transaction.jta.platform.internal.SapNetWeaverJtaPlatform;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.repository.NewsRepository;
import com.laptrinhjavaweb.service.NewsService;

@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsRepository newsRepository;

	public List<NewsEntity> findAll() {
		try {
			return newsRepository.findAllBy();
		} catch (Exception e) {
			return null;
		}
	}

	public List<NewsEntity> findLast() {
		try {
			return newsRepository.findLastNews();
		} catch (Exception e) {
			return null;
		}
	}

	public List<NewsEntity> findById(Integer categoryId) {
		try {
			return newsRepository.findByCateID(categoryId);
		} catch (Exception e) {
			return null;
		}
	}

	public NewsEntity findByIdNews(Integer newsId) {
		try {
			return newsRepository.findOneByIdNews(newsId);
		} catch (Exception e) {
			return null;
		}
	}

	public List<NewsEntity> search(String titleNews) {
		try {
			return newsRepository.findByLikeTitle(titleNews);
		} catch (Exception e) {
			return null;
		}
	}

	public void save(NewsEntity newsEntity) {
		newsRepository.save(newsEntity);
	}

	public void delete(NewsEntity newsEntity) {
		newsRepository.delete(newsEntity);
	}

	public NewsEntity editNews(int newsId, NewsEntity newsEntity) {
		NewsEntity update = newsRepository.findOneByIdNews(newsId);
		update.setTitle(newsEntity.getTitle());
		update.setDisplay_img(newsEntity.getDisplay_img());
		update.setShortDescription(newsEntity.getShortDescription());
		update.setContent(newsEntity.getContent());
		update.setCateId(newsEntity.getCateId());
		return newsRepository.save(update);
	}

	@Override
	public List<NewsEntity> findNewsByUserId(int userId) {
		// TODO Auto-generated method stub
		try {
			return newsRepository.findNewsByUserId(userId);
		} catch (Exception e) {
			return null;
		}
	}
}
