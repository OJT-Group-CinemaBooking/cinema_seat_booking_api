package com.hostmdy.cinema.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.Genere;


public interface GenereRepository extends CrudRepository<Genere, Integer>{
	
	Optional<Genere> findByName(String name);

}
