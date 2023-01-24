package com.carelifecoach.response;

import com.carelifecoach.entity.User;

public class UserResponse {
	private Long id;
	private String name;
	private String password;
	private String dateofbirth;
	private String gender;
	private String mobilenumber;
	private String speciality;
	public UserResponse(User user) {
		
		this.id = user.getId();
		this.name = user.getName();
		this.password = user.getPassword();
		this.dateofbirth = user.getDateofbirth();
		this.gender = user.getGender();
		this.mobilenumber = user.getMobilenumber();
		this.speciality = user.getSpeciality();
	}
	

     public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDateofbirth() {
		return dateofbirth;
	}
	public void setDateofbirth(String dateofbirth) {
		this.dateofbirth = dateofbirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getMobilenumber() {
		return mobilenumber;
	}
	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
