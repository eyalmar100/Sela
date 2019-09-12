package sela.util;

import java.util.Comparator;

import org.springframework.stereotype.Component;

import javafx.util.Pair;
import sela.model.Hotel;
import lombok.*;

 

public class PairComarator implements Comparator<Pair<String, Hotel>>{

	@SuppressWarnings("null")
	@Override
	public int compare(Pair<String, Hotel> p1, Pair<String, Hotel> p2) {
		if(p1.getValue()==null || p2.getValue()==null)
			return (Integer) null;
	 	return  Integer.compare(p1.getValue().getPrice(), p2.getValue().getPrice());
	}
	
	 
	 
	 

}
