package sela.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import javax.annotation.PreDestroy;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javafx.util.Pair;
import sela.model.Hotel;

@Service
public class HotelLookupService {
	private static final Logger logger = Logger.getLogger(HotelLookupService.class);

	@Value("${vendor.url}")
	private List<String> vendorslist;

	private final RestTemplate restTemplate;

	@Autowired
	private ThreadPoolTaskExecutor excecutor;

	public HotelLookupService(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public List<Pair<String, Hotel>> findAllHotels(String hotelName) {

		List<Future<Pair<String, Hotel>>> hotelList = new ArrayList<>();
		for (String url : vendorslist) {
			url += hotelName;
			RestTemplateService restService = new RestTemplateService(restTemplate, url);
			hotelList.add(excecutor.submit(restService));
		}
		List<Pair<String, Hotel>> listOfPairs = addHotelToList(hotelList);
		return listOfPairs;

	}

	private List<Pair<String, Hotel>> addHotelToList(List<Future<Pair<String, Hotel>>> hotelList) {
		List<Pair<String, Hotel>> listOfPairs = new ArrayList<>();
		for (Future<Pair<String, Hotel>> p : hotelList) {
			try {
				Hotel currHotel = p.get().getValue();
				if (currHotel != null)
					listOfPairs.add(p.get());
			} catch (InterruptedException | ExecutionException e) {
				System.out.println(String.format("Error during connection: %s", e));

			}

		}
		return listOfPairs;
	}

	@PreDestroy
	public void destroy() {
		excecutor.shutdown();
	}

}
