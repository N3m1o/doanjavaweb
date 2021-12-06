package com.laptrinhjavaweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptrinhjavaweb.entity.CateEntity;
import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.service.CategoryService;
import com.laptrinhjavaweb.service.NewsService;


@Controller
public class NewsController {

	@Autowired 
	private NewsService newsService;
	
	@Autowired
	private CategoryService categoryService;
	
	// lay ra tat ca bai viet
	@RequestMapping(value = "/create")
	public String findAll(Model model) {
		model.addAttribute("news", newsService.findAll());
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		model.addAttribute("cateList", cateEntitiesList);
		return "PostManager";
	}
	
	// lay ra bai viet moi nhat
	@RequestMapping(value = "/home")
	public String findLastestNews(Model model) {
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		model.addAttribute("cateList", cateEntitiesList);
		model.addAttribute("lastestNews", newsService.findLast());
		return "home";
	}
	
	/**
	@RequestMapping("")
	public String showCreateNewsPage(Model model) {
		model.addAttribute("news", new NewsEntity());
		return "PostManager";
	}**/
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createNews(@ModelAttribute("news") NewsEntity newsEntity) {
		newsService.save(newsEntity);
		return "redirect:/PostManager";
	}
	
	@RequestMapping("/edit/{newsId}")
	public String showEditNewsPage(@PathVariable int newsId, Model model) {
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		model.addAttribute("cateList", cateEntitiesList);
		model.addAttribute("news", newsService.findByIdNews(newsId));
		return "edit";
	}
	
	@RequestMapping(value = "/edit/{newsId}", method = RequestMethod.POST)
	public String editNews(@PathVariable int newsId, @ModelAttribute("news") NewsEntity newsEntity) {
		newsService.editNews(newsId, newsEntity);
		return "redirect:/PostManager";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Valid NewsEntity newsEntity, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		newsService.save(newsEntity);
		redirect.addFlashAttribute("success", "Luu bai thanh cong");
		return "redirect:/PostManager";
	}
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		NewsEntity newsEntity = newsService.findByIdNews(id);
				newsService.delete(newsEntity);
		redirect.addFlashAttribute("success", "Xoa bai thanh cong");
		return "redirect:/PostManager";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("s") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/news";
		}
		model.addAttribute("news",newsService.search(s));
		return "list";
	}
}
