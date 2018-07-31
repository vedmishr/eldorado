package com.app.SpringBootProject.dao;

import java.util.List;

import com.app.SpringBootProject.bean.Dining;


public interface IDiningDao {
	
	public Dining registerDining(Dining dining,long guestId);
	
	public long updateDining(Dining dining,long dReservationNumber);
	public Dining getDining(long dReservationNumber);

	public List<Dining> getAllDining(long guest_id);
	public long cancelDining(long dReservationNumber);
}
