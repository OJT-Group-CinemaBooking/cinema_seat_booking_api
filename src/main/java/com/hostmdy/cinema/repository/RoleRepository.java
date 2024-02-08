package com.hostmdy.cinema.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Optional<Role> findByName(String name);

}
