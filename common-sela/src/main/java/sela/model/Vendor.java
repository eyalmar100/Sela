package sela.model;

import javafx.util.Pair;

public class Vendor {

	private String name;
	private Pair<String,Integer> urlAndHotelPrice;
	
	public Vendor(String name,Pair<String,Integer> urlAndHotelPrice) {
		this.name=name;
		this.setUrlAndHotelPrice(urlAndHotelPrice);
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Pair<String,Integer> getUrlAndHotelPrice() {
		return urlAndHotelPrice;
	}

	public void setUrlAndHotelPrice(Pair<String,Integer> urlAndHotelPrice) {
		this.urlAndHotelPrice = urlAndHotelPrice;
	}
	 
	

}
