package com.example.demo.form;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class CartForm {
	private String name;
	private String detail;
	private Integer price;
	@NotNull
	@NotBlank
	private Integer kosuu;
	private Integer goukei;
	private Integer zaiko;
	private Date orderDay;
}
