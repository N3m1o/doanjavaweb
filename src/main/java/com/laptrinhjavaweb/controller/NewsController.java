package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.service.NewsService;

@RestController
@RequestMapping("/api/news")
public class NewsController {
	@Autowired 
	private NewsService newsService;
	
	// lay ra tat ca bai viet
	@GetMapping("find-all")
	public List<NewsEntity> findAll(Model model) {
		List<NewsEntity> newsList = newsService.findAll();
		
		model.addAttribute("newsList", newsList);		
		return newsList;
	}
	
	// lay ra 3 bai viet moi nhat
	@GetMapping("find-last-news")
	public List<NewsEntity> findLast(Model model) {
		List<NewsEntity> lastList = newsService.findLast();
		
		model.addAttribute("lastList", lastList);
		return lastList;
	}
	
	// lay ra bai viet theo category id
	@GetMapping("find-by-cate-id/{cid}")
	public List<NewsEntity> findNewsByCateId(@PathVariable("cid") Integer cid, Model model){
		List<NewsEntity> newsList = newsService.findById(cid);

		model.addAttribute("newsByIdList", newsList);	
		return newsList;
	} 
	
	// hien thi chi tiet bai viet
	@GetMapping("find-by-news-id/{newsId}")
	public NewsEntity findNewsByNewsId(@PathVariable("newsId") Integer newsId, Model model) {
		NewsEntity newsDetails = newsService.findByIdNews(newsId);
		
		model.addAttribute("newsDetails", newsDetails);
		return newsDetails;
	}
	
	// tim kiem bai viet theo tu khoa co trong title
	@GetMapping("find-by-like-title/{title}")
	public List<NewsEntity> findNewsByName(@PathVariable("title") String title, Model model){
		List<NewsEntity> list = newsService.findByTitle(title);
		
		model.addAttribute("newsTitle", list);
		return list;
	}
}
