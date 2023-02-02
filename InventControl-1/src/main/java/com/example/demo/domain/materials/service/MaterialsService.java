package com.example.demo.domain.materials.service;

import java.util.List;

import com.example.demo.domain.materials.model.Materials;

public interface MaterialsService {
	//登録処理
	/**資材登録*/
	public void signup(Materials materials);
	
	//資材一覧
	/**資材取得（一覧）*/
	public List<Materials> getMaterials(Materials materials);
	
	/**資材取得（１件）*/
	public Materials getMaterialsOne(String name);
	
	
	//編集処理
	/**資材情報更新*/
	public void updateMaterials(String name, Integer tekisei, Integer zaiko,Integer price, String detail);
	
	/**資材削除*/
	public void deleteMaterials(String name);
	
	//資材発注確認の画面
	/**資材取得（cart）*/
	public Materials getCart(String name);
	
	/**資材発注処理*/
	public void updateCart(String name,Integer kosuu, Integer goukei, Integer zaiko);



}
