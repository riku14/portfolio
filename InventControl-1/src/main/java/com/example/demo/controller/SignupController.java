package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/materials")
@Slf4j
public class SignupController {
	
	//資材登録画面を表示
	@GetMapping("/signup")
	public String getSignup(Model model, @ModelAttribute SignupForm form) {
		
		//資材登録画面に遷移
		return "materials/signup";
	}
	
	
	//資材登録処
	@PostMapping("/signup")
	public String postSignup(@ModelAttribute SignupForm form) {
		
		
		
		log.info(form.toString());
		
		//資材詳細一覧画面に遷移
		return "redirect:/list";
	}

}
