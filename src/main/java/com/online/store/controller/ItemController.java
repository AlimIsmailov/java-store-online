package com.online.store.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.store.entity.Item;
import com.online.store.service.CategoriesService;
import com.online.store.service.ItemService;

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Autowired
	private CategoriesService categoriesService;

	@RequestMapping(value = "/{id}")
	public String showItemProfile(Model model, @PathVariable int id,
			@ModelAttribute("") Item item) throws SQLException {
		model.addAttribute("categories", categoriesService.findAll());
		model.addAttribute("item", itemService.findOne(id));
		return "itemprofile";
	}

}
