package com.ltimindtree.reactmicrservice.api;

import java.util.List;

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


import com.ltimindtree.reactmicrservice.dto.UserDTO;
import com.ltimindtree.reactmicrservice.service.userService;

@RestController
@RequestMapping(value = "/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserApi {
	@Autowired
	private userService userService;
	@GetMapping(value = "/view")
	public ResponseEntity<List<UserDTO>> getAllUsers()  {
		List<UserDTO>userrList = userService.getAllUsers();
		return new ResponseEntity<>(userrList, HttpStatus.OK);
	}
	
	@GetMapping(value = "/view/{userId}")
	public ResponseEntity<UserDTO> getCustomer(@PathVariable Integer userId) throws Exception  {
		
		UserDTO user = userService.getUser(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
		
	}
	@PutMapping(value = "/edit/{userId}")
	public ResponseEntity<String> updateCustomer(@PathVariable Integer userId, @RequestBody UserDTO user)
			throws Exception {
		userService.updateUser(userId,user);
	return new ResponseEntity<>( HttpStatus.OK);
	}	
	
	@DeleteMapping(value = "/user/{userId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable Integer userId) throws Exception {
		userService.deleteUser(userId);
	
		return new ResponseEntity<>( HttpStatus.OK);
	}
	@PostMapping(value = "/add")
	public ResponseEntity<String> addCustomer(@RequestBody UserDTO user) throws Exception {
		Integer customerId = userService.addUser(user);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
