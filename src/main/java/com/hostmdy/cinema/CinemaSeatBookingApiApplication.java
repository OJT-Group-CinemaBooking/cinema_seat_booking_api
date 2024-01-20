package com.hostmdy.cinema;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hostmdy.cinema.domain.Seat;
import com.hostmdy.cinema.domain.SeatPattern;
import com.hostmdy.cinema.domain.SeatPosition;
import com.hostmdy.cinema.domain.SeatType;
import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.repository.SeatPatternRepository;
import com.hostmdy.cinema.repository.SeatPositionRepository;
import com.hostmdy.cinema.repository.SeatRepository;
import com.hostmdy.cinema.repository.TheaterRepository;

@SpringBootApplication
public class CinemaSeatBookingApiApplication implements CommandLineRunner{
	
	@Autowired
	public TheaterRepository theaterRepository;
	
	@Autowired
	public SeatPatternRepository seatPatternRepository;
	
	@Autowired
	public SeatPositionRepository seatPositionRepository;
	
	@Autowired
	public SeatRepository seatRepository;

	public static void main(String[] args) {
		SpringApplication.run(CinemaSeatBookingApiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		SeatPattern seatPattern1 = new SeatPattern();
		seatPattern1.setSeatTypeNumber(2);
		seatPattern1.setImage("image");
		
		seatPatternRepository.save(seatPattern1);
		
		Theater theater1 = new Theater();
		theater1.setName("Theater 1");
		theater1.setSeatPattern(seatPattern1);
		
		theaterRepository.save(theater1);
		
		SeatPosition seatPosition1 = new SeatPosition();
		seatPosition1.setColumnCount(10);
		seatPosition1.setRowCount(4);
		seatPosition1.setSeatTypeOrder(1);
		seatPosition1.setType(SeatType.NORMAL);
		seatPosition1.setSeatPattern(seatPattern1);
		
		seatPositionRepository.save(seatPosition1);
		
		SeatPosition seatPosition2 = new SeatPosition();
		seatPosition2.setColumnCount(8);
		seatPosition2.setRowCount(2);
		seatPosition2.setSeatTypeOrder(2);
		seatPosition2.setType(SeatType.PREMIUM);
		seatPosition2.setSeatPattern(seatPattern1);
		
		seatPositionRepository.save(seatPosition2);
		
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
