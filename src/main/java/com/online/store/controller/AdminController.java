package com.online.store.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.online.store.entity.Categories;
import com.online.store.entity.Item;
import com.online.store.entity.User;
import com.online.store.service.CategoriesService;
import com.online.store.service.ItemService;
import com.online.store.service.UserService;

@Controller
public class AdminController {

	@Autowired
	private CategoriesService categoriesService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private UserService userService;

	@ModelAttribute("category")
	public Categories constructCategory() {
		return new Categories();
	}

	@ModelAttribute("item")
	public Item constructItem() {
		return new Item();
	}

	@RequestMapping("/adminitems")
	public String showAdminItems(Model model) {
		model.addAttribute("items", itemService.findAll());
		model.addAttribute("categories", categoriesService.findAll());
		return "adminitems";
	}

	@RequestMapping("/admincategories")
	public String showAdminCategories(Model model) {
		model.addAttribute("categories", categoriesService.findAll());
		return "admincategories";
	}

	@RequestMapping(value = "/admincategories", method = RequestMethod.POST)
	public String addNewCategory(Model model,
			@Valid @ModelAttribute("categories") Categories categories,
			BindingResult result) {
		if (result.hasErrors()) {
			return showAdminCategories(model);
		}
		categoriesService.save(categories);
		return "redirect:/admincategories.html";
	}

	@RequestMapping(value = "/category/remove/{id}")
	public String deleteCategory(@PathVariable int id) {
		Categories categories = categoriesService.findOne(id);
		categoriesService.delete(categories);
		return "redirect:/admincategories.html";

	}

	@RequestMapping(value = "/adminitems", method = RequestMethod.POST)
	public String addNewItem(Model model,
			@Valid @ModelAttribute("item") Item item, BindingResult result,
			@RequestParam(value = "choosencategory") int param) {
		if (result.hasErrors()) {
			return showAdminItems(model);
		}
		Categories category = categoriesService.findOne(param);
		item.setCategory(category);
		itemService.save(item);
		return "redirect:/adminitems.html";
	}

	@RequestMapping(value = "/item/remove/{id}")
	public String deleteItem(@PathVariable int id) {
		Item item = itemService.findOne(id);
		itemService.delete(item);
		return "redirect:/adminitems.html";
	}

	@RequestMapping(value = "/user/remove/{id}")
	public String deleteUser(@PathVariable int id) {
		User user = userService.findOneById(id);
		userService.delete(user);
		return "redirect:/users.html";
	}

}
