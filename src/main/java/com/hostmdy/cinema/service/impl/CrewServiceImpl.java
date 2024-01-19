package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.Crew;
import com.hostmdy.cinema.domain.MovieCrew;
import com.hostmdy.cinema.repository.CrewRepository;
import com.hostmdy.cinema.repository.MovieCrewRepository;
import com.hostmdy.cinema.service.CrewService;
import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CrewServiceImpl implements CrewService{
	
	private final CrewRepository crewRepository;
	private final MovieCrewRepository movieCrewRepository;

	@Override
	public Crew saveCrew(Crew crew) {
		// TODO Auto-generated method stub
		return crewRepository.save(crew);
	}

	@Override
	public Optional<Crew> getCrewById(Long crewId) {
		// TODO Auto-generated method stub
		return crewRepository.findById(crewId);
	}

	@Override
	public List<Crew> getAllCrew() {
		// TODO Auto-generated method stub
		return (List<Crew>) crewRepository.findAll();
	}

	@Override
	public boolean deleteCrewById(Long crewId) {
		// TODO Auto-generated method stub
		if(getCrewById(crewId).isEmpty()) {
			return false;
		}
		List<MovieCrew> movieCrewList = movieCrewRepository.findByCrew(getCrewById(crewId).get());
		movieCrewRepository.deleteAll(movieCrewList);
		crewRepository.deleteById(crewId);
		return true;
	}

}
