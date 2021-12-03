package com.laptrinhjavaweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.service.NewsService;


@Controller
public class NewsController {

	@Autowired 
	private NewsService newsService;
	
	// lay ra tat ca bai viet
	@GetMapping(value = {"/", "/home"})
	public String findAll(Model model) {
		List<NewsEntity> newsList = newsService.findAll();
		
		model.addAttribute("newsList", newsList);		
		return "list";
	}
	
	@GetMapping("/news/create")
	public String create(Model model) {
		model.addAttribute("news", new NewsEntity());
		return "form";
	}
	
	@GetMapping("/news/{id}/edit")
	public String edit(@PathVariable int id, Model model) {
		model.addAttribute("news", newsService.findByIdNews(id));
		return "form";
	}
	
	@PostMapping("/news/save")
	public String save(@Valid NewsEntity newsEntity, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		newsService.save(newsEntity);
		redirect.addFlashAttribute("success", "Luu bai thanh cong");
		return "redirect:/news";
	}
	
	@GetMapping("/news/{id}/delete")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		NewsEntity newsEntity = newsService.findByIdNews(id);
				newsService.delete(newsEntity);
		redirect.addFlashAttribute("success", "Xoa bai thanh cong");
		return "redirect:/news";
	}
	
	@GetMapping("/news/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/news";
		}
		model.addAttribute("news",newsService.search(s));
		return "list";
	}
}
