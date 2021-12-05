package com.laptrinhjavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	// login
	@PostMapping("/login")
	public String login(UserEntity userEntity) {
		if (userEntity.getUsername() != null && userEntity.getPassword() != null) {
			try {
				if (userService.findByUserAndPass(userEntity) != null) {
					return "redirect:/home";
				}
				else {
					return "login";
				}
			} catch (Exception e) {
				return "error";
			}
		} else {
			return "thiếu thông tin";
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
