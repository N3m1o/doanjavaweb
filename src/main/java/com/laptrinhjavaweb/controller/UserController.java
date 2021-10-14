package com.laptrinhjavaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	// login
	@PostMapping("/login")
	public String login(@RequestBody UserEntity userEntity) {
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
	public String sign(@RequestBody UserEntity userEntity) {
		if (userEntity.getFullname() != null && userEntity.getUsername() != null && userEntity.getPassword() != null) {
			try {
				if (userService.findByUser(userEntity) != null) {
					System.out.println("username da ton tai");
					return "/sign";
				}
				else {
					userService.findById(userEntity);
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
