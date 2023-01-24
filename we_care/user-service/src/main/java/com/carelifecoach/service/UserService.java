package com.carelifecoach.service;



import java.io.Serializable;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.carelifecoach.dto.UserDTO;
import com.carelifecoach.entity.User;
import com.carelifecoach.register.RegisterUserRequest;
import com.carelifecoach.repository.UserRepository;
import com.carelifecoach.response.UserResponse;
import com.google.common.base.Optional;

import ch.qos.logback.classic.Logger;
@Service
public class UserService {

	
	@Autowired
	UserRepository userRepository;

	public UserResponse registerUser(RegisterUserRequest registerUserRequest) {
		
		User user = new User();
		user.setName(registerUserRequest.getName());
		user.setPassword(registerUserRequest.getPassword());
		user.setDateofbirth(registerUserRequest.getDateofbirth());
		user.setGender(registerUserRequest.getGender());
		user.getMobilenumber();
		userRepository.save(user);
		
		return new UserResponse(user);
		
	}

	public String getLoginById(long id, String username, String password) {

		
		
		User user=userRepository.findById(id).get();
		if (user.getName().equals(username) && user.getPassword().equals(password))
	      return username+"Login Successfully";
		else 
			return "Invalid Login and not a register user";
		
	
	}
	public Boolean loginUser( @RequestBody UserDTO user) throws Exception{
		java.util.Optional<User> userEntity = userRepository.findById(user.getId());
		if(userEntity.isPresent()) 
			return userEntity.get().getPassword().equals(user.getPassword());
		else
			throw new Exception("user not found");
			
	}
	public UserDTO getUserProfile(String userId) throws Exception{
		User userEntity = userRepository.findById(userId);
		UserDTO userDTO = new UserDTO();
			userDTO.setId(userEntity.getId());
			userDTO.setName(userEntity.getName());
			userDTO.setGender(userEntity.getGender());
			userDTO.setDateofbirth(userEntity.getDateofbirth());
			userDTO.setMobilenumber(userEntity.getMobilenumber());
			userDTO.setPassword(userEntity.getPassword());
			userDTO.setSpeciality(userEntity.getSpeciality());
			return userDTO;
		}
		
	}
	
	



