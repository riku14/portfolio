package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/materials")
@Controller
public class OrderController {
	
	@GetMapping("/order")
	public String getOrder() {
		
		
		
		//発注確認画面を
		return "materials/order";
	}

}
