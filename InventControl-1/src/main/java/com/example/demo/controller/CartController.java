package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.materials.model.Materials;
import com.example.demo.domain.materials.service.MaterialsService;
import com.example.demo.form.CartForm;
import com.example.demo.form.MaterialsEditForm;

import groovy.time.BaseDuration.From;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/materials")
@Slf4j
public class CartController {
	
	@Autowired
	private MaterialsService materialsService;
	
	@Autowired
	private ModelMapper modelMapper;

	
	@GetMapping("/cart/{name}")
	public String getCart(CartForm form, Model model, @PathVariable("name") String name) {
		
		//資材を一件取得（cart）
		Materials materials = materialsService.getCart(name);
		
		//Materialsをformに変換
		form = modelMapper.map(materials, CartForm.class); 
		
		//Modelに登録
		model.addAttribute("CartForm", form);
		
		//前回の発注履歴を表示
		//資材の一覧を取得
		List<Materials> materialsList = materialsService.getMaterials(materials);
		
		//Modelに登録
		model.addAttribute("materialsList", materialsList);

		
		//発注確認画面表示
		return "materials/cart";
	}
	
	
	@PostMapping(value ="/cart", params = "update")
	public String updateCart(CartForm form, Model model, BindingResult bindingResult) {
		
		//入力チェック結果
		if(bindingResult.hasErrors()) {
			//エラー発生したら資材発注画面に戻る
			return getCart(form, model, null);
		}
		
		try {
			//資材情報を更新
			materialsService.updateCart(form.getName(),  form.getKosuu(),form.getZaiko(), form.getGoukei(), form.getPrice(), form.getOrderDay() );
			}catch(Exception e) {
				log.error("資材f発注でエラー", e);
			}
			
			//資材一覧画面に戻る
			return "redirect:/materials/list";
		
	}
	
	
	

}
