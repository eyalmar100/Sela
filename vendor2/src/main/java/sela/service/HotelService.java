package sela.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sela.dao.HotelsDao;
import sela.model.Hotel;

@Service
public class HotelService {
	
	
	@Autowired
	private HotelsDao hotelsDao;
	
	public Hotel getHotelByName(String hotelName) {
		return hotelsDao.getHotel(hotelName);
		
	}

}
