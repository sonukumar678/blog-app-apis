package com.blog.apis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blog.apis.config.JwtUtils;
import com.blog.apis.exceptions.ApiException;
import com.blog.apis.exceptions.ResourceNotFoundException;
import com.blog.apis.payload.JwtRequest;
import com.blog.apis.payload.JwtResponse;
import com.blog.apis.payload.UserDTO;
import com.blog.apis.security.CustomUserDetailsService;
import com.blog.apis.services.UserService;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtUtils jwtUtils;
	
	//generate token
	@PostMapping("/generate-token")
	public ResponseEntity<JwtResponse> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		try {
			authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
			
		}catch (ResourceNotFoundException e) {
			e.printStackTrace();
			throw new Exception("User not found");
		}
		
		///user authencated
		UserDetails userDetails  =this.customUserDetailsService.loadUserByUsername(jwtRequest.getUsername());
		String token = this.jwtUtils.generateToken(userDetails);
		return ResponseEntity.ok(new JwtResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username, password);
		try {
			authenticationManager.authenticate(authentication);
			
		}catch (DisabledException e) {
			throw new Exception("USER DESABLED"+ e.getMessage());
		}catch (BadCredentialsException e) {
			throw new ApiException("Invalid password !!");
		}
		
	}
	
	//register new user
	@PostMapping("/register")
	public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO){
		UserDTO registerUser = this.userService.registerUser(userDTO);
		return new ResponseEntity<UserDTO>(registerUser, HttpStatus.CREATED);
	}
	

}
