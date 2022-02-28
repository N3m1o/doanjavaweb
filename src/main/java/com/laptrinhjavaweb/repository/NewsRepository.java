package com.laptrinhjavaweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.laptrinhjavaweb.entity.NewsEntity;

public interface NewsRepository extends JpaRepository<NewsEntity, Integer>{
	@Query(value = "select * from news", nativeQuery = true)
	List<NewsEntity> findAllBy();
	
	@Query(value = "select top 6 * from news order by news_id desc", nativeQuery = true)
	List<NewsEntity> findLastNews();
	
	@Query(value = "select * from news n where n.cate_id = ?1", nativeQuery = true)
	List<NewsEntity> findByCateID(Integer cateId);
	
	@Query(value = "select top 1 * from news n where n.cate_id = ?1 order by news_id desc", nativeQuery = true)
	List<NewsEntity> findNewsForLeft(Integer cateId);
	
	@Query(value = "select top 4 * from news n where n.cate_id = ?1", nativeQuery = true)
	List<NewsEntity> findNewsForRight(Integer cateId);
	
	@Query(value = "select * from news n where n.news_id = ?1", nativeQuery = true)
	NewsEntity findOneByIdNews(Integer newsId);
	
	@Query(value = "select * from news n where n.title like %?1%", nativeQuery = true)
	List<NewsEntity> findByLikeTitle(String titleNews);
	
	@Query(value = "select * from news n where n.user_id =?1 order by date_submitted desc, news_id desc", nativeQuery = true)
	List<NewsEntity> findNewsByUserId(int userId);
	
	@Query(value = "SELECT TOP 6 * FROM news n ORDER BY NEWID()", nativeQuery = true)
	List<NewsEntity> findNewsRandom();
	
	@Query(value = "SELECT TOP 3 * FROM news n WHERE n.cate_id = ?1 ORDER BY NEWID()", nativeQuery = true)
	List<NewsEntity> relatestPost(Integer cateId);
	
}
