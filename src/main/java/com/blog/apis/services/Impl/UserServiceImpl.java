package com.blog.apis.services.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.blog.apis.config.AppConstant;
import com.blog.apis.entities.Role;
import com.blog.apis.entities.User;
import com.blog.apis.exceptions.ResourceNotFoundException;
import com.blog.apis.payload.UserDTO;
import com.blog.apis.repository.RoleRepository;
import com.blog.apis.repository.UserRepository;
import com.blog.apis.services.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public UserDTO createUser(UserDTO userDTo) {
		User user = this.dtoToUser(userDTo);
		User savedUser = this.userRepository.save(user);
		return this.userToUserDto(savedUser);
	}

	@Override
	public UserDTO updateUser(UserDTO userDto, Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		User saveUser = this.userRepository.save(user);
		UserDTO userDto1 = this.userToUserDto(saveUser);
		return userDto1;
	}

	@Override
	public UserDTO getUserById(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", "Id", userId));
		return this.userToUserDto(user);
	}

	@Override
	public List<UserDTO> getAllUsers() {
		List<User> users = this.userRepository.findAll();
		List<UserDTO> userDto = users.stream().map(user->this.userToUserDto(user)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = this.userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		this.userRepository.delete(user);
	}
	
	
	public User dtoToUser(UserDTO userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		/*
		 * user.setId(userDto.getId()); user.setName(userDto.getName());
		 * user.setEmail(userDto.getEmail()); user.setPassword(userDto.getPassword());
		 * user.setAbout(userDto.getAbout());
		 */
		
		return user;
	}
	
	public UserDTO userToUserDto(User user) {
		UserDTO userDTO = this.modelMapper.map(user, UserDTO.class);
		/*
		 * userDTO.setId(user.getId()); userDTO.setName(user.getName());
		 * userDTO.setEmail(user.getEmail()); userDTO.setPassword(user.getPassword());
		 * userDTO.setAbout(user.getAbout());
		 */
		
		return userDTO;
	}

	@Override
	public UserDTO registerUser(UserDTO userDto) {
		User user = this.modelMapper.map(userDto, User.class);
		
		//encoded password
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		
		//assign role
		Role role = this.roleRepository.findById(AppConstant.NORMAL_USER).get();
		user.getRoles().add(role);
		User newUser = this.userRepository.save(user);
		return this.modelMapper.map(newUser, UserDTO.class);
	}


}
