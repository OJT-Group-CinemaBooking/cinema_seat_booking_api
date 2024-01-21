package com.hostmdy.cinema;


import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hostmdy.cinema.domain.Crew;
import com.hostmdy.cinema.domain.Genere;
import com.hostmdy.cinema.domain.Movie;
import com.hostmdy.cinema.domain.MovieCrew;
import com.hostmdy.cinema.domain.MovieGenere;
import com.hostmdy.cinema.repository.CrewRepository;
import com.hostmdy.cinema.repository.GenereRepository;
import com.hostmdy.cinema.repository.MovieCrewRepository;
import com.hostmdy.cinema.repository.MovieGenereRepository;
import com.hostmdy.cinema.repository.MovieRepository;

import com.hostmdy.cinema.domain.Seat;
import com.hostmdy.cinema.domain.SeatType;
import com.hostmdy.cinema.repository.SeatPatternRepository;
import com.hostmdy.cinema.repository.SeatRepository;
import com.hostmdy.cinema.repository.TheaterRepository;


@SpringBootApplication
public class CinemaSeatBookingApiApplication implements CommandLineRunner{
	
	@Autowired
	public MovieRepository movieRepository;
	
	@Autowired
	public GenereRepository genereRepository;
	
	@Autowired
	public CrewRepository crewRepository;
	
	@Autowired
	public MovieCrewRepository movieCrewRepository;
	
	@Autowired
	public MovieGenereRepository movieGenereRepository;
	
	@Autowired
	public TheaterRepository theaterRepository;
	
	@Autowired
	public SeatPatternRepository seatPatternRepository;
	
	@Autowired
	public SeatRepository seatRepository;

	public static void main(String[] args) {
		SpringApplication.run(CinemaSeatBookingApiApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Genere action = new Genere();
		action.setName("Action");
		genereRepository.save(action);
		
		Genere adventure = new Genere();
		adventure.setName("Adventure");
		genereRepository.save(adventure);
		
		Genere animation = new Genere();
		animation.setName("Animation");
		genereRepository.save(animation);
		
		Genere biography = new Genere();
		biography.setName("Biography");
		genereRepository.save(biography);
		
		Genere comedy = new Genere();
		comedy.setName("Comedy");
		genereRepository.save(comedy);
		
		Genere crime = new Genere();
		crime.setName("Crime");
		genereRepository.save(crime);
		
		Genere comingOfAge = new Genere();
		comingOfAge.setName("Coming of Age");
		genereRepository.save(comingOfAge);
		
		Genere documentary = new Genere();
		documentary.setName("Documentary");
		genereRepository.save(documentary);
		
		Genere drama = new Genere();
		drama.setName("Drama");
		genereRepository.save(drama);
		
		Genere espionage = new Genere();
		espionage.setName("Espionage");
		genereRepository.save(espionage);
		
		Genere family = new Genere();
		family.setName("Family");
		genereRepository.save(family);
		
		Genere fantasy = new Genere();
		fantasy.setName("Fantasy");
		genereRepository.save(fantasy);
		
		Genere filmNoir = new Genere();
		filmNoir.setName("Film Noir");
		genereRepository.save(filmNoir);
		
		Genere history = new Genere();
		history.setName("History");
		genereRepository.save(history);
		
		Genere horror = new Genere();
		horror.setName("Horror");
		genereRepository.save(horror);
		
		Genere music = new Genere();
		music.setName("Music");
		genereRepository.save(music);
		
		Genere musical = new Genere();
		musical.setName("Musical");
		genereRepository.save(musical);
		
		Genere mystery = new Genere();
		mystery.setName("Mystery");
		genereRepository.save(mystery);
		
		Genere mockumentary = new Genere();
		mockumentary.setName("Mockumentary");
		genereRepository.save(mockumentary);
		
		Genere parody = new Genere();
		parody.setName("Parody");
		genereRepository.save(parody);
		
		Genere periodDrama = new Genere();
		periodDrama.setName("Period Drama");
		genereRepository.save(periodDrama);
		
		Genere psychologicalThriller = new Genere();
		psychologicalThriller.setName("Psychological Thriller");
		genereRepository.save(psychologicalThriller);
		
		Genere romance = new Genere();
		romance.setName("Romance");
		genereRepository.save(romance);
		
		Genere sport = new Genere();
		sport.setName("Sport");
		genereRepository.save(sport);
		
		Genere superhero = new Genere();
		superhero.setName("Superhero");
		genereRepository.save(superhero);
		
		Genere supernatural = new Genere();
		supernatural.setName("Supernatural");
		genereRepository.save(supernatural);
		
		Genere scienceFiction = new Genere();
		scienceFiction.setName("Science Fiction");
		genereRepository.save(scienceFiction);
		
		Genere satire = new Genere();
		satire.setName("Satire");
		genereRepository.save(satire);
		
		Genere silentFilm = new Genere();
		silentFilm.setName("Silent Film");
		genereRepository.save(silentFilm);
		
		Genere surreal = new Genere();
		surreal.setName("Surreal");
		genereRepository.save(surreal);
		
		Genere thriller = new Genere();
		thriller.setName("Thriller");
		genereRepository.save(thriller);
		
		Genere teen = new Genere();
		teen.setName("Teen");
		genereRepository.save(teen);
		
		Genere trueCrime = new Genere();
		trueCrime.setName("True Crime");
		genereRepository.save(trueCrime);
		
		Genere technoThriller = new Genere();
		technoThriller.setName("Techno Thriller");
		genereRepository.save(technoThriller);
		
		Genere tragedy = new Genere();
		tragedy.setName("Tragedy");
		genereRepository.save(tragedy);
		
		Genere urban = new Genere();
		urban.setName("Urban");
		genereRepository.save(urban);
		
		Genere war = new Genere();
		war.setName("War");
		genereRepository.save(war);
		
		Genere western = new Genere();
		western.setName("Western");
		genereRepository.save(western);
		
		Genere zombie = new Genere();
		zombie.setName("Zombie");
		genereRepository.save(zombie);
		
		Crew koshibasaki = new Crew();
		koshibasaki.setName("KO SHIBASAKI");
		koshibasaki.setRole("Starring");
		crewRepository.save(koshibasaki);
		
		Crew hayao = new Crew();
		hayao.setName("HAYAO MIYAZAKI");
		hayao.setRole("Director");
		crewRepository.save(hayao);
		
		Movie theBoyandTheHeron = new Movie();
		theBoyandTheHeron.setTitle("The Boy And The Heron");
		theBoyandTheHeron.setReleaseDate(LocalDate.of(2023, 07, 14));
		theBoyandTheHeron.setDuration(140);
		theBoyandTheHeron.setRating(5.4);
		theBoyandTheHeron.setCountry("Japan");
		theBoyandTheHeron.setLanguage("English");
		theBoyandTheHeron.setNowShowing(true);
		theBoyandTheHeron.setComingSoon(false);
		theBoyandTheHeron.setPopularNow(false);
		theBoyandTheHeron.setShowing(true);
		theBoyandTheHeron.setTrailer("just sample link...");
		theBoyandTheHeron.setSynopsis("Mahito, a young 12-year-old boy, struggles to settle in a new town after his mother's death. However, when a talking heron informs Mahito that his mother is still alive, he enters an abandoned tower in search of her, which takes him to another world.");
		movieRepository.save(theBoyandTheHeron);
		
		MovieGenere theBoyMovieGenere1 = new MovieGenere();
		theBoyMovieGenere1.setGenere(fantasy);
		theBoyMovieGenere1.setMovie(theBoyandTheHeron);
		movieGenereRepository.save(theBoyMovieGenere1);
		
		MovieGenere theBoyMovieGenere2 = new MovieGenere();
		theBoyMovieGenere2.setGenere(adventure);
		theBoyMovieGenere2.setMovie(theBoyandTheHeron);
		movieGenereRepository.save(theBoyMovieGenere2);
		
		MovieCrew theBoyMovieCrew1 = new MovieCrew();
		theBoyMovieCrew1.setCrew(hayao);
		theBoyMovieCrew1.setMovie(theBoyandTheHeron);
		movieCrewRepository.save(theBoyMovieCrew1);
		
		MovieCrew theBoyMovieCrew2 = new MovieCrew();
		theBoyMovieCrew2.setCrew(koshibasaki);
		theBoyMovieCrew2.setMovie(theBoyandTheHeron);
		movieCrewRepository.save(theBoyMovieCrew2);
		
		
		Seat seat1 = new Seat();
		seat1.setType(SeatType.NORMAL);
		seat1.setPrice(8000);
		
		seatRepository.save(seat1);
		
		Seat seat2 = new Seat();
		seat2.setType(SeatType.PREMIUM);
		seat2.setPrice(12000);
		
		seatRepository.save(seat2);
	}

}
