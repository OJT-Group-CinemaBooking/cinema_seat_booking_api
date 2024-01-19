package com.hostmdy.cinema.service;

import java.util.List;
import java.util.Optional;

import com.hostmdy.cinema.domain.Crew;

public interface CrewService {
	
	Crew saveCrew(Crew crew);
	
	Optional<Crew> getCrewById(Long crewId);
	
	List<Crew> getAllCrew();
	
	boolean deleteCrewById(Long crewId);

}
