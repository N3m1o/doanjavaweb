package com.laptrinhjavaweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.laptrinhjavaweb.entity.NewEntity;

@Controller
public class HomeController {
	@PostMapping(value = "/home")
	public NewEntity createNew(@RequestBody NewEntity model) {
		return model;
	}
}
