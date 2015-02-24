package com.online.store.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CATEGORIES")
public class Categories extends BaseEntity {

	@Size(min = 3, message = "Name must be more the 3 characters")
	@Column(name = "NAME")
	private String name;

	@OneToMany(mappedBy = "category")
	private List<Item> items;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

}
