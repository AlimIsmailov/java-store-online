package com.online.store.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ITEM")
public class Item extends BaseEntity {

	@Size(min = 3, message = "Name must be more the 3 characters")
	@Column(name = "NAME")
	private String name;

	@Lob
	@Column(name = "IMAGE")
	@Basic(fetch = FetchType.LAZY)
	private byte[] image;

	@Column(name = "PRICE")
	private double price;

	@ManyToMany(mappedBy = "items")
	private List<User> users;

	@ManyToOne
	@JoinColumn(name = "CATEGORIES_ID")
	private Categories category;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public Categories getCategory() {
		return category;
	}

	public void setCategory(Categories category) {
		this.category = category;
	}

}
