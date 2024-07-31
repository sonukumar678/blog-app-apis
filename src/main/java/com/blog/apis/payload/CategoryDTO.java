package com.blog.apis.payload;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CategoryDTO {
	
	private Integer categortId;
	
	@NotBlank
	@Size(min = 4, message = "Min size of category is 4 char")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 10, message = "Min size of category is 10 char")
	private String categoryDescription;
}
