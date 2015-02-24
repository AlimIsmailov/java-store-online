package com.online.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.store.entity.Categories;

public interface CategoriesRepository extends
		JpaRepository<Categories, Integer> {

}
