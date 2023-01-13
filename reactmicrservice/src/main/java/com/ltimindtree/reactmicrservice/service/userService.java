package com.ltimindtree.reactmicrservice.service;

import com.ltimindtree.reactmicrservice.dto.UserDTO;

import antlr.collections.List;

public interface userService {
	
	

	public java.util.List<UserDTO> getAllUsers();

	
	public UserDTO getUser(Integer userId) throws Exception ;


	public void updateUser(Integer userId, UserDTO user) throws Exception;


	public void deleteUser(Integer userId) throws Exception;


	public Integer addUser(UserDTO user);
}
