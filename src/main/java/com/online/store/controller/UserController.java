package com.online.store.controller;

import java.security.Principal;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.online.store.entity.User;
import com.online.store.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@ModelAttribute("user")
	public User construct() {
		return new User();
	}

	@RequestMapping("/users")
	public String users(Model model) {
		model.addAttribute("users", userService.findAll());
		return "users";
	}

	@RequestMapping("/users/{id}")
	public String deatil(Model model, @PathVariable int id) {
		model.addAttribute("user", userService.findOneById(id));
		return "user-detail";
	}

	@RequestMapping("/register")
	public String registrationForm() {
		return "user-register";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String doRegistration(@Valid @ModelAttribute("user") User user,
			BindingResult result) {
		if (result.hasErrors()) {
			return "user-register";
		}
		userService.save(user);
		return "redirect:/register.html?success=true";
	}

	@RequestMapping("/account")
	public String account(Model model, Principal principal) {
		String name = principal.getName();
		model.addAttribute("user", userService.findOneByName(name));
		return "user-detail";
	}

	@RequestMapping("/available")
	@ResponseBody
	public String available(@RequestParam String username) {
		Boolean available = userService.findOneByName(username) == null;
		return available.toString();
	}

}
