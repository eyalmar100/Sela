package sela.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import sela.model.Hotel;

@Component
@Profile("dev")
public class DevHotelsDao implements IHotelDao {

	private HashMap<String, Hotel> hotelsList;

	@Value( "${db1.table}" )
	private String dbTable1;
	
	
	 
	
	@PostConstruct
	public void loadHotelsFromDB() throws IOException {
		 
		String dbTable=System.getProperty("db.table");
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
   
	@Override
	public Hotel getHotel(String name) {
		return hotelsList.get(name);
	}

}
