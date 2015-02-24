package com.online.store.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.online.store.entity.Categories;
import com.online.store.entity.Item;
import com.online.store.entity.User;
import com.online.store.pagingandsorting.SortingSetup;
import com.online.store.repository.CategoriesRepository;
import com.online.store.repository.ItemRepository;

@Service
@Transactional
public class ItemService {

	private static EntityManager entityManager;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Autowired
	private CategoriesService categoriesService;

	public List<Item> findAll() {
		SortingSetup sortingSetup = new SortingSetup();
		return itemRepository.findAll(sortingSetup.sortByASC());
	}

	public void save(Item item) {
		itemRepository.save(item);
	}

	public Item findOne(int id) {
		return itemRepository.findOne(id);
	}

	public void delete(Item item) {
		itemRepository.delete(item);
	}

	public void update(Item item) {
		itemRepository.saveAndFlush(item);
	}

	public List<Item> findOneWithItems(int id) {
		Categories categories = categoriesService.findOne(id);
		List<Item> items = itemRepository.findOneByCategory(categories,
				new PageRequest(0, 10, Direction.ASC, "name"));
		return items;
	}

	public List<Item> findAll(User user) {
		return itemRepository.findAllByUsers(user, new PageRequest(0, 10,
				Direction.ASC, "name"));
	}

	public byte[] loadImage(int itemId) {
		return entityManager.find(Item.class, itemId).getImage();
	}

}
