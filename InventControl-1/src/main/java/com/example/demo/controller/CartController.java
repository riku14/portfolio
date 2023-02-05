package com.example.demo.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.materials.model.Materials;
import com.example.demo.domain.materials.service.MaterialsService;
import com.example.demo.form.CartForm;
import com.example.demo.form.MaterialsEditForm;
import com.example.demo.form.OrderListForm;

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
		
		//発注確認画面表示
		return "materials/cart";
	}
	
	
	@PostMapping(value ="/cart", params = "update")
	public String updateCart(CartForm form, Model model) {
		
		try {
			//資材情報を更新
			materialsService.updateCart(form.getName(),  form.getKosuu(),form.getZaiko(), form.getGoukei() );
			}catch(Exception e) {
				log.error("資材f発注でエラー", e);
			}
			
			//資材一覧画面に戻る
			return "redirect:/materials/list";
		
	}
	
	
	

}
