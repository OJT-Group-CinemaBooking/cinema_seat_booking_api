package com.hostmdy.cinema.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hostmdy.cinema.domain.BookSeat;
import com.hostmdy.cinema.domain.BoughtSeat;
import com.hostmdy.cinema.domain.Coupon;
import com.hostmdy.cinema.domain.Ticket;
import com.hostmdy.cinema.service.BookSeatService;
import com.hostmdy.cinema.service.BoughtSeatService;
import com.hostmdy.cinema.service.CouponService;
import com.hostmdy.cinema.service.TicketService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/bookSeat")
@CrossOrigin("http://localhost:3000")
public class BookSeatController {
	
	private final BookSeatService bookSeatService;
	private final CouponService couponService;
	private final TicketService ticketService;
	private final BoughtSeatService boughtSeatService;
	
	@GetMapping("/all/{showTimeId}/showTime")
	public ResponseEntity<List<BookSeat>> getBookSeatListByShowTime(@PathVariable Long showTimeId) {
		return ResponseEntity.ok(bookSeatService.getByShowTimeId(showTimeId));
	}
	
	@PostMapping("/booked/{showTimeId}/{couponId}")
	public ResponseEntity<Ticket> getBookedSeat(@RequestBody List<BoughtSeat> boughtSeatList,@PathVariable Long showTimeId,@PathVariable Long couponId) {
		System.out.println(couponId);
		Integer totalPrice = 0;
		for (final BoughtSeat boughtSeat : boughtSeatList) {
			totalPrice += boughtSeat.getPrice();
		}
		
		Ticket ticket = new Ticket();
		ticket.setTotalPrice(totalPrice);
		
		if(couponId > 0) {
			Coupon coupon = couponService.getCouponById(couponId).get();
			ticket.setActualPrice(totalPrice-coupon.getDiscount());
		} else {
			ticket.setActualPrice(totalPrice);
		}
		
		Ticket createdTicket = ticketService.createTicket(ticket, showTimeId, "mm001");
		
		for (final BoughtSeat boughtSeat : boughtSeatList) {
			boughtSeat.setTicket(createdTicket);
			boughtSeatService.saveBoughtSeat(boughtSeat);
			createdTicket.getBoughtSeats().add(boughtSeat);
		}
		
		createdTicket = ticketService.saveTicket(createdTicket);
		
		return ResponseEntity.ok(createdTicket);
	}

}
