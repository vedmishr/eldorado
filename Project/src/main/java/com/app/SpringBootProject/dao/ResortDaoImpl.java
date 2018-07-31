package com.app.SpringBootProject.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.SpringBootProject.bean.Resort;
import com.app.SpringBootProject.bean.ResortRowMapper;

@Transactional
@Repository
public class ResortDaoImpl implements IResortDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	Date date = new Date();
	
	@Override
	public Resort registerResort(Resort resort,long guest_id) {

		
		String status = "booked";

		String query = "INSERT INTO resort(guest_id,room_type,arrival_date,departure_date,no_of_people,created_date,updated_date) VALUES (?,?,?,?,?,?,?)";

		long success;
		try {
			success = jdbcTemplate.update(query, guest_id, resort.getRoomType(), resort.getArrivalDate(),
					resort.getDepartureDate(), resort.getNoOfPeople(), date, date);
		} catch (DataAccessException e) {
			return null;
		}
		if (success == 1) {
			String query1 = "UPDATE resort SET status=? ";

			jdbcTemplate.update(query1, status);

		} 

		Resort resort1 = jdbcTemplate.queryForObject("select * from resort where r_reservation_number in(select max(r_reservation_number) from resort);", new ResortRowMapper());
		
		return resort1;
	}

	@Override
	public long updateResort(Resort resort, long r_reservation_number) {

		long success;
		
		String query = "UPDATE resort SET room_type=?, arrival_date=?, departure_date=?,no_of_people=?,updated_date=? WHERE r_reservation_number=?";
		try {
			success=jdbcTemplate.update(query, resort.getRoomType(), resort.getArrivalDate(), resort.getDepartureDate(),
					resort.getNoOfPeople(), date, r_reservation_number);
		} catch (DataAccessException e) {
			return 0;
		}
		return success;
	}

	@Override
	public Resort getResort(long r_reservation_number) {
		Resort resort;
		try {
			resort = jdbcTemplate.queryForObject("SELECT * FROM resort WHERE r_reservation_number = ?",
					new Object[] { r_reservation_number }, new ResortRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
		return resort;
	}

	@Override
	public List<Resort> getAllResort(long guest_id) {
		String query = "SELECT * FROM RESORT WHERE guest_id=" + guest_id + "";
		List<Resort> resort;
		try {
			resort = jdbcTemplate.query(query, new ResortRowMapper());
		} catch (DataAccessException e) {
			return null;
		}
		return resort;
	}

	@Override
	public long cancelResort(long r_reservation_number) {

		String status = "cancelled";
		long success=0;

		String query1 = "UPDATE resort SET status=? where r_reservation_number="+r_reservation_number+"";

		try {
			success=jdbcTemplate.update(query1, status);
		} catch (DataAccessException e) {
			return 0;
		}
		
		if(success==1)
		{
			return r_reservation_number;
		}
		return 0;

	}

}
