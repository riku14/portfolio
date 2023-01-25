package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.materials.model.Materials;
import com.example.demo.domain.materials.service.MaterialsService;
import com.example.demo.form.MaterialsListForm;

@Controller
@RequestMapping("/materials")
public class MaterialsListController {
	
	@Autowired
	private MaterialsService materialsService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**資材一覧画面を表示*/
	@GetMapping("/list")
	public String getMaterialsList(@ModelAttribute MaterialsListForm form, Model model) {
		
		//formをMaterialsクラスに変換
		Materials materials = modelMapper.map(form, Materials.class);
		
		//資材の一覧を取得
		List<Materials> materialsList = materialsService.getMaterials(materials);
		
		//Modelに登録
		model.addAttribute("materialsList", materialsList);
		
		//資材一覧画面を表示
		return "materials/list";
	}
	
	//検索処理
	@PostMapping("/list")
	public String postMaterialsList(@ModelAttribute MaterialsListForm form, Model model) {
		
		//formをMaterialsクラスに変換
				Materials materials = modelMapper.map(form, Materials.class);
				
				//資材の一覧を取得
				List<Materials> materialsList = materialsService.getMaterials(materials);
				
				//Modelに登録
				model.addAttribute("materialsList", materialsList);
				
				//資材一覧画面を表示
				return "materials/list";
		
	}
	
	

}
