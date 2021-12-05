package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.laptrinhjavaweb.entity.CateEntity;
import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.service.CategoryService;
import com.laptrinhjavaweb.service.NewsService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
/*
	@RequestMapping("/edit/{newsId}")
	public String findAll(Model model){
		newsService.findByIdNews(newsId);
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		model.addAttribute("cateList", cateEntitiesList);
		return "edit";
	}*/
	
}
