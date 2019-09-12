package sela.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sela.dao.DevHotelsDao;
import sela.dao.IHotelDao;
import sela.model.Hotel;

@Service
public class HotelService {
	
	
	@Autowired
	private IHotelDao hotelsDao;
	
	public Hotel getHotelByName(String hotelName) {
		return hotelsDao.getHotel(hotelName);
		
	}

}
