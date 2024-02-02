package com.hostmdy.cinema.service;

import java.util.List;

import com.hostmdy.cinema.domain.BoughtSeat;

public interface BoughtSeatService {
	
	BoughtSeat saveBoughtSeat(BoughtSeat boughtSeat);
	
	List<BoughtSeat> getAllBoughtSeat();

}
