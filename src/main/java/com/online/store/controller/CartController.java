package com.online.store.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.online.store.entity.Item;
import com.online.store.entity.User;
import com.online.store.repository.UserRepository;
import com.online.store.service.ItemService;
import com.online.store.service.UserService;

@Controller
public class CartController {

	@Autowired
	private UserService userService;

	@Autowired
	private ItemService itemService;

	@Autowired
	private UserRepository userRepository;

	@ModelAttribute("cart")
	public User constructCart() {
		return new User();
	}

	@RequestMapping("cart")
	public String showCart(Model model, Principal principal) {
		User user = userService.findOneByName(principal.getName());
		List<Item> items = itemService.findAll(user);
		model.addAttribute("cart", items);
		return "cart";
	}

	private List<Item> items = new ArrayList<Item>();

	@Transactional
	@RequestMapping("/addtocart/{id}")
	public String addItemToCart(@PathVariable int id, Principal principal) {
		User user = userService.findOneByName(principal.getName());
		items.add(itemService.findOne(id));
		user.setItems(items);
		userRepository.save(user);
		return "redirect:/adminitems.html";
	}

	@Transactional
	@RequestMapping("/removefromcart")
	public String removeItemFromCart(Principal principal) {
		User user = userService.findOneByName(principal.getName());
		items.clear();
		user.setItems(items);
		userRepository.save(user);
		return "redirect:/cart.html";
	}

	/*
	 * Here I get one problem, thats why purchase submit is not working correct.
	 */

	@RequestMapping("/acceptpurchase")
	public String acceptPurchase(Principal principal) {
		User user = userService.findOneByName(principal.getName());
		items.clear();
		user.setItems(items);
		userRepository.save(user);
		return "redirect:/cart.html?success=true";
	}
}
