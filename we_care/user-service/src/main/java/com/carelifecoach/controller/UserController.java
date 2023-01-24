package com.carelifecoach.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carelifecoach.dto.UserDTO;
import com.carelifecoach.entity.User;
import com.carelifecoach.register.RegisterUserRequest;
import com.carelifecoach.response.UserResponse;
import com.carelifecoach.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	
		
			@Autowired
			UserService userService;

			@GetMapping("/message")
			public String getMessage() {
				return "userService";
			}
			
			
			
			@PostMapping("/register")
			public UserResponse RegisterUser (@RequestBody RegisterUserRequest registerUserRequest) {
				return userService.registerUser(registerUserRequest);
			}
			
			/*
			 * @PostMapping("/login") public String getLoginById(@RequestBody User user) {
			 * return userService.getLoginById(user); }
			 */
			
			@PostMapping("/login")
			public ResponseEntity<Boolean> loginUser(@RequestBody UserDTO user) throws Exception{
				Boolean response = userService.loginUser(user);;
				return new ResponseEntity<>(response, HttpStatus.OK);
			}
			
			@GetMapping("users/{Id}")
			public ResponseEntity<UserDTO> getUserProfile(@PathVariable String userId) throws Exception{
				UserDTO userDTO = userService.getUserProfile(userId);
				return new ResponseEntity<>(userDTO, HttpStatus.OK);
			}
		}


