package sela.controller;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static sela.controller.VendorController.HOTEL_NOT_FOUND_MESSAGE;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;

import javafx.util.Pair;
import junit.framework.TestCase;
import sela.model.Hotel;
import sela.service.HotelLookupService;
import sela.util.PairDesirializer;

@SuppressWarnings("restriction")
@RunWith(SpringRunner.class)
@WebMvcTest(VendorController.class)
public class VendorControllerTest extends TestCase {

   @Autowired
   private MockMvc mockMvc;
    
	@MockBean
    private HotelLookupService service;
	
	private static List<Pair<String, Hotel>> listHotels;
	
	
	@BeforeClass
	public static void beforeClass() throws JSONException {
	 	initHotelList();
 	}

	private static void initHotelList() {
		listHotels=new ArrayList<>();
		Hotel h=new Hotel();
		h.setName("sheraton");
		h.setAddress("http://somedomain.com");
		h.setPrice(120);
		Pair<String ,Hotel> pair=new Pair<>(h.getAddress(), h);
		listHotels.add(pair);
		
		Hotel h1=new Hotel();
		h1.setName("sheraton");
		h1.setAddress("http://otherdomain.com");
		h1.setPrice(200);
		Pair<String ,Hotel> pair1=new Pair<>(h.getAddress(), h1);
		listHotels.add(pair1);
	}
	 
	 
	@Test
	public void testMinHotelPriceList() throws Exception {
	   
		when(service.findAllHotels("sheraton")).thenReturn(listHotels);	
		ResultActions resultActions = mockMvc.perform(get("/api/sheraton")).andDo(print()).andExpect(status().isOk());
		MvcResult result = resultActions.andReturn();
		String contentAsString = result.getResponse().getContentAsString();
		int price=PairDesirializer.extractHotelPrice(contentAsString);
        assertEquals(120,price);
				
	}
	
	@Test
	public void testNoHotelFoundInList() throws Exception {
	   
		listHotels.removeAll(listHotels);
		when(service.findAllHotels("sheraton")).thenReturn(listHotels);		 	
		mockMvc.perform(get("/api/sheraton")).andDo(print()).andExpect(status().isOk())
        .andExpect(content().string(containsString(HOTEL_NOT_FOUND_MESSAGE)));
		 		
	}

}
