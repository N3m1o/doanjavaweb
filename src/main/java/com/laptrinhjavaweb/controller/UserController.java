package com.laptrinhjavaweb.controller;

import java.sql.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	// login
	@RequestMapping(value = "/login")
	public String showFormLogin(Model model) {
		return "login";
	}
	
	// Thuc hien dang nhap
	@RequestMapping(value = "/login",params = {"username","password"}, method = RequestMethod.POST)
	public String login(@RequestParam("username")String username, @RequestParam("password")String password,Model  model, HttpSession httpSession) {
		UserEntity userEntity = userService.getUserByUsername(username);
		if (userEntity!= null && userEntity.getPassword().equals(password)) 
		{
			httpSession.setAttribute("userEntity", userEntity);
			
			return "redirect:/home";

		}
		else 
		{
		model.addAttribute("mess", "Nhập sai tài khoản hoặc mật khẩu");
			return "login";
		}
	}
	
	// Thuc hien Dang xuat
	@RequestMapping(value = "/logout")
	public String logOut(HttpSession httpSession) {
		httpSession.removeAttribute("userEntity");
		return "redirect:/home";
	}

	// Chức năng đăng ký
	@RequestMapping(value = "/register",params = {"user","pass","repass"}, method = RequestMethod.POST)
	public String signup(@RequestParam("user")String username,@RequestParam("pass")String password,@RequestParam("repass")String repass, Model model) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUsername(username);
		userEntity.setPassword(password);
		userEntity.setFullname("Anonymous");
		userEntity.setGender(0);
		userEntity.setIsAuthor(0);
		userEntity.setIsAdmin(0);
		userEntity.setUser_img("https://pdp.edu.vn/wp-content/uploads/2021/05/hinh-anh-mat-cuoi-dep-cute-cam-xuc.jpg");
		if (!repass.equals(password)) {
			model.addAttribute("alert1", "Repeat Password phải trùng với Password");
			return "register";
			
		} else {
			if (userService.findByName(username)!=null) {
				model.addAttribute("alert2","Tên đăng nhập đã tồn tại");
				return "register";
			}
			else {
				userService.save(userEntity);
				return "redirect:/login";
			}
		}
	}
	
	@RequestMapping(value = "/register")
	public String getsignup() {
		return "register";
	}

	
	// Chỉnh sửa thông tin cá nhân
	@RequestMapping("/user/{userId}")
    public String showEditNewsPage(@PathVariable int userId, Model model, HttpSession httpSession) {
        Object obj = httpSession.getAttribute("userEntity");
        if (obj!=null) {
            model.addAttribute("user", userService.findByUserId(userId));
            return "profile";
        } else {
            return "redirect:/home";
        }

    }

    @RequestMapping(value = "/user/{userId}", params = {"username","fullname","user_img","gender","short_description","date_of_birth"}, method = RequestMethod.POST)
    public String editUser(@RequestParam("username")String username,@RequestParam("fullname")String fullname,@RequestParam("user_img")String user_img, @RequestParam("date_of_birth")Date date_of_birth,
            @RequestParam("gender")int gender,@RequestParam("short_description")String short_description
            , HttpSession httpSession) {
        Object obj = httpSession.getAttribute("userEntity");
        UserEntity userEntity = (UserEntity)obj;
        userEntity.setUsername(username);
        userEntity.setFullname(fullname);
        userEntity.setUser_img(user_img);
        userEntity.setGender(gender);
        userEntity.setShort_description(short_description);
        userEntity.setDateOfBirth(date_of_birth);
        userService.save(userEntity);
        return "redirect:/user/{userId}";
    }
}
