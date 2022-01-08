package com.laptrinhjavaweb.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
/**	
	// Thuc hien Dang ky
	@RequestMapping(value = "/signup",params = {"username","password"}, method = RequestMethod.POST)
	public String signUp(UserEntity userEntity) {
		if (userEntity.getUsername() != null && userEntity.getPassword() != null) {
			try {
				if (userService.findByUserId(userEntity) != null) {
					return "username da ton tai";
				}
				else {
					userService.findByUserId(userEntity);
					return "redirect:/login";
				}
			} catch (Exception e) {
				return "error";
			}
		} else {
			return "thiếu thông tin";
		}
	}
**/	
}
