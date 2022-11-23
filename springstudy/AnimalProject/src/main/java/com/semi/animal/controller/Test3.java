package com.semi.animal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test3 {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
}
