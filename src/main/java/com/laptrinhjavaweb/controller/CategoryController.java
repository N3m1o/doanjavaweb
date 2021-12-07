package com.laptrinhjavaweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.laptrinhjavaweb.entity.CateEntity;
import com.laptrinhjavaweb.service.CategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
/*	
	@RequestMapping(value = "/details/{newsId}")
	public String findAllCate(Model model) {
		model.addAttribute("cateList", categoryService.findAll());
		return "single_page";
	}
*/	
}
