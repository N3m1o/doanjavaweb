package com.laptrinhjavaweb.controller;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

<<<<<<< HEAD
import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.naming.java.javaURLContextFactory;
=======
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
>>>>>>> 248a4d3f1139dad02e247344853e74b28539f26d
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import net.bytebuddy.matcher.ModifierMatcher.Mode;

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
<<<<<<< HEAD

	
	 @RequestMapping(value = "/author") 
	 public String findAll(Model model,HttpSession httpSession)
	 { 
		 
	 return "redirect:/author/all/1"; 
	 }
	 
	 @RequestMapping(value = "/author/{filter}/{pageId}")
	 public String findAllPagination (@PathVariable String filter,@PathVariable int pageId,Model model,HttpSession httpSession, HttpServletRequest request) {
		 
		 Object obj = httpSession.getAttribute("userEntity"); 
		 UserEntity userEntity = (UserEntity)obj; int userId = userEntity.getUserID();
		 int newsNumber;
		 int pageIdLimit;
		 int pageIdNumber;
		 if (filter.equals("all")) {
			 List<NewsEntity> allNews = newsService.findNewsByUserId(userId);
			 newsNumber = allNews.size();
			 if (newsNumber%5==0 && newsNumber!=0) {
				 pageIdLimit = allNews.size()/5;
			 } else {
				 pageIdLimit = allNews.size()/5+1;
			 }
			 pageIdNumber = newsService.findNewsByUserIdPagination(userId, (pageId-1)*5,5 ).size();
			 model.addAttribute("news", newsService.findNewsByUserIdPagination(userId, (pageId-1)*5,5 ));
			 model.addAttribute("combobox", 1);
			 request.setAttribute("filter", "all");
		 } else if (filter.equals("daduyet")) {
			 List<NewsEntity> allNews = newsService.findNewsByUserIdStatusTrue(userId);
			 newsNumber = allNews.size();
			 if (newsNumber%5==0 && newsNumber!=0) {
				 pageIdLimit = allNews.size()/5;
			 } else {
				 pageIdLimit = allNews.size()/5+1;
			 }
			 pageIdNumber = newsService.findNewsByUserIdPaginationStatusTrue(userId, (pageId-1)*5,5 ).size();
			 model.addAttribute("news", newsService.findNewsByUserIdPaginationStatusTrue(userId, (pageId-1)*5,5 ));
			 model.addAttribute("combobox", 2);
			 request.setAttribute("filter", "daduyet");
		 } else {
			 List<NewsEntity> allNews = newsService.findNewsByUserIdStatusFalse(userId);
			 newsNumber = allNews.size();
			 if (newsNumber%5==0 && newsNumber!=0) {
				 pageIdLimit = allNews.size()/5;
			 } else {
				 pageIdLimit = allNews.size()/5+1;
			 }
			 pageIdNumber = newsService.findNewsByUserIdPaginationStatusFalse(userId, (pageId-1)*5,5 ).size();
			 model.addAttribute("news", newsService.findNewsByUserIdPaginationStatusFalse(userId, (pageId-1)*5,5 ));
			 model.addAttribute("combobox", 3);
			 request.setAttribute("filter", "chuaduyet");
		 }
		 
		 List<CateEntity> cateEntitiesList = categoryService.findAll();
		 model.addAttribute("cateList", cateEntitiesList); 
		 request.setAttribute("pageId", pageId);
		 request.setAttribute("newsNumber", newsNumber);
		 request.setAttribute("pageIdLimit", pageIdLimit);
		 request.setAttribute("pageIdNumber", pageIdNumber);
		 request.setAttribute("newsNumber", newsNumber);
		 return "PostManager";
	 }
	 

	

	// hiển thị bài viết trên trang admin
	@RequestMapping(value = "/admin-news")
	public String findAllAdminNews(Model model) {
		model.addAttribute("news", newsService.findAll());
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		model.addAttribute("cateList", cateEntitiesList);
		return "AdminNews";
	}

	// Duyệt bài viết
	@RequestMapping("/submit/{newsId}")
	public String showSubmitNewsPage(@PathVariable int newsId, Model model) {
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		model.addAttribute("cateList", cateEntitiesList);
		model.addAttribute("news", newsService.findByIdNews(newsId));
		return "edit";
	}

	@RequestMapping(value = "/edit/{newsId}", method = RequestMethod.POST)
	public String submitNews(@PathVariable("newsId") int newsId, HttpSession httpSession) {

		// CateEntity cateEntity = categoryService.findCateById(category);
		NewsEntity newsEntity = newsService.findByIdNews(newsId);
		newsEntity.setStatus(true);
		newsService.save(newsEntity);
		return "redirect:/admin-news";
	}

=======
		@RequestMapping(value = "/author")
		public String show(Model model, HttpSession httpSession, RedirectAttributes redirectAttributes, HttpServletRequest request) {
			//Object obj = httpSession.getAttribute("userEntity");
			//UserEntity userEntity = (UserEntity)obj;
			//int userId = userEntity.getUserID();
			//model.addAttribute("news", newsService.findNewsByUserId(userId));
			//List<CateEntity> cateEntitiesList = categoryService.findAll();
			//model.addAttribute("cateList", categoryService.findAll());
			request.getSession().setAttribute("newsList", null);
			return "redirect:/author/page/1";			//PostManager
		}
	
			//Phân trang trang xem bài viết của nhà báo
			@RequestMapping(value = "/author/page/{pageNumber}")
			public String showNewsAuthorPage(HttpServletRequest request, @PathVariable int pageNumber, Model model, HttpSession httpSession) {
				PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("newsList");
				int pagesize = 5;
				Object obj = httpSession.getAttribute("userEntity");
				UserEntity userEntity = (UserEntity)obj;
				int userId = userEntity.getUserID();
				List<NewsEntity> list = (List<NewsEntity>) newsService.findNewsByUserId(userId);
				System.out.println(list.size());
				if (pages == null) {
					pages = new PagedListHolder<>(list);
					pages.setPageSize(pagesize);
				} else {
					final int goToPage = pageNumber - 1;
					if (goToPage <= pages.getPageCount() && goToPage >= 0) {
						pages.setPage(goToPage);
					}
				}
				
				request.getSession().setAttribute("newsList", pages);
				int current = pages.getPage() + 1;
				int begin = Math.max(1, current - list.size());
				int end = Math.min(begin + 5, pages.getPageCount());
				int totalPageCount = pages.getPageCount();
				String baseUrl = "/admin-news/page/";
				
				model.addAttribute("beginIndex", begin);
				model.addAttribute("endIndex", end);
				model.addAttribute("currentIndex", current);
				model.addAttribute("totalPageCount", totalPageCount);
				model.addAttribute("baseUrl", baseUrl);
				model.addAttribute("news", pages);
				model.addAttribute("pageSize", pagesize);
	 			
				model.addAttribute("newsList", list);
				List<CateEntity> cateEntitiesList = categoryService.findAll();
				model.addAttribute("cateList", cateEntitiesList);
				
				return "PostManager";
			}	
	
/************************************************************************************************************************
 * ***********************************************************************************************************************/
	
	// hiển thị bài viết trên trang admin 
		@RequestMapping(value = "/admin-news")
		public String index(Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {
			request.getSession().setAttribute("newsList", null);
			
			return "redirect:/admin-news/page/1";
		}
		
		//Phân trang trang xem bài viết của Admin 
		@RequestMapping(value = "/admin-news/page/{pageNumber}")
		public String showNewsPage(HttpServletRequest request, @PathVariable int pageNumber, Model model) {
			PagedListHolder<?> pages = (PagedListHolder<?>) request.getSession().getAttribute("newsList");
			int pagesize = 5;
			List<NewsEntity> list = (List<NewsEntity>) newsService.findAll();
			System.out.println(list.size());
			if (pages == null) {
				pages = new PagedListHolder<>(list);
				pages.setPageSize(pagesize);
			} else {
				final int goToPage = pageNumber - 1;
				if (goToPage <= pages.getPageCount() && goToPage >= 0) {
					pages.setPage(goToPage);
				}
			}
			
			request.getSession().setAttribute("newsList", pages);
			int current = pages.getPage() + 1;
			int begin = Math.max(1, current - list.size());
			int end = Math.min(begin + 5, pages.getPageCount());
			int totalPageCount = pages.getPageCount();
			String baseUrl = "/admin-news/page/";
			
			model.addAttribute("beginIndex", begin);
			model.addAttribute("endIndex", end);
			model.addAttribute("currentIndex", current);
			model.addAttribute("totalPageCount", totalPageCount);
			model.addAttribute("baseUrl", baseUrl);
			model.addAttribute("news", pages);
			model.addAttribute("pageSize", pagesize);
 			
			model.addAttribute("newsList", list);
			List<CateEntity> cateEntitiesList = categoryService.findAll();
			model.addAttribute("cateList", cateEntitiesList);
			
			return "AdminNews";
		}
		
		// Duyệt bài viết
		@RequestMapping("/submit/{newsId}")
		public String showSubmitNewsPage(@PathVariable int newsId, Model model) {
			List<CateEntity> cateEntitiesList = categoryService.findAll();
			model.addAttribute("cateList", cateEntitiesList);
			model.addAttribute("news", newsService.findByIdNews(newsId));
			return "edit";
		}
		
		@RequestMapping(value = "/edit/{newsId}", method = RequestMethod.POST)
		public String submitNews(@PathVariable("newsId")int newsId, HttpSession httpSession) {
			
			//CateEntity cateEntity = categoryService.findCateById(category);
			NewsEntity newsEntity = newsService.findByIdNews(newsId);
			newsEntity.setStatus(true);
			newsService.save(newsEntity);
			return "redirect:/admin-news";
		}
	
>>>>>>> 248a4d3f1139dad02e247344853e74b28539f26d
	// lấy ra bài viết hiển thị trên trang chủ
	@RequestMapping(value = "/home")
	public String findLastestNews(Model model) {
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		model.addAttribute("cateList", cateEntitiesList);
		model.addAttribute("random", newsService.findNewsRandom());
		model.addAttribute("lastestNews", newsService.findLast());
		model.addAttribute("news", newsService.findAll());
		// Đổ dữ liệu vào các field trên HOME
		// dữ liệu của thể thao
		model.addAttribute("sportLeft", newsService.findNewsForLeft(1));
		model.addAttribute("sportRight", newsService.findNewsForRight(1));
		// dữ liệu của văn hóa
		model.addAttribute("cultural", newsService.findNewsForRight(2));
		// du lịch
		model.addAttribute("travel", newsService.findNewsForRight(3));
		// thời sự
		model.addAttribute("newsLeft", newsService.findNewsForLeft(4));
		model.addAttribute("newsRight", newsService.findNewsForRight(4));
		// chính trị
		model.addAttribute("politicsLeft", newsService.findNewsForLeft(5));
		model.addAttribute("politicsRight", newsService.findNewsForRight(5));
		// giải trí
		model.addAttribute("entertainLeft", newsService.findNewsForLeft(6));
		model.addAttribute("entertainRight", newsService.findNewsForRight(6));
		return "home";
	}

	// trang liên lạc với chúng tôi
	// nếu chưa đăng nhập thì không hiện phần gửi tin nhắn cho admin
	@RequestMapping(value = "/contact")
	public String conntactWithUs(Model model, HttpSession httpSession) {
		Object obj = httpSession.getAttribute("userEntity");
		if (obj != null) {
			UserEntity userEntity = (UserEntity) obj;
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

	// chi tiết bài viết
	@RequestMapping("/details/{newsId}")
	public String showDetailsPage(Model model, @PathVariable int newsId) {
		// CommentEntity commentEntity = new CommentEntity();
		// model.addAttribute("authorOfComment",
		// userService.findByUserId(commentEntity.getUserId()));
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
	@RequestMapping(value = "/details/{newsId}", params = { "main" }, method = RequestMethod.POST)
	public String createComment(@PathVariable int newsId, @RequestParam("main") String main, HttpSession httpSession) {
		NewsEntity newsEntity = newsService.findByIdNews(newsId);
		Object obj = httpSession.getAttribute("userEntity");
		UserEntity userEntity = (UserEntity) obj;
		CommentEntity commentEntity = new CommentEntity();
		commentEntity.setCommentMain(main);
		commentEntity.setUserId(userEntity);
		commentEntity.setNewsId(newsEntity);

		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(utilDate.getTime());

		commentEntity.setCommentDate(sqlDate);
		commentService.save(commentEntity);

		return "redirect:/details/{newsId}";
	}

	// tạo bài viết mới
	@RequestMapping(value = "/author", params = { "title", "display_image", "content", "short_description",
			"category" }, method = RequestMethod.POST)
	public String createNews(@RequestParam("title") String title, @RequestParam("display_image") String display_image,
			@RequestParam("content") String content, @RequestParam("short_description") String short_description,
			@RequestParam("category") int category, HttpSession httpSession) {
		CateEntity cateEntity = categoryService.findCateById(category);
		Object obj = httpSession.getAttribute("userEntity");
		UserEntity userEntity = (UserEntity) obj;
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setContent(content);
		newsEntity.setDisplay_img(display_image);
		newsEntity.setShortDescription(short_description);
		newsEntity.setStatus(false);
		newsEntity.setTitle(title);
		newsEntity.setUserId(userEntity);
		newsEntity.setCateId(cateEntity);
		java.util.Date utilDate = new java.util.Date();
		java.sql.Timestamp sqlDate = new java.sql.Timestamp(utilDate.getTime());
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

	@RequestMapping(value = "/edit/{newsId}", params = { "id", "title", "display_image", "content", "short_description",
			"category" }, method = RequestMethod.POST)
	public String editNews(@RequestParam("id") int newsId, @RequestParam("title") String title,
			@RequestParam("display_image") String display_image, @RequestParam("content") String content,
			@RequestParam("short_description") String short_description, @RequestParam("category") int category,
			HttpSession httpSession) {

		CateEntity cateEntity = categoryService.findCateById(category);
		Object obj = httpSession.getAttribute("userEntity");
		UserEntity userEntity = (UserEntity) obj;
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setContent(content);
		newsEntity.setDisplay_img(display_image);
		newsEntity.setShortDescription(short_description);
		newsEntity.setStatus(false);
		newsEntity.setTitle(title);
		newsEntity.setUserId(userEntity);
		newsEntity.setCateId(cateEntity);
		newsEntity.setNewsId(newsId);
		newsService.save(newsEntity);
		return "redirect:/author";
	}

	// xóa bài viết
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable int id, RedirectAttributes redirect) {
		NewsEntity newsEntity = newsService.findByIdNews(id);
		newsService.delete(newsEntity);

		return "redirect:/author";
	}

	@RequestMapping("/deleteByAdmin/{id}")
	public String deleteByAdmin(@PathVariable int id, RedirectAttributes redirect) {
		NewsEntity newsEntity = newsService.findByIdNews(id);
		newsService.delete(newsEntity);

		return "redirect:/admin-news";
	}
<<<<<<< HEAD

	@RequestMapping(value = "/search", params = { "searchString" })
	public String search(@RequestParam("searchString") String s, Model model) {
		if (s.equals("")) {
			return "redirect:/home";
		}
		model.addAttribute("lastestNews", newsService.findLast());
		model.addAttribute("cateList", categoryService.findAll());
		model.addAttribute("random", newsService.findNewsRandom());
		model.addAttribute("news", newsService.search(s));
		return "search";
	}

	// show danh sách bài viết theo category
=======
	
	//Tìm kiếm theo tên bài viết
	
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
>>>>>>> 248a4d3f1139dad02e247344853e74b28539f26d
	@RequestMapping("/category/{cateId}")
	public String showCate(Model model, @PathVariable int cateId) {
		model.addAttribute("lastestNews", newsService.findLast());
		model.addAttribute("cateList", categoryService.findAll());
		model.addAttribute("random", newsService.findNewsRandom());
		model.addAttribute("cate", newsService.findById(cateId));
		model.addAttribute("tag", cateId);
		return "list";
	}

	// Trang preview của admin

	@RequestMapping("/preview/{newsId}")
	public String preview(@PathVariable int newsId, Model model) {
		List<CateEntity> cateEntitiesList = categoryService.findAll();
		model.addAttribute("cateList", cateEntitiesList);
		model.addAttribute("news", newsService.findByIdNews(newsId));
		return "preview";
	}

	@RequestMapping(value = "/preview/{newsId}", params = { "id" }, method = RequestMethod.POST)
	public String preview(@RequestParam("id") int newsId) {

		NewsEntity newsEntity = newsService.findByIdNews(newsId);
		newsEntity.setStatus(true);
		newsService.save(newsEntity);
		return "redirect:/admin-news";
	}

}
