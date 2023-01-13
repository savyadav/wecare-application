package com.ltimindtree.reactmicrservice.entity;
import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.ltimindtree.reactmicrservice.dto.UserDTO;
@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	private String name;
	private String username;
	private String email;
	private String address;
	private Integer phone;
	private String website;
	private String company;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(address, company, email, name, phone, userId, username, website);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(address, other.address) && Objects.equals(company, other.company)
				&& Objects.equals(email, other.email) && Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone) && Objects.equals(userId, other.userId)
				&& Objects.equals(username, other.username) && Objects.equals(website, other.website);
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", username=" + username + ", email=" + email
				+ ", address=" + address + ", phone=" + phone + ", website=" + website + ", company=" + company + "]";
	}
	
}
