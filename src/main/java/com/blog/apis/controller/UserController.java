package com.blog.apis.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.apis.entities.User;
import com.blog.apis.payload.ApiResponse;
import com.blog.apis.payload.UserDTO;
import com.blog.apis.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")

public class UserController {
	
	@Autowired
	private UserService userService;
	
	//post-create user
	@PostMapping("/")
	public ResponseEntity<UserDTO> createUser(@Valid @RequestBody UserDTO userDTO){
		UserDTO userCreated = this.userService.createUser(userDTO);
		return new ResponseEntity<>(userCreated,HttpStatus.CREATED);
	}
	
	//Get-get all User
	@GetMapping("/")
	public ResponseEntity<List<UserDTO>> getAllUser(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
	
	//Get-get single User
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getSingleUser(@PathVariable("userId") Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
	
	//put-update User
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> updateUser(@Valid @RequestBody UserDTO userDTO, @PathVariable("userId") Integer userId){
		UserDTO updateUser = this.userService.updateUser(userDTO, userId);
		return new ResponseEntity<>(updateUser, HttpStatus.OK);
		
	}
	
	//delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<?> deleteUser(@PathVariable("userId") Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User deleted successfully", true), HttpStatus.OK);
	}

}
