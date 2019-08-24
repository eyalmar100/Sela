package sela.service;

import java.util.concurrent.Callable;

import org.springframework.web.client.RestTemplate;

import javafx.util.Pair;
import sela.model.Hotel;

public class RestTemplateService implements Callable<Pair<String,Hotel>>{
	
	
	private RestTemplate restTemplate;
	private String url;
	
	public RestTemplateService (RestTemplate restTemplate,String url) {
		this.restTemplate=restTemplate;
		this.url=url;
		
	}

	public Pair<String,Hotel> call() throws Exception {
		Hotel hotel = restTemplate.getForObject(url, Hotel.class);
		return new Pair<>(url,hotel);
	}

}
