package com.laptrinhjavaweb.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.laptrinhjavaweb.entity.CateEntity;
import com.laptrinhjavaweb.entity.CommentEntity;
import com.laptrinhjavaweb.entity.NewsEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.CategoryService;
import com.laptrinhjavaweb.service.CommentService;
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
	
	@Autowired
	private CommentService commentService;
	
	// hiển thị bài viết của nhà báo
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
	
	// lấy ra bài viết hiển thị trên trang chủ
	@RequestMapping(value = "/home")
	public String findLastestNews(Model model) {
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		model.addAttribute("cateList", cateEntitiesList);
		model.addAttribute("random", newsService.findNewsRandom());
		model.addAttribute("lastestNews", newsService.findLast());
		model.addAttribute("news", newsService.findAll());
		//Đổ dữ liệu vào các field trên HOME
		//dữ liệu của thể thao
		model.addAttribute("sportLeft", newsService.findNewsForLeft(1));
		model.addAttribute("sportRight", newsService.findNewsForRight(1));
		//dữ liệu của văn hóa
		model.addAttribute("cultural", newsService.findNewsForRight(2));
		//du lịch
		model.addAttribute("travel", newsService.findNewsForRight(3));
		//thời sự
		model.addAttribute("newsLeft", newsService.findNewsForLeft(4));
		model.addAttribute("newsRight", newsService.findNewsForRight(4));
		//chính trị
		model.addAttribute("politicsLeft", newsService.findNewsForLeft(5));
		model.addAttribute("politicsRight", newsService.findNewsForRight(5));
		//giải trí
		model.addAttribute("entertainLeft", newsService.findNewsForLeft(6));
		model.addAttribute("entertainRight", newsService.findNewsForRight(6));
		return "home";
	}
	
	
	//trang liên lạc với chúng tôi 
	// nếu chưa đăng nhập thì không hiện phần gửi tin nhắn cho admin
	@RequestMapping(value = "/contact")
	public String conntactWithUs(Model model, HttpSession httpSession) {
		Object obj = httpSession.getAttribute("userEntity");
		if (obj!=null)
		{
			UserEntity userEntity = (UserEntity)obj;
			int userId = userEntity.getUserID();
			model.addAttribute("user", userService.findByUserId(userId));
			List<CateEntity> cateEntitiesList = categoryService.findAll();
			model.addAttribute("cateList", cateEntitiesList);
			model.addAttribute("random", newsService.findNewsRandom());
			model.addAttribute("lastestNews", newsService.findLast());
			return "contact";
		} else {
			List<CateEntity> cateEntitiesList = categoryService.findAll();
			model.addAttribute("cateList", cateEntitiesList);
			model.addAttribute("random", newsService.findNewsRandom());
			model.addAttribute("lastestNews", newsService.findLast());
			return "contact";
		}
	}
	
	//chi tiết bài viết
	@RequestMapping("/details/{newsId}")
	public String showDetailsPage(Model model, @PathVariable int newsId) {
		CommentEntity commentEntity = new CommentEntity();
		//model.addAttribute("authorOfComment", userService.findByUserId(commentEntity.getUserId()));
		model.addAttribute("comment", commentService.findCommentByNewsId(newsId));
		model.addAttribute("lastestNews", newsService.findLast());
		model.addAttribute("cateList", categoryService.findAll());
		model.addAttribute("details", newsService.findByIdNews(newsId));
		model.addAttribute("random", newsService.findNewsRandom());
		model.addAttribute("cate", categoryService.findCateName(newsId));
		model.addAttribute("person", userService.findNameAuthorByNewsId(newsId));
		return "single_page";
	}
	
	// phần bình luận trong trang chi tiết bài viết
	// phải đăng nhập sau đó mới cho bình luận
	@RequestMapping(value = "/details/{newsId}", params = {"main"}, method = RequestMethod.POST)
	public String createComment(@PathVariable int newsId, @RequestParam("main")String main, HttpSession httpSession) {
		NewsEntity newsEntity = newsService.findByIdNews(newsId);
		Object obj = httpSession.getAttribute("userEntity");
		UserEntity userEntity = (UserEntity)obj;
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setCommentMain(main);
		commentEntity.setUserId(userEntity);
		commentEntity.setNewsId(newsEntity);
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    commentEntity.setCommentDate(sqlDate);
	    commentService.save(commentEntity);
	    
		return "redirect:/details/{newsId}";
	}
	
	// tạo bài viết mới
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
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    newsEntity.setDate_submitted(sqlDate);
		newsService.save(newsEntity);
		return "redirect:/author";
	}
	
	// sửa bài viết
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
	
	// xóa bài viết
	@RequestMapping("/delete/{id}" )
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		NewsEntity newsEntity = newsService.findByIdNews(id);
				newsService.delete(newsEntity);

		return "redirect:/author";
	}
	
	@RequestMapping(value="/search",params= {"searchString"})
    public String search(@RequestParam("searchString") String s, Model model) {
        if (s.equals("")) {
            return "redirect:/home";
        }
        model.addAttribute("lastestNews", newsService.findLast());
        model.addAttribute("cateList", categoryService.findAll());
        model.addAttribute("random", newsService.findNewsRandom());
        model.addAttribute("news",newsService.search(s));
        return "search";
    }
	
	//show danh sách bài viết theo category
	@RequestMapping("/category/{cateId}")
	public String showCate(Model model, @PathVariable int cateId) {
		model.addAttribute("lastestNews", newsService.findLast());
		model.addAttribute("cateList", categoryService.findAll());
		model.addAttribute("random", newsService.findNewsRandom());
		model.addAttribute("cate", newsService.findById(cateId));
		model.addAttribute("tag", cateId);
		return "list";
	}

}
