package com.blog.apis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.apis.payload.ApiResponse;
import com.blog.apis.payload.CategoryDTO;
import com.blog.apis.services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/")
	public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){
		CategoryDTO createCategory = this.categoryService.createCategory(categoryDTO);
		return new ResponseEntity<CategoryDTO>(createCategory, HttpStatus.CREATED);
	}
	
	@PutMapping("/{catId}")
	public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO categoryDTO, @PathVariable Integer catId){
		CategoryDTO updatedCategory = this.categoryService.updateCategory(categoryDTO,catId);
		return new ResponseEntity<CategoryDTO>(updatedCategory, HttpStatus.OK);
	}
	
	@DeleteMapping("/{catId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
		this.categoryService.deleteCategory(catId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category is deleted successfully ", true), HttpStatus.OK);
	}
	
	@GetMapping("/{catId}")
	public ResponseEntity<CategoryDTO> getCategory(@PathVariable Integer catId){
		CategoryDTO categoryDto = this.categoryService.getCategory(catId);
		return new ResponseEntity<CategoryDTO>(categoryDto, HttpStatus.OK);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<CategoryDTO>> getAllCategories(){
		List<CategoryDTO> categories = this.categoryService.getCategories();
		return ResponseEntity.ok(categories);
	}

}
