package sela.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import sela.model.Hotel;

@Component
public class HotelsDao {

	private HashMap<String, Hotel> hotelsList;

	@Value( "${db.table}" )
	private String dbTable;
	
	@PostConstruct
	public void loadHotelsFromDB() throws IOException {
		 
		InputStream resource = new ClassPathResource(dbTable).getInputStream();
		ObjectMapper objectMapper = new ObjectMapper();		
		Hotel [] hotels=objectMapper.readValue(resource, Hotel[].class);
		populateHotelsList(hotels);
	 
	}

	private void populateHotelsList(Hotel [] hotels) {
		hotelsList=new HashMap<>();
		for (Hotel hotel:hotels) {
			hotelsList.put(hotel.getName().toLowerCase(), hotel); 	
		}
		 
		
	}

	public Hotel getHotel(String name) {
		return hotelsList.get(name);
	}

}
