package com.example.demo.form;

import java.util.Date;

import lombok.Data;

@Data
public class CartForm {
	private String name;
	private String detail;
	private Integer price;
	private Integer kosuu;
	private Integer goukei;
	private Integer zaiko;
	private Date orderDay;
}
