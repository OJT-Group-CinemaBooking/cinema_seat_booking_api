package com.hostmdy.cinema.repository;

import org.springframework.data.repository.CrudRepository;

import com.hostmdy.cinema.domain.Cinema;
import com.hostmdy.cinema.domain.Theater;
import java.util.List;


public interface TheaterRepository extends CrudRepository<Theater,Long>{
	List<Theater> findByCinema(Cinema cinema);
}
