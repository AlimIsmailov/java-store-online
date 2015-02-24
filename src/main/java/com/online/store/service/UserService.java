package com.online.store.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.online.store.entity.Role;
import com.online.store.entity.User;
import com.online.store.repository.RoleRepository;
import com.online.store.repository.UserRepository;

@Service
@Transactional
public class UserService {

	private static final String ROLE_DY_DEFAULT = "ROLE_USER";

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOneById(int id) {
		return userRepository.findOne(id);
	}

	public void save(User user) {
		user.setEnable(true);
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		List<Role> roles = new ArrayList<Role>();
		roles.add(roleRepository.findByName(ROLE_DY_DEFAULT));
		user.setRoles(roles);
		userRepository.save(user);
	}

	public User findOneByName(String name) {
		User user = userRepository.findByName(name);
		return findOneById(user.getId());
	}

	public void delete(User user) {
		userRepository.delete(user);
	}

}
