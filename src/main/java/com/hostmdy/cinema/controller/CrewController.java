package com.hostmdy.cinema.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.domain.Crew;
import com.hostmdy.cinema.service.CrewService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/crew")
@CrossOrigin("http://localhost:3000")
public class CrewController {
	
	private final CrewService crewService;
	
	@GetMapping("/all")
	public ResponseEntity<List<Crew>> getAllCrews() {
		return ResponseEntity.ok(crewService.getAllCrew());
	}
	
	@PostMapping("/create")
	public ResponseEntity<Crew> createNewCrew(@RequestBody Crew crew) {
		return ResponseEntity.ok(crewService.saveCrew(crew));
	}
	
	@PutMapping("/update")
	public ResponseEntity<Crew> updateCrew(@RequestBody Crew crew){
		Optional<Crew> crewOptional = crewService.getCrewById(crew.getId());
		if(crewOptional.isEmpty()) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(crewService.saveCrew(crew));
	}
	
	@DeleteMapping("/{crewId}/delete")
	public ResponseEntity<Long> deleteCrew(@PathVariable Long crewId){
		Boolean success = crewService.deleteCrewById(crewId);
		if(!success) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(crewId);
	}

}
