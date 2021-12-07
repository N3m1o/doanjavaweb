package com.laptrinhjavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(UserEntity userEntity, Model model) {
		if (userEntity.getUsername() != null && userEntity.getPassword() != null) 
		{
				if (userService.findByUserAndPass(userEntity) != null) 
					return "home";
				return "login";
		}
		else 
		{
		model.addAttribute("mess", "Nhập sai tài khoản hoặc mật khẩu");
		return "login";
		}
	}
	
	// sign up
	@PostMapping("/sign")
	public String sign(UserEntity userEntity) {
		if (userEntity.getFullname() != null && userEntity.getUsername() != null && userEntity.getPassword() != null) {
			try {
				if (userService.findByUser(userEntity) != null) {
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
	
}
