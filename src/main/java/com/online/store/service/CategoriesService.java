package com.online.store.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.store.entity.Categories;
import com.online.store.pagingandsorting.SortingSetup;
import com.online.store.repository.CategoriesRepository;
import com.online.store.repository.ItemRepository;

@Service
@Transactional
public class CategoriesService {

	@Autowired
	private CategoriesRepository categoriesRepository;

	@Autowired
	private ItemRepository itemRepository;

	public List<Categories> findAll() {
		SortingSetup sortingSetup = new SortingSetup();
		return categoriesRepository.findAll(sortingSetup.sortByASC());
	}

	public void save(Categories categories) {
		categoriesRepository.save(categories);
	}

	public void delete(Categories categories) {
		categoriesRepository.delete(categories);
	}

	public Categories findOne(int id) {
		return categoriesRepository.findOne(id);
	}

}
