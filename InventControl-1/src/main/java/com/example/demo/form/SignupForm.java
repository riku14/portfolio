package com.example.demo.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import lombok.Data;

@Data
public class SignupForm {
	
	@NotBlank
	private String name;
	
	@NotNull
	private Integer tekisei;
	@NotNull
	private Integer zaiko;
	
	@NotNull
	@NumberFormat(pattern = "#,###")
	private Integer price;
	
	@NotNull
	private String detail;

}
