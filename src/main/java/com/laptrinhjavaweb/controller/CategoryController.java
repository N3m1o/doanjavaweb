package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.entity.CateEntity;
import com.laptrinhjavaweb.service.CategoryService;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("find-all")
	public List<CateEntity> findAll(Model model){
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		
		model.addAttribute("cateList", cateEntitiesList);
		return cateEntitiesList;
	}
}
