package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.materials.model.Materials;
import com.example.demo.domain.materials.service.MaterialsService;
import com.example.demo.form.SignupForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/materials")
@Slf4j
public class SignupController {
	
	@Autowired
	private MaterialsService materialsService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	//資材登録画面を表示
	@GetMapping("/signup")
	public String getSignup(Model model, @ModelAttribute SignupForm form) {
		
		//資材登録画面に遷移
		return "materials/signup";
	}
	
	
	/**資材登録処理*/
	@PostMapping("/signup")
	public String postSignup(Model model, @ModelAttribute @Validated SignupForm form, BindingResult bindingResult) {
		
		//入力チェック結果
		if(bindingResult.hasErrors()) {
			//エラー発生したら資材登録画面に戻る
			return getSignup(model, form);
		}
		
		log.info(form.toString());
		
		//formをMaterialsクラスに変換（modelMapperでformのフィールドをコピー）
		//他の画面からもサービスを利用しやすい、formの変更がMaterialsServiceに影響しない
		Materials materials = modelMapper.map(form, Materials.class);  
		
		
		//資材を登録
		materialsService.signup(materials);  //資材登録処理の呼び出し
		
		//資材詳細一覧画面に遷移
		return "redirect:/materials/list";
	}
	
	

}
