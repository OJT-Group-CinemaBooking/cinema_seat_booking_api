package com.hostmdy.cinema.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hostmdy.cinema.domain.Seat;
import com.hostmdy.cinema.domain.SeatPattern;
import com.hostmdy.cinema.domain.SeatType;
import com.hostmdy.cinema.domain.Theater;
import com.hostmdy.cinema.exception.DatabaseResourceNotFoundException;
import com.hostmdy.cinema.repository.SeatPatternRepository;
import com.hostmdy.cinema.repository.SeatRepository;
import com.hostmdy.cinema.repository.TheaterRepository;
import com.hostmdy.cinema.service.SeatPatternService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeatPatternServiceImpl implements SeatPatternService{
	
	private final SeatPatternRepository seatPatternRepository;
	private final TheaterRepository theaterRepository;
	private final SeatRepository seatRepository;
	
	private void saveSeat(Integer row, Integer col, Integer seatPrice, SeatType seatType, SeatPattern seatPattern) {
		Seat seat = new Seat();
		seat.setRowNo(row);
		seat.setColumnNo(col);
		seat.setPrice(seatPrice);
		seat.setType(seatType);
		seat.setSeatPattern(seatPattern);
		seatRepository.save(seat);
	}
	
	private Theater getTheaterById(Long theaterId) {
		Optional<Theater> theaterOptional = theaterRepository.findById(theaterId);
		if(theaterOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("theater", "id", "theater with id : "+theaterId+" is not found");
		}
		return theaterOptional.get();
	}

	@Override
	public List<SeatPattern> getAllSeatPattern() {
		// TODO Auto-generated method stub
		return (List<SeatPattern>) seatPatternRepository.findAll();
	}

	@Override
	public List<SeatPattern> getAllSeatPatternByTheaterId(Long theaterId) {
		// TODO Auto-generated method stub
		return seatPatternRepository.findByTheater(getTheaterById(theaterId));
	}

	@Override
	public SeatPattern saveSeatPattern(SeatPattern seatPattern) {
		// TODO Auto-generated method stub
		return seatPatternRepository.save(seatPattern);
	}

	@Override
	public Optional<SeatPattern> getSeatPatternById(Long seatPatternId) {
		// TODO Auto-generated method stub
		return seatPatternRepository.findById(seatPatternId);
	}
	
	
	@Override
	@Transactional
	public SeatPattern createSeatPattern(Long theaterId,SeatPattern seatPattern) {
		// TODO Auto-generated method stub
		seatPattern.setTheater(getTheaterById(theaterId));
		SeatPattern createdSeatPattern = seatPatternRepository.save(seatPattern);
		for (int rowNo = 1; rowNo <= createdSeatPattern.getRowCount(); rowNo++) {
			for (int colNo = 1; colNo <= createdSeatPattern.getColumnCount(); colNo++) {
				saveSeat(
						rowNo, 
						colNo, 
						createdSeatPattern.getSeatPrice(), 
						createdSeatPattern.getSeatType(), 
						createdSeatPattern
				);
			}
		}
		return createdSeatPattern;
	}
	

	@Override
	@Transactional
	public SeatPattern updateSeatPattern(Long theaterId, SeatPattern newSeatPattern) {
		// TODO Auto-generated method stub
		
		Optional<SeatPattern> oldSeatPatternOptional = getSeatPatternById(newSeatPattern.getId());
		if(oldSeatPatternOptional.isEmpty()) {
			throw new DatabaseResourceNotFoundException("seatPattern", "id", "seatPattern id not found in Database");
		}
		
		SeatPattern oldSeatPattern = oldSeatPatternOptional.get();
		
		for (final Seat seat : oldSeatPattern.getSeats()) {
			seat.setPrice(newSeatPattern.getSeatPrice());
			seat.setType(newSeatPattern.getSeatType());
			seat.setSeatPattern(oldSeatPattern);
			seatRepository.save(seat);
		}
		
		int oldRow = oldSeatPattern.getRowCount();
		int oldCol = oldSeatPattern.getColumnCount();
		int newRow = newSeatPattern.getRowCount();
		int newCol = newSeatPattern.getColumnCount();
		
		if(newRow > oldRow) {
			for (int row = oldRow+1 ; row <= newRow; row++) {
				
				for (int col = 1 ; col <= newCol; col++) {
					saveSeat(
							row, 
							col, 
							newSeatPattern.getSeatPrice(), 
							newSeatPattern.getSeatType(), 
							oldSeatPattern
					);
				}
			}
		}
		
		if(newRow < oldRow) {
			for (int row = oldRow ; row > newRow; row--) {
				int rowNo = row;
				List<Seat> oldSeatList = oldSeatPattern.getSeats();
				List<Seat> seatList = oldSeatList.stream().filter(os -> os.getRowNo() == rowNo).toList();
				seatRepository.deleteAll(seatList);
			}
		}
		
		
		if(newCol > oldCol) {
			for (int row = 1; row <= oldRow; row++) {
				for (int col = oldCol+1; col <= newCol; col++) {
					saveSeat(
							row, 
							col, 
							newSeatPattern.getSeatPrice(), 
							newSeatPattern.getSeatType(), 
							oldSeatPattern
					);
				}
			}
		}
		
		if(newCol < oldCol) {
			for (int col = oldCol; col > newCol; col--) {
				int colNo = col;
				List<Seat> oldSeatList = oldSeatPattern.getSeats();
				List<Seat> seatList = oldSeatList.stream().filter(os -> os.getColumnNo() == colNo).toList();
				seatRepository.deleteAll(seatList);
			}
		}
		
		newSeatPattern.setTheater(getTheaterById(theaterId));
		return seatPatternRepository.save(newSeatPattern);
	}
	

	@Override
	public Boolean deleteSeatPatternById(Long seatPatternId) {
		// TODO Auto-generated method stub
		if(getSeatPatternById(seatPatternId).isEmpty()) {
			return false;
		}
		List<Seat> seatList = (getSeatPatternById(seatPatternId).get()).getSeats();
		seatRepository.deleteAll(seatList);
		seatPatternRepository.deleteById(seatPatternId);
		return true;
	}

}
