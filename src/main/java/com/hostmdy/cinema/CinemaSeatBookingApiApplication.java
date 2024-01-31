package com.hostmdy.cinema;


import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hostmdy.cinema.domain.Cinema;
import com.hostmdy.cinema.domain.Crew;
import com.hostmdy.cinema.domain.Genere;
import com.hostmdy.cinema.domain.Movie;
import com.hostmdy.cinema.domain.MovieCrew;
import com.hostmdy.cinema.domain.MovieGenere;
import com.hostmdy.cinema.domain.SeatPattern;
import com.hostmdy.cinema.domain.SeatType;
import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.repository.CinemaRepository;
import com.hostmdy.cinema.repository.CrewRepository;
import com.hostmdy.cinema.repository.GenereRepository;
import com.hostmdy.cinema.repository.MovieCrewRepository;
import com.hostmdy.cinema.repository.MovieGenereRepository;
import com.hostmdy.cinema.repository.MovieRepository;
import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.domain.User;
import com.hostmdy.cinema.repository.SeatPatternRepository;
import com.hostmdy.cinema.repository.SeatRepository;
import com.hostmdy.cinema.repository.ShowTimeRepository;
import com.hostmdy.cinema.repository.TheaterRepository;
import com.hostmdy.cinema.service.SeatPatternService;
import com.hostmdy.cinema.service.ShowTimeService;
import com.hostmdy.cinema.repository.UserRepository;


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
	public CinemaRepository cinemaRepository;
	
	@Autowired
	public TheaterRepository theaterRepository;
	
	@Autowired
	public SeatPatternService seatPatternService;
	
	@Autowired
	public SeatRepository seatRepository;
	
	@Autowired
	public ShowTimeRepository showTimeRepository;
	
	@Autowired
	public ShowTimeService showTimeService;
  
  @Autowired
	public UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CinemaSeatBookingApiApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		// generes data
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
		
		// sample crews
		Crew koshibasaki = new Crew();
		koshibasaki.setName("KO SHIBASAKI");
		koshibasaki.setRole("Starring");
		crewRepository.save(koshibasaki);
		
		Crew hayao = new Crew();
		hayao.setName("HAYAO MIYAZAKI");
		hayao.setRole("Director");
		crewRepository.save(hayao);
		
		// sample movie
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
		
		
		
		Cinema mingalar = new Cinema();
		mingalar.setName("Mingalar");
		mingalar.setLocation("Mandalay");
		cinemaRepository.save(mingalar);
		
		Theater minTheater1 = new Theater();
		minTheater1.setName("MGR I");
		minTheater1.setScreen("HDR");
		minTheater1.setCinema(mingalar);
		theaterRepository.save(minTheater1);
		// seatPattern for mingalar->minTheater1
		SeatPattern minStandardSeatPattern = new SeatPattern();
		minStandardSeatPattern.setSeatPrice(5500);
		minStandardSeatPattern.setSeatType(SeatType.STANDARD);
		minStandardSeatPattern.setRowCount(4);
		minStandardSeatPattern.setColumnCount(20);
		minStandardSeatPattern.setRowsOrder(1);
		seatPatternService.createSeatPattern(minTheater1.getId(), minStandardSeatPattern);
		
		SeatPattern minPremiumSeatPattern = new SeatPattern();
		minPremiumSeatPattern.setSeatPrice(6000);
		minPremiumSeatPattern.setSeatType(SeatType.PREMIUM);
		minPremiumSeatPattern.setRowCount(5);
		minPremiumSeatPattern.setColumnCount(16);
		minPremiumSeatPattern.setRowsOrder(1);
		seatPatternService.createSeatPattern(minTheater1.getId(), minPremiumSeatPattern);
		// seatPattern for mingalar->minTheater1

		ShowTime time1 = new ShowTime();
		time1.setShowDate(LocalDate.of(2024, 1, 30));
		time1.setShowTime(LocalTime.of(8, 30));
		time1.setConnectMovie(1L);
		time1.setMovie(theBoyandTheHeron);
		time1.setTheater(minTheater1);
		showTimeService.createShowTime(time1, minTheater1.getId(), theBoyandTheHeron.getId());

		ShowTime time2 = new ShowTime();
		time2.setShowDate(LocalDate.of(2024, 1, 27));
		time2.setShowTime(LocalTime.of(11, 00));
		time2.setConnectMovie(1L);
		time2.setMovie(theBoyandTheHeron);
		time2.setTheater(minTheater1);
		showTimeService.createShowTime(time2, minTheater1.getId(), theBoyandTheHeron.getId());
	

		Theater minTheater2 = new Theater();
		minTheater2.setName("MGR I");
		minTheater2.setScreen("HDR");
		minTheater2.setCinema(mingalar);
		theaterRepository.save(minTheater2);
		// seatPattern for mingalar->minTheater1
		SeatPattern minStandardSeatPattern2 = new SeatPattern();
		minStandardSeatPattern2.setSeatPrice(5500);
		minStandardSeatPattern2.setSeatType(SeatType.STANDARD);
		minStandardSeatPattern2.setRowCount(4);
		minStandardSeatPattern2.setColumnCount(16);
		minStandardSeatPattern2.setRowsOrder(1);
		seatPatternService.createSeatPattern(minTheater2.getId(), minStandardSeatPattern2);
		
		SeatPattern minPremiumSeatPattern2 = new SeatPattern();
		minPremiumSeatPattern2.setSeatPrice(6000);
		minPremiumSeatPattern2.setSeatType(SeatType.PREMIUM);
		minPremiumSeatPattern2.setRowCount(4);
		minPremiumSeatPattern2.setColumnCount(10);
		minPremiumSeatPattern2.setRowsOrder(1);
		seatPatternService.createSeatPattern(minTheater2.getId(), minPremiumSeatPattern2);
		// seatPattern for mingalar->minTheater1

		ShowTime time3 = new ShowTime();
		time3.setConnectMovie(1L);
		time3.setShowDate(LocalDate.of(2024, 2, 28));
		time3.setShowTime(LocalTime.of(8, 30));
		time3.setMovie(theBoyandTheHeron);
		time3.setTheater(minTheater2);
		showTimeService.createShowTime(time3, minTheater2.getId(), theBoyandTheHeron.getId());

		ShowTime time4 = new ShowTime();
		time4.setConnectMovie(1L);
		time4.setShowDate(LocalDate.of(2024, 1, 31));
		time4.setShowTime(LocalTime.of(10, 00));
		time4.setMovie(theBoyandTheHeron);
		time4.setTheater(minTheater2);
		showTimeService.createShowTime(time4, minTheater2.getId(), theBoyandTheHeron.getId());

		User user1 = new User();
		user1.setFirstname("Mg");
		user1.setLastname("Mg");
		user1.setUsername("mm001");
		user1.setEmail("mm@gmail.com");
		user1.setPassword("1234");
		user1.setRole("user");
		
		userRepository.save(user1);
	}

}
