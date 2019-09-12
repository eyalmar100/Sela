package sela.repository;

import org.springframework.data.repository.CrudRepository;

import sela.model.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, Long> {
	 
}
