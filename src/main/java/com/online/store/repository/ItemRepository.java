package com.online.store.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.online.store.entity.Categories;
import com.online.store.entity.Item;
import com.online.store.entity.User;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	List<Item> findOneByCategory(Categories categories, Pageable pageable);

	List<Item> findAllByUsers(User user, Pageable pageable);

}
