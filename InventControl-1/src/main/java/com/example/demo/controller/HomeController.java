package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/materials")
public class HomeController {
	
	@GetMapping("/home")
	public String getHome() {
		
		//ホーム画面表示
		return "materials/home";
	}

}
