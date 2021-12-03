package com.laptrinhjavaweb.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.service.NewsService;


@Controller
public class HomeControl {

	@Autowired 
	private NewsService newsService;
	
	// lay ra tat ca bai viet
	@GetMapping(value = {"/", "/home"})
	public String findAll(Model model) {
		List<NewsEntity> newsList = newsService.findAll();
		
		model.addAttribute("newsList", newsList);		
		return "home";
	}
}
