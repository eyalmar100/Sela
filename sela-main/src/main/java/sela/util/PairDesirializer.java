package sela.util;

import org.json.JSONObject;

import javafx.util.Pair;
import sela.model.Hotel;

public class PairDesirializer {
   
	private final static String PAIR_VALUE="value";
	private final static String HOTEL_PRICE="price";
	
	public static int extractHotelPrice(String json) {
	     
		JSONObject jObject  = new JSONObject(json);
		JSONObject  hotel = jObject.getJSONObject(PAIR_VALUE);
		int price=hotel.getInt(HOTEL_PRICE);
		return price;
	}
	
	public static String prettifyString(Pair<String, Hotel> p) {
		 
		String vendorAddress=String.format("Vendor address is: %s", p.getKey()) ;
		String hotelPrice=String.format("Hotel price is: %d", p.getValue().getPrice());
		String newLineBrowser ="<br/>"; 
	//	String newLineConsole = System.getProperty("line.separator");
		return vendorAddress+newLineBrowser+hotelPrice;
		
		 
		
	}
	
}
