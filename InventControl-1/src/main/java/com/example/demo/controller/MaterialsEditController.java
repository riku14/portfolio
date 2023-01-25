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
import com.example.demo.form.MaterialsEditForm;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/materials")
@Slf4j
public class MaterialsEditController {
	
	@Autowired
	private MaterialsService materialsService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**資材編集画面を表示*/
	@GetMapping("/edit/{name}")
	public String getMaterials(MaterialsEditForm form, Model model, @PathVariable("name") String name) {
		
		//資材を一件取得
		Materials materials = materialsService.getMaterialsOne(name);
		
		//Materialsをformに変換
		form = modelMapper.map(materials, MaterialsEditForm.class);  //modelにコピーしているものをformに戻す(formを変更するため)
		
		//Modelに登録
		model.addAttribute("materialsEditForm", form);
		
		//資材情報の編集画面に表示
		return "materials/edit";
	}
	
	/**資材情報更新処理*/
	@PostMapping(value = "/edit", params = "update")
	public String updateMaterials(MaterialsEditForm form, Model model) {
		
		try {
		//資材情報を更新
		materialsService.updateMaterials(form.getName(), form.getZaiko(), form.getTekisei(), form.getPrice(), form.getDetail() );
		}catch(Exception e) {
			log.error("資材更新でエラー", e);
		}
		
		//資材一覧画面に戻る
		return "redirect:/materials/list";
	}
	
	/**資材削除処理*/
	@PostMapping(value = "/edit", params="delete")
	public String deleteMaterials(MaterialsEditForm form, Model model) {
		
		//資材削除
		materialsService.deleteMaterials(form.getName());
		
		//資材一覧画面に戻る
		return "redirect:/materials/list";
	}
	

}
