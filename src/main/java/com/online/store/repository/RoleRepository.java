package com.online.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.online.store.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

	Role findByName(String name);

}
