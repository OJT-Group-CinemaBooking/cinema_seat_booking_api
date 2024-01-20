package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hostmdy.cinema.domain.BookSeat;
import com.hostmdy.cinema.domain.Seat;
import com.hostmdy.cinema.domain.SeatPattern;
import com.hostmdy.cinema.domain.SeatPosition;
import com.hostmdy.cinema.domain.ShowTime;
import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.repository.BookSeatRepository;
import com.hostmdy.cinema.repository.SeatRepository;
import com.hostmdy.cinema.repository.ShowTimeRepository;
import com.hostmdy.cinema.repository.TheaterRepository;
import com.hostmdy.cinema.service.ShowTimeService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShowTimeServiceImpl implements ShowTimeService{
	
	private final ShowTimeRepository showTimeRepository;
	private final TheaterRepository theaterRepository;
	private final BookSeatRepository bookSeatRepository;
	private final SeatRepository seatRepository;

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
	public void deleteShowTime(Long showTimeId) {
		// TODO Auto-generated method stub
		showTimeRepository.deleteById(showTimeId);
	}

	@Override
	public ShowTime createShowTime(ShowTime showTime, Long theaterId) {
		// TODO Auto-generated method stub
		Optional<Theater> theaterOptional = theaterRepository.findById(theaterId);
		if(theaterOptional.isEmpty()) {
			throw new NullPointerException();
		}
		Theater theater = theaterOptional.get();
		showTime.setTheater(theater);
		ShowTime createdShowTime = saveShowTime(showTime);
		
		createBookSeat(theater,createdShowTime);
		
		return showTime;
	}
	
	private void createBookSeat(Theater theater,ShowTime showTime) {
		SeatPattern seatPattern = theater.getSeatPattern();
		List<SeatPosition> seatPositions = seatPattern.getSeatPosition();
		String[] alpherbet = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S"};
		int alpherbetIndex = 0;
		for(SeatPosition position : seatPositions) {
			for(int i = 0;i < position.getRowCount();i++) {
				for(int j = 0;j < position.getColumnCount();j++) {
					BookSeat bookSeat = new BookSeat();
					bookSeat.setSeatNumber(""+alpherbet[alpherbetIndex]+"-"+(j+1)+"");
					bookSeat.setTaken(false);
					bookSeat.setShowTime(showTime);
					
					Seat seat = seatRepository.findByType(position.getType());
					
					bookSeat.setSeat(seat);
					
					bookSeatRepository.save(bookSeat);
				}
				alpherbetIndex++;
			}
			
		}
	}

	@Override
	public Optional<ShowTime> getShowTimeById(Long showTimeId) {
		// TODO Auto-generated method stub
		return showTimeRepository.findById(showTimeId);
	}

}
