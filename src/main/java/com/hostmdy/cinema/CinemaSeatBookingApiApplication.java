package com.hostmdy.cinema;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hostmdy.cinema.domain.Cinema;
import com.hostmdy.cinema.domain.Coupon;
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
import com.hostmdy.cinema.repository.RoleRepository;
import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.domain.security.Role;
import com.hostmdy.cinema.repository.SeatRepository;
import com.hostmdy.cinema.repository.ShowTimeRepository;
import com.hostmdy.cinema.repository.TheaterRepository;
import com.hostmdy.cinema.service.MovieService;
import com.hostmdy.cinema.service.CouponService;
import com.hostmdy.cinema.service.SeatPatternService;
import com.hostmdy.cinema.service.ShowTimeService;
import com.hostmdy.cinema.service.UserService;

import lombok.extern.slf4j.Slf4j;

import com.hostmdy.cinema.repository.UserRepository;


@SpringBootApplication
@Slf4j
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
	
	@Autowired
	public UserService userService;
  
	@Autowired
  	public MovieService movieService;
	
	@Autowired
	public CouponService couponService;

	@Autowired
	public RoleRepository roleRepository;

	public static void main(String[] args) {
		SpringApplication.run(CinemaSeatBookingApiApplication.class, args);
	}
	

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Optional<Role> roleUser = roleRepository.findByName("ROLE_USER");
//		
//		if(roleUser.isEmpty()) {
//			Role role = new Role();
//			role.setId(1);
//			role.setName("ROLE_USER");
//			role = roleRepository.save(role);
//			log.info("role: {} is created",role.getName());
//		}
//		
//		Optional<Role> roleAdmin = roleRepository.findByName("ROLE_ADMIN");
//		
//		if(roleAdmin.isEmpty()) {
//			Role role = new Role();
//			role.setId(2);
//			role.setName("ROLE_ADMIN");
//			role = roleRepository.save(role);
//			log.info("role: {} is created",role.getName());
//		}
//		
//		// generes data
//		Genere action = new Genere();
//		action.setName("Action");
//		genereRepository.save(action);
//		
//		Genere adventure = new Genere();
//		adventure.setName("Adventure");
//		genereRepository.save(adventure);
//		
//		Genere animation = new Genere();
//		animation.setName("Animation");
//		genereRepository.save(animation);
//		
//		Genere biography = new Genere();
//		biography.setName("Biography");
//		genereRepository.save(biography);
//		
//		Genere comedy = new Genere();
//		comedy.setName("Comedy");
//		genereRepository.save(comedy);
//		
//		Genere crime = new Genere();
//		crime.setName("Crime");
//		genereRepository.save(crime);
//		
//		Genere comingOfAge = new Genere();
//		comingOfAge.setName("Coming of Age");
//		genereRepository.save(comingOfAge);
//		
//		Genere documentary = new Genere();
//		documentary.setName("Documentary");
//		genereRepository.save(documentary);
//		
//		Genere drama = new Genere();
//		drama.setName("Drama");
//		genereRepository.save(drama);
//		
//		Genere espionage = new Genere();
//		espionage.setName("Espionage");
//		genereRepository.save(espionage);
//		
//		Genere family = new Genere();
//		family.setName("Family");
//		genereRepository.save(family);
//		
//		Genere fantasy = new Genere();
//		fantasy.setName("Fantasy");
//		genereRepository.save(fantasy);
//		
//		Genere filmNoir = new Genere();
//		filmNoir.setName("Film Noir");
//		genereRepository.save(filmNoir);
//		
//		Genere history = new Genere();
//		history.setName("History");
//		genereRepository.save(history);
//		
//		Genere horror = new Genere();
//		horror.setName("Horror");
//		genereRepository.save(horror);
//		
//		Genere music = new Genere();
//		music.setName("Music");
//		genereRepository.save(music);
//		
//		Genere musical = new Genere();
//		musical.setName("Musical");
//		genereRepository.save(musical);
//		
//		Genere mystery = new Genere();
//		mystery.setName("Mystery");
//		genereRepository.save(mystery);
//		
//		Genere mockumentary = new Genere();
//		mockumentary.setName("Mockumentary");
//		genereRepository.save(mockumentary);
//		
//		Genere parody = new Genere();
//		parody.setName("Parody");
//		genereRepository.save(parody);
//		
//		Genere periodDrama = new Genere();
//		periodDrama.setName("Period Drama");
//		genereRepository.save(periodDrama);
//		
//		Genere psychologicalThriller = new Genere();
//		psychologicalThriller.setName("Psychological Thriller");
//		genereRepository.save(psychologicalThriller);
//		
//		Genere romance = new Genere();
//		romance.setName("Romance");
//		genereRepository.save(romance);
//		
//		Genere sport = new Genere();
//		sport.setName("Sport");
//		genereRepository.save(sport);
//		
//		Genere superhero = new Genere();
//		superhero.setName("Superhero");
//		genereRepository.save(superhero);
//		
//		Genere supernatural = new Genere();
//		supernatural.setName("Supernatural");
//		genereRepository.save(supernatural);
//		
//		Genere scienceFiction = new Genere();
//		scienceFiction.setName("Science Fiction");
//		genereRepository.save(scienceFiction);
//		
//		Genere satire = new Genere();
//		satire.setName("Satire");
//		genereRepository.save(satire);
//		
//		Genere silentFilm = new Genere();
//		silentFilm.setName("Silent Film");
//		genereRepository.save(silentFilm);
//		
//		Genere surreal = new Genere();
//		surreal.setName("Surreal");
//		genereRepository.save(surreal);
//		
//		Genere thriller = new Genere();
//		thriller.setName("Thriller");
//		genereRepository.save(thriller);
//		
//		Genere teen = new Genere();
//		teen.setName("Teen");
//		genereRepository.save(teen);
//		
//		Genere trueCrime = new Genere();
//		trueCrime.setName("True Crime");
//		genereRepository.save(trueCrime);
//		
//		Genere technoThriller = new Genere();
//		technoThriller.setName("Techno Thriller");
//		genereRepository.save(technoThriller);
//		
//		Genere tragedy = new Genere();
//		tragedy.setName("Tragedy");
//		genereRepository.save(tragedy);
//		
//		Genere urban = new Genere();
//		urban.setName("Urban");
//		genereRepository.save(urban);
//		
//		Genere war = new Genere();
//		war.setName("War");
//		genereRepository.save(war);
//		
//		Genere western = new Genere();
//		western.setName("Western");
//		genereRepository.save(western);
//		
//		Genere zombie = new Genere();
//		zombie.setName("Zombie");
//		genereRepository.save(zombie);
//		
//		// sample crews
//		Crew koshibasaki = new Crew();
//		koshibasaki.setName("KO SHIBASAKI");
//		koshibasaki.setRole("Starring");
//		crewRepository.save(koshibasaki);
//		
//		Crew hayao = new Crew();
//		hayao.setName("HAYAO MIYAZAKI");
//		hayao.setRole("Director");
//		crewRepository.save(hayao);
//		
//		// sample movie
//		Movie theBoyandTheHeron = new Movie();
//		theBoyandTheHeron.setTitle("The Boy And The Heron");
//		theBoyandTheHeron.setReleaseDate(LocalDate.of(2023, 07, 14));
//		theBoyandTheHeron.setDuration(140);
//		theBoyandTheHeron.setRating(5.4);
//		theBoyandTheHeron.setCountry("Japan");
//		theBoyandTheHeron.setLanguage("English");
//		theBoyandTheHeron.setNowShowing(true);
//		theBoyandTheHeron.setComingSoon(false);
//		theBoyandTheHeron.setPopularNow(false);
//		theBoyandTheHeron.setShowing(true);
//		theBoyandTheHeron.setTrailer("<iframe width=\"901\" height=\"487\" src=\"https://www.youtube.com/embed/f7EDFdA10pg\" title=\"THE BOY AND THE HERON | Official Teaser Trailer\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
//		theBoyandTheHeron.setSynopsis("Mahito, a young 12-year-old boy, struggles to settle in a new town after his mother's death. However, when a talking heron informs Mahito that his mother is still alive, he enters an abandoned tower in search of her, which takes him to another world.");
//		movieRepository.save(theBoyandTheHeron);
//		
//		MovieGenere theBoyMovieGenere1 = new MovieGenere();
//		theBoyMovieGenere1.setGenere(fantasy);
//		theBoyMovieGenere1.setMovie(theBoyandTheHeron);
//		movieGenereRepository.save(theBoyMovieGenere1);
//		
//		MovieGenere theBoyMovieGenere2 = new MovieGenere();
//		theBoyMovieGenere2.setGenere(adventure);
//		theBoyMovieGenere2.setMovie(theBoyandTheHeron);
//		movieGenereRepository.save(theBoyMovieGenere2);
//		
//		MovieCrew theBoyMovieCrew1 = new MovieCrew();
//		theBoyMovieCrew1.setCrew(hayao);
//		theBoyMovieCrew1.setMovie(theBoyandTheHeron);
//		movieCrewRepository.save(theBoyMovieCrew1);
//		
//		MovieCrew theBoyMovieCrew2 = new MovieCrew();
//		theBoyMovieCrew2.setCrew(koshibasaki);
//		theBoyMovieCrew2.setMovie(theBoyandTheHeron);
//		movieCrewRepository.save(theBoyMovieCrew2);
//		
//		// for movie id 2
//		Crew jasonStatham = new Crew();
//		jasonStatham.setName("Jason Statham ");
//		jasonStatham.setRole("Starring");
//		crewRepository.save(jasonStatham);
//		
//		Crew emmyRaverLampman = new Crew();
//		emmyRaverLampman.setName("Emmy Raver-Lampman");
//		emmyRaverLampman.setRole("Starring");
//		crewRepository.save(emmyRaverLampman);
//		
//		Crew bobbyNaderi = new Crew();
//		bobbyNaderi.setName("Bobby Naderi");
//		bobbyNaderi.setRole("Starring");
//		crewRepository.save(bobbyNaderi);
//		
//		Crew jeremyIrons = new Crew();
//		jeremyIrons.setName("Jeremy Irons");
//		jeremyIrons.setRole("Starring");
//		crewRepository.save(jeremyIrons);
//		
//		Crew joshHutcherson = new Crew();
//		joshHutcherson.setName("Josh Hutcherson");
//		joshHutcherson.setRole("Starring");
//		crewRepository.save(joshHutcherson);
//		
//		Crew davidAyer = new Crew();
//		davidAyer.setName("David Ayer");
//		davidAyer.setRole("Director");
//		crewRepository.save(davidAyer);
//		
//		Movie theBeekeeper = new Movie();
//		theBeekeeper.setTitle("The Beekeeper");
//		theBeekeeper.setReleaseDate(LocalDate.of(2024, 01, 12));
//		theBeekeeper.setDuration(105);
//		theBeekeeper.setRating(6.6);
//		theBeekeeper.setCountry("United States");
//		theBeekeeper.setLanguage("English");
//		theBeekeeper.setNowShowing(true);
//		theBeekeeper.setComingSoon(false);
//		theBeekeeper.setPopularNow(true);
//		theBeekeeper.setShowing(true);
//		theBeekeeper.setTrailer("<iframe width=\"866\" height=\"487\" src=\"https://www.youtube.com/embed/SzINZZ6iqxY\" title=\"THE BEEKEEPER | Official Restricted Trailer\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
//		theBeekeeper.setSynopsis("One man's brutal campaign for vengeance takes on national stakes after he is revealed to be a former operative of a powerful and clandestine organization known as \"Beekeepers\".");
//		movieRepository.save(theBeekeeper);
//		
//		
//		List<Genere> generes = new ArrayList<>();
//		generes.add(action);
//		generes.add(thriller);
//		movieService.addGenere(2l, generes);
//		
//		List<Crew> crews = new ArrayList<>();
//		crews.add(jasonStatham);
//		crews.add(emmyRaverLampman);
//		crews.add(bobbyNaderi);
//		crews.add(jeremyIrons);
//		crews.add(joshHutcherson);
//		crews.add(davidAyer);
//		movieService.addCrew(2L, crews);
//		
//		
//		// for movie id 3
//		Crew phyllisLogan = new Crew();
//		phyllisLogan.setName("Phyllis Logan");
//		phyllisLogan.setRole("Starring");
//		crewRepository.save(phyllisLogan);
//		
//		Crew colmMeaney = new Crew();
//		colmMeaney.setName("Colm Meaney");
//		colmMeaney.setRole("Starring");
//		crewRepository.save(colmMeaney);
//		
//		Crew willAttenborough = new Crew();
//		willAttenborough.setName("Will Attenborough");
//		willAttenborough.setRole("Starring");
//		crewRepository.save(willAttenborough);
//		
//		Crew jamesCarrollJordan = new Crew();
//		jamesCarrollJordan.setName("James Carroll Jordan");
//		jamesCarrollJordan.setRole("Starring");
//		crewRepository.save(jamesCarrollJordan);
//		
//		Crew claudioFah = new Crew();
//		claudioFah.setName("Claudio Fäh");
//		claudioFah.setRole("Director");
//		crewRepository.save(claudioFah);
//		
//		Movie noWayUp = new Movie();
//		noWayUp.setTitle("No Way Up");
//		noWayUp.setReleaseDate(LocalDate.of(2024, 02, 16));
//		noWayUp.setDuration(90);
//		noWayUp.setRating(5.0);
//		noWayUp.setCountry("United States");
//		noWayUp.setLanguage("English");
//		noWayUp.setNowShowing(true);
//		noWayUp.setComingSoon(false);
//		noWayUp.setPopularNow(true);
//		noWayUp.setShowing(true);
//		noWayUp.setTrailer("<iframe width=\"866\" height=\"487\" src=\"https://www.youtube.com/embed/oLvrlajijhk\" title=\"No Way Up Exclusive Trailer (2024)\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
//		noWayUp.setSynopsis("Characters from very different backgrounds are thrown together when the plane they're travelling on crashes into the Pacific Ocean. When the airliner comes to rest perilously close to the edge of a ravine with the surviving passengers and crew trapped in an air pocket, a nightmare fight for survival ensues with the air supply running out and dangers creeping in from all sides.");
//		movieRepository.save(noWayUp);
//		
//		List<Genere> genereNoWayUp = new ArrayList<>();
//		genereNoWayUp.add(action);
//		genereNoWayUp.add(adventure);
//		genereNoWayUp.add(drama);
//		movieService.addGenere(3L, genereNoWayUp);
//		
//		List<Crew> crewNoWayUp = new ArrayList<>();
//		crewNoWayUp.add(phyllisLogan);
//		crewNoWayUp.add(colmMeaney);
//		crewNoWayUp.add(willAttenborough);
//		crewNoWayUp.add(jamesCarrollJordan);
//		crewNoWayUp.add(claudioFah);
//		movieService.addCrew(3L, crewNoWayUp);
//		
//		
//		// for movie id 4
//		
//		Crew sofiaVergara = new Crew();
//		sofiaVergara.setName("Sofía Vergara");
//		sofiaVergara.setRole("Starring");
//		crewRepository.save(sofiaVergara); 
//		
//		Crew joeyKing = new Crew();
//		joeyKing.setName("Joey King");
//		joeyKing.setRole("Starring");
//		crewRepository.save(joeyKing); 
//		
//		Crew willFerrell = new Crew();
//		willFerrell.setName("Will Ferrell");
//		willFerrell.setRole("Starring");
//		crewRepository.save(willFerrell); 
//		
//		Crew steveCarell = new Crew();
//		steveCarell.setName("Steve Carell");
//		steveCarell.setRole("Starring");
//		crewRepository.save(steveCarell); 
//		
//		Crew kristenWiig = new Crew();
//		kristenWiig.setName("Kristen Wiig");
//		kristenWiig.setRole("Starring");
//		crewRepository.save(kristenWiig); 
//		
//		Crew mirandaCosgrove = new Crew();
//		mirandaCosgrove.setName("Miranda Cosgrove");
//		mirandaCosgrove.setRole("Starring");
//		crewRepository.save(mirandaCosgrove); 
//		
//		Crew chrisRenaud = new Crew();
//		chrisRenaud.setName("Chris Renaud");
//		chrisRenaud.setRole("Director");
//		crewRepository.save(chrisRenaud);
//		
//		Movie dm = new Movie();
//		dm.setTitle("Despicable Me 4");
//		dm.setReleaseDate(LocalDate.of(2024, 07, 03));
//		dm.setDuration(90);
//		dm.setRating(5.0);
//		dm.setCountry("United States");
//		dm.setLanguage("English");
//		dm.setNowShowing(false);
//		dm.setComingSoon(true);
//		dm.setPopularNow(false);
//		dm.setShowing(true);
//		dm.setTrailer("<iframe width=\"866\" height=\"487\" src=\"https://www.youtube.com/embed/qQlr9-rF32A\" title=\"Despicable Me 4 | Official Trailer\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
//		dm.setSynopsis("Gru, Lucy, Margo, Edith, and Agnes welcome a new member to the family, Gru Jr., who is intent on tormenting his dad. Gru faces a new nemesis in Maxime Le Mal and his girlfriend Valentina, and the family is forced to go on the run.");
//		movieRepository.save(dm);
//		
//		List<Genere> genereDm = new ArrayList<>();
//		genereDm.add(animation);
//		genereDm.add(adventure);
//		genereDm.add(comedy);
//		movieService.addGenere(4L, genereDm);
//		
//		List<Crew> crewDm = new ArrayList<>();
//		crewDm.add(sofiaVergara);
//		crewDm.add(joeyKing);
//		crewDm.add(willFerrell);
//		crewDm.add(steveCarell);
//		crewDm.add(kristenWiig);
//		crewDm.add(mirandaCosgrove);
//		crewDm.add(chrisRenaud);
//		movieService.addCrew(4L, crewDm);
//		
//		// for movie id 5
//		
//		Crew natsukiHanae = new Crew();
//		natsukiHanae.setName("Natsuki Hanae");
//		natsukiHanae.setRole("Starring");
//		crewRepository.save(natsukiHanae); 
//		
//		Crew kengoKawanishi = new Crew();
//		kengoKawanishi.setName("Kengo Kawanishi");
//		kengoKawanishi.setRole("Starring");
//		crewRepository.save(kengoKawanishi); 
//		
//		Crew akariKito = new Crew();
//		akariKito.setName("Akari Kitô");
//		akariKito.setRole("Starring");
//		crewRepository.save(akariKito); 
//		
//		Crew yoshitsuguMatsuoka = new Crew();
//		yoshitsuguMatsuoka.setName("Yoshitsugu Matsuoka");
//		yoshitsuguMatsuoka.setRole("Starring");
//		crewRepository.save(yoshitsuguMatsuoka); 
//		
//		Crew hiroShimono = new Crew();
//		hiroShimono.setName("Hiro Shimono");
//		hiroShimono.setRole("Starring");
//		crewRepository.save(hiroShimono); 
//		
//		Crew haruoSotozaki = new Crew();
//		haruoSotozaki.setName("Haruo Sotozaki");
//		haruoSotozaki.setRole("Director");
//		crewRepository.save(haruoSotozaki);
//		
//		Movie ds = new Movie();
//		ds.setTitle("Demon Slayer: Kimetsu No Yaiba - To the Hashira Training");
//		ds.setReleaseDate(LocalDate.of(2024, 02, 23));
//		ds.setDuration(104);
//		ds.setRating(5.0);
//		ds.setCountry("Japan");
//		ds.setLanguage("Japan");
//		ds.setNowShowing(true);
//		ds.setComingSoon(false);
//		ds.setPopularNow(false);
//		ds.setShowing(true);
//		ds.setTrailer("<iframe width=\"866\" height=\"487\" src=\"https://www.youtube.com/embed/SXcCdQdcBtw\" title=\"Demon Slayer: Kimetsu no Yaiba -To the Hashira Training Trailer #1 (2024)\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
//		ds.setSynopsis("Tanjiro undergoes rigorous training with the Stone Hashira, Himejima, in his quest to become a Hashira. Meanwhile, Muzan continues to search for Nezuko and Ubuyashiki.");
//		movieRepository.save(ds);
//		
//		List<Genere> genereDs = new ArrayList<>();
//		genereDs.add(animation);
//		movieService.addGenere(5L, genereDs);
//		
//		List<Crew> crewDs = new ArrayList<>();
//		crewDs.add(natsukiHanae);
//		crewDs.add(kengoKawanishi);
//		crewDs.add(akariKito);
//		crewDs.add(yoshitsuguMatsuoka);
//		crewDs.add(hiroShimono);
//		crewDs.add(haruoSotozaki);
//		movieService.addCrew(5L, crewDs);
//		
//		// for movie id 6
//		Crew sydneySweeney = new Crew();
//		sydneySweeney.setName("Sydney Sweeney");
//		sydneySweeney.setRole("Starring");
//		crewRepository.save(sydneySweeney);
//		
//		Crew isabelaMerced = new Crew();
//		isabelaMerced.setName("Isabela Merced");
//		isabelaMerced.setRole("Starring");
//		crewRepository.save(isabelaMerced); 
//		
//		Crew dakotaJohnson = new Crew();
//		dakotaJohnson.setName("Dakota Johnson");
//		dakotaJohnson.setRole("Starring");
//		crewRepository.save(dakotaJohnson); 
//		
//		Crew emmaRoberts = new Crew();
//		emmaRoberts.setName("Emma Roberts");
//		emmaRoberts.setRole("Starring");
//		crewRepository.save(emmaRoberts); 
//		
//		Crew adamScott = new Crew();
//		adamScott.setName("Adam Scott");
//		adamScott.setRole("Starring");
//		crewRepository.save(adamScott); 
//		
//		Crew celesteConnor = new Crew();
//		celesteConnor.setName("Celeste O'Connor");
//		celesteConnor.setRole("Starring");
//		crewRepository.save(celesteConnor); 
//		
//		Crew jillHennessy = new Crew();
//		jillHennessy.setName("Jill Hennessy");
//		jillHennessy.setRole("Starring");
//		crewRepository.save(jillHennessy); 
//		
//		Crew taharRahim = new Crew();
//		taharRahim.setName("Tahar Rahim");
//		taharRahim.setRole("Starring");
//		crewRepository.save(taharRahim); 
//		
//		Crew clarkson = new Crew();
//		clarkson.setName("S.J. Clarkson");
//		clarkson.setRole("Director");
//		crewRepository.save(clarkson);
//		
//		Movie madameWeb = new Movie();
//		madameWeb.setTitle("Madame Web");
//		madameWeb.setReleaseDate(LocalDate.of(2024, 02, 14));
//		madameWeb.setDuration(116);
//		madameWeb.setRating(5.0);
//		madameWeb.setCountry("United States");
//		madameWeb.setLanguage("English");
//		madameWeb.setNowShowing(true);
//		madameWeb.setComingSoon(false);
//		madameWeb.setPopularNow(true);
//		madameWeb.setShowing(true);
//		madameWeb.setTrailer("<iframe width=\"866\" height=\"487\" src=\"https://www.youtube.com/embed/s_76M4c4LTo\" title=\"MADAME WEB – Official Trailer (HD)\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>");
//		madameWeb.setSynopsis("Cassandra Webb develops the power to see the future. Forced to confront revelations about her past, she forges a relationship with three young women bound for powerful destinies, if they can all survive a deadly present.");
//		movieRepository.save(madameWeb);
//		
//		List<Genere> genereWeb = new ArrayList<>();
//		genereWeb.add(action);
//		genereWeb.add(adventure);
//		genereWeb.add(scienceFiction);
//		movieService.addGenere(6L, genereWeb);
//		
//		List<Crew> crewWeb = new ArrayList<>();
//		crewWeb.add(sydneySweeney);
//		crewWeb.add(isabelaMerced);
//		crewWeb.add(dakotaJohnson);
//		crewWeb.add(emmaRoberts);
//		crewWeb.add(adamScott);
//		crewWeb.add(celesteConnor);
//		crewWeb.add(jillHennessy);
//		crewWeb.add(taharRahim);
//		crewWeb.add(clarkson);
//		movieService.addCrew(6L, crewWeb);
//		
//		
//		Cinema mingalar = new Cinema();
//		mingalar.setName("Mingalar");
//		mingalar.setLocation("Mandalay");
//		cinemaRepository.save(mingalar);
//		
//		Theater minTheater1 = new Theater();
//		minTheater1.setName("MGR I");
//		minTheater1.setScreen("HDR");
//		minTheater1.setCinema(mingalar);
//		theaterRepository.save(minTheater1);
//		// seatPattern for mingalar->minTheater1
//		SeatPattern minStandardSeatPattern = new SeatPattern();
//		minStandardSeatPattern.setSeatPrice(5500);
//		minStandardSeatPattern.setSeatType(SeatType.STANDARD);
//		minStandardSeatPattern.setRowCount(4);
//		minStandardSeatPattern.setColumnCount(20);
//		minStandardSeatPattern.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minTheater1.getId(), minStandardSeatPattern);
//		
//		SeatPattern minPremiumSeatPattern = new SeatPattern();
//		minPremiumSeatPattern.setSeatPrice(6000);
//		minPremiumSeatPattern.setSeatType(SeatType.PREMIUM);
//		minPremiumSeatPattern.setRowCount(5);
//		minPremiumSeatPattern.setColumnCount(16);
//		minPremiumSeatPattern.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minTheater1.getId(), minPremiumSeatPattern);
//		// seatPattern for mingalar->minTheater1
//
//		ShowTime time1 = new ShowTime();
//		time1.setMovieTime(LocalDateTime.of(2024, 2, 29, 8, 30));
//		time1.setConnectMovie(theBoyandTheHeron.getId());
//		time1.setMovie(theBoyandTheHeron);
//		time1.setTheater(minTheater1);
//		showTimeService.createShowTime(time1, minTheater1.getId(), theBoyandTheHeron.getId());
//		
//		ShowTime time0 = new ShowTime();
//		time0.setMovieTime(LocalDateTime.of(2024,2,20,10,30));
//		time0.setConnectMovie(theBoyandTheHeron.getId());
//		time0.setMovie(theBoyandTheHeron);
//		time0.setTheater(minTheater1);
//		showTimeService.createShowTime(time0, minTheater1.getId(), theBoyandTheHeron.getId());
//		
//		ShowTime time01 = new ShowTime();
//		time01.setMovieTime(LocalDateTime.of(2024,3,20,6,30));
//		time01.setConnectMovie(theBoyandTheHeron.getId());
//		time01.setMovie(theBoyandTheHeron);
//		time01.setTheater(minTheater1);
//		showTimeService.createShowTime(time01, minTheater1.getId(), theBoyandTheHeron.getId());
//
//		ShowTime time2 = new ShowTime();
//		time2.setMovieTime(LocalDateTime.of(2024, 2, 27, 11, 00));
//		time2.setConnectMovie(theBeekeeper.getId());
//		time2.setMovie(theBeekeeper);
//		time2.setTheater(minTheater1);
//		showTimeService.createShowTime(time2, minTheater1.getId(), theBeekeeper.getId());
//		
//		ShowTime time11 = new ShowTime();
//		time11.setMovieTime(LocalDateTime.of(2024, 2, 27, 11, 00));
//		time11.setConnectMovie(noWayUp.getId());
//		time11.setMovie(noWayUp);
//		time11.setTheater(minTheater1);
//		showTimeService.createShowTime(time11, minTheater1.getId(), noWayUp.getId());
//		
//		ShowTime time12 = new ShowTime();
//		time12.setMovieTime(LocalDateTime.of(2024, 2, 27, 11, 00));
//		time12.setConnectMovie(dm.getId());
//		time12.setMovie(dm);
//		time12.setTheater(minTheater1);
//		showTimeService.createShowTime(time12, minTheater1.getId(), dm.getId());
//		
//		ShowTime time13 = new ShowTime();
//		time13.setMovieTime(LocalDateTime.of(2024, 2, 27, 11, 00));
//		time13.setConnectMovie(ds.getId());
//		time13.setMovie(ds);
//		time13.setTheater(minTheater1);
//		showTimeService.createShowTime(time13, minTheater1.getId(), ds.getId());
//		
//		ShowTime time14 = new ShowTime();
//		time14.setMovieTime(LocalDateTime.of(2024, 2, 27, 11, 00));
//		time14.setConnectMovie(madameWeb.getId());
//		time14.setMovie(madameWeb);
//		time14.setTheater(minTheater1);
//		showTimeService.createShowTime(time14, minTheater1.getId(), madameWeb.getId());
//	
//
//		Theater minTheater2 = new Theater();
//		minTheater2.setName("MGR II");
//		minTheater2.setScreen("HDR");
//		minTheater2.setCinema(mingalar);
//		theaterRepository.save(minTheater2);
//		// seatPattern for mingalar->minTheater1
//		SeatPattern minStandardSeatPattern2 = new SeatPattern();
//		minStandardSeatPattern2.setSeatPrice(5500);
//		minStandardSeatPattern2.setSeatType(SeatType.STANDARD);
//		minStandardSeatPattern2.setRowCount(4);
//		minStandardSeatPattern2.setColumnCount(25);
//		minStandardSeatPattern2.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minTheater2.getId(), minStandardSeatPattern2);
//		
//		SeatPattern minPremiumSeatPattern2 = new SeatPattern();
//		minPremiumSeatPattern2.setSeatPrice(6000);
//		minPremiumSeatPattern2.setSeatType(SeatType.PREMIUM);
//		minPremiumSeatPattern2.setRowCount(4);
//		minPremiumSeatPattern2.setColumnCount(10);
//		minPremiumSeatPattern2.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minTheater2.getId(), minPremiumSeatPattern2);
//		
//		SeatPattern minTwinSeatPattern2 = new SeatPattern();
//		minTwinSeatPattern2.setSeatPrice(12000);
//		minTwinSeatPattern2.setSeatType(SeatType.TWIN);
//		minTwinSeatPattern2.setRowCount(2);
//		minTwinSeatPattern2.setColumnCount(5);
//		minTwinSeatPattern2.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minTheater2.getId(), minTwinSeatPattern2);
//		// seatPattern for mingalar->minTheater1
//
//		ShowTime time3 = new ShowTime();
//		time3.setMovieTime(LocalDateTime.of(2024, 2, 28, 8, 30));
//		time3.setConnectMovie(dm.getId());
//		time3.setMovie(dm);
//		time3.setTheater(minTheater2);
//		showTimeService.createShowTime(time3, minTheater2.getId(), dm.getId());
//
//		ShowTime time4 = new ShowTime();
//		time3.setMovieTime(LocalDateTime.of(2024, 1, 31, 10, 00));
//		time4.setConnectMovie(theBeekeeper.getId());
//		time4.setMovie(theBeekeeper);
//		time4.setTheater(minTheater2);
//		showTimeService.createShowTime(time4, minTheater2.getId(), theBeekeeper.getId());
//		
//		
//		Cinema mingalarDaimond = new Cinema();
//		mingalarDaimond.setName("Mingalar Daimond");
//		mingalarDaimond.setLocation("Mandalay");
//		cinemaRepository.save(mingalarDaimond);
//		
//		Theater minDaiTheater1 = new Theater();
//		minDaiTheater1.setName("MDD I");
//		minDaiTheater1.setScreen("IMAX");
//		minDaiTheater1.setCinema(mingalarDaimond);
//		theaterRepository.save(minDaiTheater1);
//		
//		SeatPattern minDaiStandardSeatPattern = new SeatPattern();
//		minDaiStandardSeatPattern.setSeatPrice(6000);
//		minDaiStandardSeatPattern.setSeatType(SeatType.STANDARD);
//		minDaiStandardSeatPattern.setRowCount(5);
//		minDaiStandardSeatPattern.setColumnCount(20);
//		minDaiStandardSeatPattern.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minDaiTheater1.getId(), minDaiStandardSeatPattern);
//		
//		SeatPattern minDaiPremiumSeatPattern = new SeatPattern();
//		minDaiPremiumSeatPattern.setSeatPrice(12000);
//		minDaiPremiumSeatPattern.setSeatType(SeatType.PREMIUM);
//		minDaiPremiumSeatPattern.setRowCount(4);
//		minDaiPremiumSeatPattern.setColumnCount(16);
//		minDaiPremiumSeatPattern.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minDaiTheater1.getId(), minDaiPremiumSeatPattern);
//		
//		ShowTime time5 = new ShowTime();
//		time5.setMovieTime(LocalDateTime.of(2024, 1, 30, 8, 30));
//		time5.setConnectMovie(theBeekeeper.getId());
//		time5.setMovie(theBeekeeper);
//		time5.setTheater(minDaiTheater1);
//		showTimeService.createShowTime(time5, minDaiTheater1.getId(), theBeekeeper.getId());
//		
//		Theater minDaiTheater2 = new Theater();
//		minDaiTheater2.setName("MDD II");
//		minDaiTheater2.setScreen("HDR");
//		minDaiTheater2.setCinema(mingalarDaimond);
//		theaterRepository.save(minDaiTheater2);
//		
//		SeatPattern minDaiStandardSeatPattern2 = new SeatPattern();
//		minDaiStandardSeatPattern2.setSeatPrice(6000);
//		minDaiStandardSeatPattern2.setSeatType(SeatType.STANDARD);
//		minDaiStandardSeatPattern2.setRowCount(5);
//		minDaiStandardSeatPattern2.setColumnCount(18);
//		minDaiStandardSeatPattern2.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minDaiTheater2.getId(), minDaiStandardSeatPattern2);
//		
//		SeatPattern minDaiPremiumSeatPattern2 = new SeatPattern();
//		minDaiPremiumSeatPattern2.setSeatPrice(10000);
//		minDaiPremiumSeatPattern2.setSeatType(SeatType.PREMIUM);
//		minDaiPremiumSeatPattern2.setRowCount(3);
//		minDaiPremiumSeatPattern2.setColumnCount(10);
//		minDaiPremiumSeatPattern2.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minDaiTheater2.getId(), minDaiPremiumSeatPattern2);
//		
//		ShowTime time6 = new ShowTime();
//		time6.setMovieTime(LocalDateTime.of(2024, 1, 30, 8, 30));
//		time6.setConnectMovie(noWayUp.getId());
//		time6.setMovie(noWayUp);
//		time6.setTheater(minDaiTheater2);
//		showTimeService.createShowTime(time6, minDaiTheater2.getId(), noWayUp.getId());
//		
//		Cinema mingalarYgn = new Cinema();
//		mingalarYgn.setName("Mingalar");
//		mingalarYgn.setLocation("Yangon");
//		cinemaRepository.save(mingalarYgn);
//		
//		Theater minYgnTheater1 = new Theater();
//		minYgnTheater1.setName("MDR I");
//		minYgnTheater1.setScreen("3D");
//		minYgnTheater1.setCinema(mingalarYgn);
//		theaterRepository.save(minYgnTheater1);
//		
//		SeatPattern minYgnStandardSeatPattern = new SeatPattern();
//		minYgnStandardSeatPattern.setSeatPrice(6000);
//		minYgnStandardSeatPattern.setSeatType(SeatType.STANDARD);
//		minYgnStandardSeatPattern.setRowCount(4);
//		minYgnStandardSeatPattern.setColumnCount(20);
//		minYgnStandardSeatPattern.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minYgnTheater1.getId(), minYgnStandardSeatPattern);
//		
//		SeatPattern minYgnPremiumSeatPattern = new SeatPattern();
//		minYgnPremiumSeatPattern.setSeatPrice(6000);
//		minYgnPremiumSeatPattern.setSeatType(SeatType.PREMIUM);
//		minYgnPremiumSeatPattern.setRowCount(5);
//		minYgnPremiumSeatPattern.setColumnCount(16);
//		minYgnPremiumSeatPattern.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minYgnTheater1.getId(), minYgnPremiumSeatPattern);
//		
//		ShowTime time7 = new ShowTime();
//		time7.setMovieTime(LocalDateTime.of(2024, 1, 30, 8, 30));
//		time7.setConnectMovie(ds.getId());
//		time7.setMovie(ds);
//		time7.setTheater(minYgnTheater1);
//		showTimeService.createShowTime(time7, minYgnTheater1.getId(), ds.getId());
//		
//		Theater minYgnTheater2 = new Theater();
//		minYgnTheater2.setName("MDR II");
//		minYgnTheater2.setScreen("HDR");
//		minYgnTheater2.setCinema(mingalarYgn);
//		theaterRepository.save(minYgnTheater2);
//		
//		SeatPattern minYgnStandardSeatPattern2 = new SeatPattern();
//		minYgnStandardSeatPattern2.setSeatPrice(6000);
//		minYgnStandardSeatPattern2.setSeatType(SeatType.STANDARD);
//		minYgnStandardSeatPattern2.setRowCount(6);
//		minYgnStandardSeatPattern2.setColumnCount(20);
//		minYgnStandardSeatPattern2.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minYgnTheater2.getId(), minYgnStandardSeatPattern2);
//		
//		SeatPattern minYgnPremiumSeatPattern2 = new SeatPattern();
//		minYgnPremiumSeatPattern2.setSeatPrice(6000);
//		minYgnPremiumSeatPattern2.setSeatType(SeatType.PREMIUM);
//		minYgnPremiumSeatPattern2.setRowCount(3);
//		minYgnPremiumSeatPattern2.setColumnCount(16);
//		minYgnPremiumSeatPattern2.setRowsOrder(1);
//		seatPatternService.createSeatPattern(minYgnTheater2.getId(), minYgnPremiumSeatPattern2);
//		
//		ShowTime time8 = new ShowTime();
//		time8.setMovieTime(LocalDateTime.of(2024, 1, 30, 8, 30));
//		time8.setConnectMovie(madameWeb.getId());
//		time8.setMovie(madameWeb);
//		time8.setTheater(minYgnTheater2);
//		showTimeService.createShowTime(time8, minYgnTheater2.getId(), madameWeb.getId());
//		
//		Cinema myoma = new Cinema();
//		myoma.setName("Myoma Cinema");
//		myoma.setLocation("Yangon");
//		cinemaRepository.save(myoma);
//		
//		Theater myomaTheater1 = new Theater();
//		myomaTheater1.setName("MM I");
//		myomaTheater1.setScreen("3D");
//		myomaTheater1.setCinema(myoma);
//		theaterRepository.save(myomaTheater1);
//		
//		SeatPattern myomaStandardSeatPattern = new SeatPattern();
//		myomaStandardSeatPattern.setSeatPrice(6000);
//		myomaStandardSeatPattern.setSeatType(SeatType.STANDARD);
//		myomaStandardSeatPattern.setRowCount(4);
//		myomaStandardSeatPattern.setColumnCount(20);
//		myomaStandardSeatPattern.setRowsOrder(1);
//		seatPatternService.createSeatPattern(myomaTheater1.getId(), myomaStandardSeatPattern);
//		
//		SeatPattern myomaPremiumSeatPattern = new SeatPattern();
//		myomaPremiumSeatPattern.setSeatPrice(6000);
//		myomaPremiumSeatPattern.setSeatType(SeatType.PREMIUM);
//		myomaPremiumSeatPattern.setRowCount(5);
//		myomaPremiumSeatPattern.setColumnCount(16);
//		myomaPremiumSeatPattern.setRowsOrder(1);
//		seatPatternService.createSeatPattern(myomaTheater1.getId(), myomaPremiumSeatPattern);
//		
//		ShowTime time9 = new ShowTime();
//		time9.setMovieTime(LocalDateTime.of(2024, 1, 30, 8, 30));
//		time9.setConnectMovie(theBeekeeper.getId());
//		time9.setMovie(theBeekeeper);
//		time9.setTheater(myomaTheater1);
//		showTimeService.createShowTime(time9, myomaTheater1.getId(), theBeekeeper.getId());
//		
//		Theater myomaTheater2 = new Theater();
//		myomaTheater2.setName("MDR II");
//		myomaTheater2.setScreen("HDR");
//		myomaTheater2.setCinema(myoma);
//		theaterRepository.save(myomaTheater2);
//		
//		SeatPattern myomaStandardSeatPattern2 = new SeatPattern();
//		myomaStandardSeatPattern2.setSeatPrice(6000);
//		myomaStandardSeatPattern2.setSeatType(SeatType.STANDARD);
//		myomaStandardSeatPattern2.setRowCount(6);
//		myomaStandardSeatPattern2.setColumnCount(20);
//		myomaStandardSeatPattern2.setRowsOrder(1);
//		seatPatternService.createSeatPattern(myomaTheater2.getId(), myomaStandardSeatPattern2);
//		
//		SeatPattern myomaPremiumSeatPattern2 = new SeatPattern();
//		myomaPremiumSeatPattern2.setSeatPrice(6000);
//		myomaPremiumSeatPattern2.setSeatType(SeatType.PREMIUM);
//		myomaPremiumSeatPattern2.setRowCount(3);
//		myomaPremiumSeatPattern2.setColumnCount(16);
//		myomaPremiumSeatPattern2.setRowsOrder(1);
//		seatPatternService.createSeatPattern(myomaTheater2.getId(), myomaPremiumSeatPattern2);
//
//		ShowTime time10 = new ShowTime();
//		time10.setMovieTime(LocalDateTime.of(2024, 1, 30, 8, 30));
//		time10.setConnectMovie(ds.getId());
//		time10.setMovie(ds);
//		time10.setTheater(myomaTheater2);
//		showTimeService.createShowTime(time10, myomaTheater2.getId(), ds.getId());
//		
//		Coupon kyimal1234 = new Coupon();
//		kyimal1234.setCouponCode("kyimal1234");
//		kyimal1234.setDiscount(3000);
//		kyimal1234.setExpiryDate(LocalDate.of(2024, 2, 28));
//		kyimal1234.setUserCount(0);
//		couponService.CreateCoupon(kyimal1234);
//		
//		Coupon cinema1234 = new Coupon();
//		cinema1234.setCouponCode("cinema1234");
//		cinema1234.setDiscount(2000);
//		cinema1234.setExpiryDate(LocalDate.of(2024, 1, 31));
//		cinema1234.setUserCount(10);
//		couponService.CreateCoupon(cinema1234);
//		
//		Coupon coupon = new Coupon();
//		coupon.setCouponCode("coupon1234");
//		coupon.setDiscount(1000);
//		coupon.setExpiryDate(LocalDate.of(2024, 3, 31));
//		coupon.setUserCount(10);
//		couponService.CreateCoupon(coupon);
	}

}
