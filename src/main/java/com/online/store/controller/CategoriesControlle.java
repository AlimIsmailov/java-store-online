package com.online.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.store.entity.Categories;
import com.online.store.service.CategoriesService;
import com.online.store.service.ItemService;

@Controller
public class CategoriesControlle {

	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private ItemService itemService;

	@ModelAttribute("categorywithitems")
	public Categories constructCategory() {
		return new Categories();
	}

	@RequestMapping(value = "/category/{id}")
	public String showCategory(@PathVariable int id, Model model) {
		model.addAttribute("categories", categoriesService.findAll());
		model.addAttribute("categorywithitems",
				itemService.findOneWithItems(id));
		return "categoryprofile";
	}

}
