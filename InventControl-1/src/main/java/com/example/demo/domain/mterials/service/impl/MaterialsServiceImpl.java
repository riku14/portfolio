package com.example.demo.domain.mterials.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.domain.materials.model.Materials;
import com.example.demo.domain.materials.service.MaterialsService;
import com.example.demo.repository.MaterialsMapper;

@Service
public class MaterialsServiceImpl implements MaterialsService {
	
	@Autowired
	private MaterialsMapper mapper;
	
	/**資材登録*/
	@Override
	public void signup(Materials materials) {
		mapper.insertOne(materials);
	}
	
	/**資材取得（一覧）*/
	@Override
	public List<Materials> getMaterials(Materials materials){
		return mapper.findMany(materials);
	}
	/**資材取得（１件）*/
	@Override
	public Materials getMaterialsOne(String name) {
		return mapper.findOne(name);
	}
	
	
	/**資材情報更新*/
	@Override
	public void updateMaterials(String name, Integer tekisei, Integer zaiko, Integer price, String detail) {
		mapper.updateOne(name, tekisei, zaiko, price, detail);
	}
	
	/**資材削除*/
	public void deleteMaterials(String name) {
		int count = mapper.deleteOne(name);
	}
	

}
