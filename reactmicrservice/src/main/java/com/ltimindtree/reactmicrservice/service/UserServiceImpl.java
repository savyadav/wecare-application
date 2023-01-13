package com.ltimindtree.reactmicrservice.service;
import java.util.ArrayList;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.ltimindtree.reactmicrservice.dto.UserDTO;
import com.ltimindtree.reactmicrservice.entity.User;
import com.ltimindtree.reactmicrservice.repository.UserRepository;

@Service(value = "userService")
@Transactional
public class UserServiceImpl implements userService{
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<UserDTO> getAllUsers()  {
		Iterable<User> users = userRepository.findAll();
		List<UserDTO> users2 = new ArrayList<>();
		users.forEach(user -> {
			UserDTO usr = new UserDTO();
			usr.setUserId(user.getUserId());
			usr.setName(user.getName());
			usr.setUsername(user.getUsername());
			usr.setEmail(user.getEmail());
			usr.setPhone(user.getPhone());
			usr.setAddress(user.getAddress());
			usr.setCompany(user.getCompany());
			usr.setWebsite(user.getWebsite());
		   
			users2.add(usr);
		});
	
		return users2;
	}
	
	@Override
	public UserDTO getUser(Integer userId) throws Exception  {
		Optional<User> optional = userRepository.findById(userId);
		User user = optional.orElseThrow(() -> new Exception("Service.CUSTOMER_NOT_FOUND"));
		UserDTO usr = new UserDTO();
		usr.setUserId(user.getUserId());
		usr.setName(user.getName());
		usr.setUsername(user.getUsername());
		usr.setEmail(user.getEmail());
		usr.setPhone(user.getPhone());
		usr.setAddress(user.getAddress());
		usr.setCompany(user.getCompany());
		usr.setWebsite(user.getWebsite());
	   return usr;
	}

	@Override
	public void updateUser(Integer userId, UserDTO user) throws Exception {
		
			Optional<User> user1 = userRepository.findById(userId);
			User c = user1.orElseThrow(() -> new Exception("Service.CUSTOMER_NOT_FOUND"));
			c.setEmail(user.getEmail());
			c.setName(user.getName());
			c.setUsername(user.getUsername());
			c.setPhone(user.getPhone());
			c.setCompany(user.getCompany());
		}

	@Override
	public void deleteUser(Integer userId) throws Exception {
		Optional<User> user = userRepository.findById(userId);
		user.orElseThrow(() -> new Exception("Service.CUSTOMER_NOT_FOUND"));
		userRepository.deleteById(userId);
	}

	@Override
	public Integer addUser(UserDTO user) {
		User userEntity = new User();
		userEntity.setName(user.getName());
		userEntity.setUsername(user.getUsername());
		userEntity.setEmail(user.getEmail());
		userEntity.setAddress(user.getAddress());
		userEntity.setCompany(user.getCompany());
		userEntity.setPhone(user.getPhone());
		userEntity.setWebsite(user.getWebsite());
		
		
		return userEntity.getUserId();
	}
		
	}
		
	



