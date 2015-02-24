package com.online.store.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name = "USER")
public class User extends BaseEntity {

	@Size(min = 3, message = "Name must be more the 3 characters")
	@Column(name = "NAME")
	private String name;

	@Size(min = 5, message = "Name must be more the 5 characters")
	@Column(name = "PASSWORD")
	private String password;

	@Email(message = "Email must be example@mail.com")
	@Size(min = 1, message = "Email must be example@mail.com")
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ENABLE")
	private boolean enable;

	@ManyToMany
	@JoinTable
	private List<Role> roles;

	@Size(min = 10, max = 17, message = "Number must be +38(xxx)xxx-xx-xx or xxxxxxxxxx")
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;

	@ManyToMany()
	@JoinTable
	private List<Item> items;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
