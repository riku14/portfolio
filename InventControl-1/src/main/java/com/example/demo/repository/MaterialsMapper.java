package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.domain.materials.model.Materials;

@Mapper
public interface MaterialsMapper {
	//登録処理
	/**資材登録*/
	public int insertOne(Materials materials);
	
	//一覧画面
	/**資材取得（一覧）*/
	public List<Materials> findMany(Materials materials);
	
	/**資材取得（１件）*/
	public Materials findOne(String name);
	
	
	//編集画面の機能
	/**資材情報更新*/
	public void updateOne(@Param("name") String name, @Param("tekisei") Integer tekisei, @Param("zaiko") Integer zaiko, @Param("price") Integer price, @Param("detail") String detail);
	
	/**資材削除*/
	public int deleteOne(@Param("name") String name); 
	
	//資材発注画面の機能
	/**資材取得（発注）*/
	public Materials cart(String name);
	
	/**資材発注処理*/
	public void updateCart(@Param("name") String name, @Param("kosuu") Integer kosuu, @Param("goukei") Integer goukei, @Param("zaiko") Integer zaiko);

	
	

}
