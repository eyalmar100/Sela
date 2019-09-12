package sela.controller;

import java.util.List;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javafx.util.Pair;
import sela.model.Hotel;
import sela.service.HotelLookupService;
import sela.util.PairComarator;
import sela.util.PairDesirializer;

 

@RestController
public class VendorController {
	private static final Logger logger = Logger.getLogger(VendorController.class);
	
	public static final String HOTEL_NOT_FOUND_MESSAGE="Requeted Hotel not Found";

	@Autowired
	private HotelLookupService hotelLookupService;
	
	 
	private PairComarator pairComarator;
	
	
	@PostConstruct
	public void init() {
		pairComarator=new PairComarator();
	}

	@SuppressWarnings("restriction")
	@GetMapping({ "/api/{hotel}" })
	public String hotel(@PathVariable String hotel) {
	//public Pair<String, Hotel> hotel(@PathVariable String hotel) {
		logger.info("EventController.events(): hotel hotel is : " + hotel);
		 	
	 
		List<Pair<String, Hotel>> hotelsList=null;
		 
		hotelsList = hotelLookupService.findAllHotels(hotel.toLowerCase());
	 
		 
	        
        if(hotelsList==null) {
        	return null;//new Pair<>(HOTEL_NOT_FOUND_MESSAGE,null);
        }
           
	 	Stream<Pair<String, Hotel>> str=hotelsList.stream();
	 	Pair<String, Hotel> minPair=str.min(pairComarator).orElse(new Pair<>(HOTEL_NOT_FOUND_MESSAGE,null));
	 	return PairDesirializer.prettifyString(minPair);
	 		 
	}

	@GetMapping({ "/api/test/{hotel}" })
	public String t(@PathVariable String hotel) {
		
		logger.info("EventController.events(): hotel hotel is : " + hotel);
	 	String hotelsList = hotelLookupService.getTestString();
		return hotelsList;
	  	 
	 		 
	}
	
	
	
	 

}
