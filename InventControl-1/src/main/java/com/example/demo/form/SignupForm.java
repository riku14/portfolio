package com.example.demo.form;

import org.springframework.format.annotation.NumberFormat;

import lombok.Data;

@Data
public class SignupForm {
	private String name;
	private Integer tekisei;
	private Integer zaiko;
	
	@NumberFormat(pattern = "#,###")
	private Integer price;
	
	private String detail;

}
