package com.manik.apis.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CategoryDto {


	private Integer categoryId;

	@NotBlank
	@Size(min=5,message = "Title should be atleast 5 chars long")
	private String categoryTitle;

	@NotBlank
	@Size(min=10,message = "Description should be atleast 10 chars long")
	private String categoryDescription;
	
	

}
