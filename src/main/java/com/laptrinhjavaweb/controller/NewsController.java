package com.laptrinhjavaweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptrinhjavaweb.entity.CateEntity;
import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.CategoryService;
import com.laptrinhjavaweb.service.NewsService;
import com.laptrinhjavaweb.service.UserService;


@Controller
public class NewsController {

	@Autowired 
	private NewsService newsService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserService userService;
	
	// lay ra tat ca bai viet
	@RequestMapping(value = "/author")
	public String findAll(Model model, HttpSession httpSession) {
		Object obj = httpSession.getAttribute("userEntity");
		UserEntity userEntity = (UserEntity)obj;
		int userId = userEntity.getUserID();
		model.addAttribute("news", newsService.findNewsByUserId(userId));
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
	
	//chi tiet bai viet
	@RequestMapping("/details/{newsId}")
	public String showDetailsPage(Model model, @PathVariable int newsId) {
		//model.addAttribute("cate", categoryService.findCateName(newsId));
		//model.addAttribute("author", userService.nameAuthorByNewsId(newsId));
		
		model.addAttribute("lastestNews", newsService.findLast());
		model.addAttribute("cateList", categoryService.findAll());
		model.addAttribute("details", newsService.findByIdNews(newsId));
		return "single_page";
	}
	
	@RequestMapping(value = "/author", params = {"title","display_image","content","short_description","category"}, method = RequestMethod.POST)
	public String createNews(@RequestParam("title")String title,@RequestParam("display_image")String display_image,
			@RequestParam("content")String content,@RequestParam("short_description")String short_description, @RequestParam("category")int category
			,HttpSession httpSession) {
		CateEntity cateEntity = categoryService.findCateById(category);
		Object obj = httpSession.getAttribute("userEntity");
		UserEntity userEntity = (UserEntity)obj;
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setContent(content);
		newsEntity.setDisplay_img(display_image);
		newsEntity.setShortDescription(short_description);
		newsEntity.setStatus(true);
		newsEntity.setTitle(title);
		newsEntity.setUserId(userEntity);
		newsEntity.setCateId(cateEntity);
		newsService.save(newsEntity);
		return "redirect:/author";
	}
	
	@RequestMapping("/edit/{newsId}")
	public String showEditNewsPage(@PathVariable int newsId, Model model) {
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		model.addAttribute("cateList", cateEntitiesList);
		model.addAttribute("news", newsService.findByIdNews(newsId));
		return "edit";
	}
	
	@RequestMapping(value = "/edit/{newsId}", params = {"id","title","display_image","content","short_description","category"}, method = RequestMethod.POST)
	public String editNews(@RequestParam("id")int newsId,@RequestParam("title")String title,@RequestParam("display_image")String display_image,
			@RequestParam("content")String content,@RequestParam("short_description")String short_description, @RequestParam("category")int category
			,HttpSession httpSession) {
		
		CateEntity cateEntity = categoryService.findCateById(category);
		Object obj = httpSession.getAttribute("userEntity");
		UserEntity userEntity = (UserEntity)obj;
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setContent(content);
		newsEntity.setDisplay_img(display_image);
		newsEntity.setShortDescription(short_description);
		newsEntity.setStatus(true);
		newsEntity.setTitle(title);
		newsEntity.setUserId(userEntity);
		newsEntity.setCateId(cateEntity);
		newsEntity.setNewsId(newsId);
		newsService.save(newsEntity);
		return "redirect:/author";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@Validated NewsEntity newsEntity, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return "form";
		}
		newsService.save(newsEntity);
		redirect.addFlashAttribute("success", "Luu bai thanh cong");
		return "redirect:/PostManager";
	}
	
	// đã hoạt động
	@RequestMapping("/delete/{id}" )
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		NewsEntity newsEntity = newsService.findByIdNews(id);
				newsService.delete(newsEntity);

		return "redirect:/author";
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
