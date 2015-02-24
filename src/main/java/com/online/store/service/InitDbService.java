package com.online.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.online.store.entity.Categories;
import com.online.store.entity.Item;
import com.online.store.entity.Role;
import com.online.store.entity.User;
import com.online.store.repository.CategoriesRepository;
import com.online.store.repository.ItemRepository;
import com.online.store.repository.RoleRepository;
import com.online.store.repository.UserRepository;

@Transactional
@Service
public class InitDbService {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private CategoriesRepository categoriesRepository;

	@PostConstruct
	public void init() {
		Role roleUser = new Role();
		roleUser.setName("ROLE_USER");
		roleRepository.save(roleUser);

		Role roleAdmin = new Role();
		roleAdmin.setName("ROLE_ADMIN");
		roleRepository.save(roleAdmin);

		User userAdmin = new User();
		userAdmin.setEnable(true);
		userAdmin.setName("admin");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		userAdmin.setPassword(encoder.encode("admin"));
		userAdmin.setEmail("example_admin@mail.com");
		userAdmin.setPhoneNumber("+380500383736");
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleAdmin);
		userAdmin.setRoles(roles);
		userRepository.save(userAdmin);

		User userUser = new User();
		userUser.setEnable(true);
		userUser.setName("user");
		BCryptPasswordEncoder encoder2 = new BCryptPasswordEncoder();
		userUser.setPassword(encoder2.encode("user"));
		userUser.setEmail("example_admin@mail.com");
		userUser.setPhoneNumber("+380500383736");
		List<Role> roles2 = new ArrayList<Role>();
		roles2.add(roleUser);
		userUser.setRoles(roles2);
		userRepository.save(userUser);

		Categories categories = new Categories();
		categories.setName("Magic");
		categoriesRepository.save(categories);

		Categories category2 = new Categories();
		category2.setName("Weapon");
		categoriesRepository.save(category2);

		Categories category3 = new Categories();
		category3.setName("Armor");
		categoriesRepository.save(category3);

		Categories category4 = new Categories();
		category4.setName("Gewel's");
		categoriesRepository.save(category4);

		Item item = new Item();
		item.setName("Teleport Scrol");
		item.setCategory(categories);
		item.setPrice(987.4);
		itemRepository.save(item);

		Item item2 = new Item();
		item2.setName("Health potion");
		item2.setCategory(categories);
		item2.setPrice(1560.0);
		itemRepository.save(item2);

		Item item3 = new Item();
		item3.setName("Sword");
		item3.setCategory(category2);
		item3.setPrice(454.9);
		itemRepository.save(item3);

		Item item4 = new Item();
		item4.setName("Shield");
		item4.setCategory(category3);
		item4.setPrice(1560.0);
		itemRepository.save(item4);

		Item item5 = new Item();
		item5.setName("Ring of Power");
		item5.setCategory(category4);
		item5.setPrice(987.4);
		itemRepository.save(item5);

		Item item6 = new Item();
		item6.setName("Platemale");
		item6.setCategory(category3);
		item6.setPrice(1560.0);
		itemRepository.save(item6);

		Item item7 = new Item();
		item7.setName("Helmet");
		item7.setCategory(category3);
		item7.setPrice(987.4);
		itemRepository.save(item7);

		Item item8 = new Item();
		item8.setName("Gloves");
		item8.setCategory(category3);
		item8.setPrice(1560.0);
		itemRepository.save(item8);

		Item item9 = new Item();
		item9.setName("Chain");
		item9.setCategory(category4);
		item9.setPrice(987.4);
		itemRepository.save(item9);

		Item item10 = new Item();
		item10.setName("Boots");
		item10.setCategory(category3);
		item10.setPrice(1560.0);
		itemRepository.save(item10);

		Item item11 = new Item();
		item11.setName("Bow");
		item11.setCategory(category2);
		item11.setPrice(987.4);
		itemRepository.save(item11);

		Item item12 = new Item();
		item12.setName("Arrows");
		item12.setCategory(category2);
		item12.setPrice(1560.0);
		itemRepository.save(item12);

	}
}
