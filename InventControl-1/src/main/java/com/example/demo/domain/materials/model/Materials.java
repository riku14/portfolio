package com.example.demo.domain.materials.model;

import java.util.Date;

import lombok.Data;

@Data
public class Materials {
	private String name;
	private Integer zaiko;
	private Integer tekisei;
	private Integer price;
	private String detail;
	private Integer kosuu;
	private Integer goukei;
	private Date orderDay;

	
}
