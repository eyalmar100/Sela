package sela.controller;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.stream.Stream;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javafx.util.Pair;
import sela.model.Hotel;
import sela.service.HotelLookupService;
import sela.util.PairComarator;

@RestController
public class VendorController {
	public static final Logger logger = Logger.getLogger(VendorController.class);

	@Autowired
	private HotelLookupService hotelLookupService;
	
	@Autowired
	private PairComarator pairComarator;

	@GetMapping({ "/api/{hotel}" })
	public Pair<String, Hotel> hotel(@PathVariable String hotel) {
		logger.info("EventController.events(): hotel hotel is : " + hotel);
		 	
	 
		List<Pair<String, Hotel>> hotelsList=null;
		 
		hotelsList = hotelLookupService.findHotelAsync(hotel.toLowerCase());
	 
		 
	        
        if(hotelsList==null) {
        	return new Pair<>("Requeted Hotel not Found ",null);
        }
           
	 	Stream<Pair<String, Hotel>> str=hotelsList.stream();
	 	Pair<String, Hotel> minPair=str.min(pairComarator).orElse(new Pair<>("Requeted Hotel not Found ",null));
	 	return minPair;
	 		 
	}

	private Pair<String, Hotel> findMinPriceOfHotelFromAllVendors(String hotel, int min,Pair<String, Hotel> cheapestVendor, List<Pair<String, Hotel>> hotelsList) {
		for (Pair<String, Hotel> pair : hotelsList) {
			 
			 	if (pair.getValue().getPrice() < min) {
					min = pair.getValue().getPrice();
					cheapestVendor = pair;
				}
			 
		}
		return cheapestVendor;
	}
	
	
	
	 

}
