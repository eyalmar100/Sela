package sela.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

import javafx.util.Pair;
import sela.model.Hotel;
import sela.util.PairComarator;

@SuppressWarnings("restriction")
public class MinStreamTest {

	List<Pair<String, Hotel>> hotelsList;
	PairComarator pairComarator; 
	
	
	
	
	@Before
	public void setUp() throws Exception {
		initHotelList();
		pairComarator=new PairComarator();
		 
	}
	
	
	@SuppressWarnings("restriction")
	private void initHotelList() {
    	 hotelsList=new ArrayList<>();
		 Hotel hotel1=new Hotel();
		 hotel1.setName("Hilton");
		 hotel1.setAddress("Some Url");
		 hotel1.setPrice(20); 
		 Pair<String ,Hotel> pair1=new Pair<>("SomeVendorUrlAddress", hotel1);
		 hotelsList.add(pair1);
		 
		 Hotel hotel2=new Hotel();
		 hotel2.setName("Sheraton");
		 hotel2.setAddress("Other Url2");
		 hotel2.setPrice(120); 
		 pair1=new Pair<>("SomeVendorUrlAddress2", hotel2);
		 hotelsList.add(pair1);
		 
		 
		 Hotel hotel3=new Hotel();
		 hotel3.setName("Herodes");
		 hotel3.setAddress("Other Url3");
		 hotel3.setPrice(12); 
		 pair1=new Pair<>("SomeVendorUrlAddress3", hotel3);
		 hotelsList.add(pair1);
		 
		
	}


	@Test
	public void testMinStream() {
		 System.out.println("MinStreamTest.testMinStream()");
		 Stream<Pair<String, Hotel>> str=hotelsList.stream();
		 Pair<String, Hotel> minPair=str.min(pairComarator).orElse(new Pair<>("Requeted Hotel not Found ",null));
		 assertEquals(12, minPair.getValue().getPrice()); 
	 	}
	
	
	@Test
	public void testNullStream() {
		hotelsList.removeAll(hotelsList);
		Stream<Pair<String, Hotel>> str=hotelsList.stream();
		Pair<String, Hotel> minPair=str.min(pairComarator).orElse(new Pair<>("Requeted Hotel not Found ",null));
		assertEquals("Requeted Hotel not Found",minPair.getKey());
	}

}
