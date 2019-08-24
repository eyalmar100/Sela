package sela.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import sela.model.Hotel;
import sela.service.HotelService;

@RestController
public class HotelController {

	public static final Logger logger = Logger.getLogger(HotelController.class);
	
	@Autowired
	private HotelService   hotelService; 
	
	
	@GetMapping({"/api/{hotel}"})
    public Hotel hotel(@PathVariable String hotel) {
        logger.info("HotelController): hotel hotel is : " + hotel);
        System.out.println("Vendor2:: HotelController): hotel hotel is : " + hotel);
        
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
       
        return hotelService.getHotelByName(hotel);
    }
	
}
