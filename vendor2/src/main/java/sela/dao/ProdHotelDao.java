package sela.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import sela.model.Hotel;
import sela.repository.VendorRepository;

@Component
@Profile("prod")
public class ProdHotelDao implements IHotelDao{

	@Autowired
	VendorRepository vendprRepository;
	
	@Override
	public Hotel getHotel(String name) {	
		List<Hotel>hotels=vendprRepository.findByName(name); 
		Hotel hotel=null;
		for(Hotel h:hotels) {
			if(h.getName().contains(name))
			hotel=h;
			break;
		}
		return hotel; 		 
	}

}
