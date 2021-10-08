package com.laptrinhjavaweb.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.entity.NewEntity;
import com.laptrinhjavaweb.service.NewService;

@Controller
public class NewsController {
	@Autowired
	private NewService newService;
	
	@RequestMapping("/")
	public String getNewToScreen(Model model) {
		List<NewEntity> newEntities = newService.getAllNew();
		
		model.addAttribute("news", newEntities);
		
		return "home";
	}
	
	@RequestMapping(value = "add")
	public String addNews(Model model) {
		model.addAttribute("news", new NewEntity());
		
		return "addNews";
	}
	
	
	@RequestMapping(value = "edit", method = RequestMethod.GET)
	public String editNews(@RequestParam("id") Integer id,Model model) {
		Optional<NewEntity> newEdit = newService.findNewById(id);
		model.addAttribute("news", newEdit);
		
		return "editNews";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveNews(NewEntity newEntity) {
		newService.saveNew(newEntity);
		
		return "";
	}
	
	
	@RequestMapping(value = "delete", method = RequestMethod.DELETE)
	public String deleteNews(@RequestParam("id") Integer id, Model model) {
		newService.deleteNew(id);
		
		return "";
	}
	
}
