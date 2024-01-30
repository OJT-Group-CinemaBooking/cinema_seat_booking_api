package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostmdy.cinema.domain.BookSeat;
import com.hostmdy.cinema.domain.Movie;
import com.hostmdy.cinema.domain.Seat;
import com.hostmdy.cinema.domain.SeatPattern;
import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.domain.Ticket;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.repository.BookSeatRepository;
import com.hostmdy.cinema.repository.MovieRepository;
import com.hostmdy.cinema.repository.SeatPatternRepository;
import com.hostmdy.cinema.repository.SeatRepository;
import com.hostmdy.cinema.repository.ShowTimeRepository;
import com.hostmdy.cinema.repository.TheaterRepository;
import com.hostmdy.cinema.repository.TicketRepository;
import com.hostmdy.cinema.service.ShowTimeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService{
	
	private final ShowTimeRepository showTimeRepository;
	private final TheaterRepository theaterRepository;
	private final SeatPatternRepository seatPatternRepository;
	private final SeatRepository seatRepository;
	private final BookSeatRepository bookSeatRepository;
	private final TicketRepository ticketRepository;
	private final MovieRepository movieRepository;
	
	private Movie getShowtimeByMovieId(Long movieId) {
		Optional<Movie> movieOptional = movieRepository.findById(movieId);
		if(movieOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("showtime","movieId","showtime with movieId ="+movieId+" is not found.");
		}
		return movieOptional.get();
	}
	
	private Theater getShowtimeByTheaterId(Long theaterId) {
		Optional<Theater> theaterOptional = theaterRepository.findById(theaterId);
		if(theaterOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("showtime","theaterid","showtime with theaterId ="+theaterId+" is not found.");
		}
		return theaterOptional.get();
	}

	@Override
	public List<ShowTime> getAllShowTime() {
		// TODO Auto-generated method stub
		return (List<ShowTime>) showTimeRepository.findAll();
	}

	@Override
	public ShowTime saveShowTime(ShowTime showTime) {
		// TODO Auto-generated method stub
		return showTimeRepository.save(showTime);
	}

	@Override
	public List<ShowTime> getShowTimeByTheaterId(Long theaterId) {
		// TODO Auto-generated method stub
		return showTimeRepository.findByTheater(getShowtimeByTheaterId(theaterId));
	}


	@Override
	public Optional<ShowTime> getShowTimeById(Long showTimeId) {
		// TODO Auto-generated method stub
		return showTimeRepository.findById(showTimeId);
	}

	@Override
	public List<ShowTime> getShowTimeByMovieId(Long movieId) {
		// TODO Auto-generated method stub
		return showTimeRepository.findByMovie(getShowtimeByMovieId(movieId));
	}

	@Override
	@Transactional
	public ShowTime createShowTime(ShowTime showTime, Long theaterId, Long movieId) {
		// TODO Auto-generated method stub
		Theater theater = getShowtimeByTheaterId(theaterId);
		showTime.setTheater(theater);
		showTime.setConnectMovie(movieId);
		showTime.setMovie(getShowtimeByMovieId(movieId));
		ShowTime createdShowTime = saveShowTime(showTime);
		
		List<SeatPattern> seatPatternList = seatPatternRepository.findByTheater(theater);
		
		for (final SeatPattern seatPattern : seatPatternList) {
			List<Seat> seatList = seatRepository.findBySeatPattern(seatPattern);
			for (final Seat seat : seatList) {
				BookSeat bookSeat = new BookSeat();
				bookSeat.setTaken(false);
				bookSeat.setSeat(seat);
				bookSeat.setShowTime(createdShowTime);
				bookSeatRepository.save(bookSeat);
			}
		}
		
		return createdShowTime;
	}

	@Override
	public ShowTime updateShowTime(ShowTime showTime) {
		// TODO Auto-generated method stub
		Optional<ShowTime> showTimeOptional = showTimeRepository.findById(showTime.getId());
		if(showTimeOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("showtime", "showtimeId", "showtime with id = "+showTime.getId()+" is not found.");
		}
		ShowTime showtime = showTimeOptional.get();
		showTime.setMovie(showtime.getMovie());
		showTime.setTheater(showtime.getTheater());
		showTime.setConnectMovie(showTime.getMovie().getId());
		return saveShowTime(showTime);
	}

	@Override
	@Transactional
	public Boolean deleteShowTime(Long showTimeId) {
		// TODO Auto-generated method stub
		Optional<ShowTime> showtimeOptional = showTimeRepository.findById(showTimeId);
		if(showtimeOptional.isEmpty()) {
			return false;
		}
		ShowTime showtime = showtimeOptional.get();
		
		List<BookSeat> bookSeatList = bookSeatRepository.findByShowTime(showtime);
		bookSeatRepository.deleteAll(bookSeatList);
		
		List<Ticket> ticketList = ticketRepository.findTicketByShowTime(showtime);
		for (final Ticket ticket : ticketList) {
			ticket.setShowTime(null);
			ticketRepository.save(ticket);
		}
		
		showTimeRepository.deleteById(showTimeId);
		return true;
	}

}
