package sela.repository;

 
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import sela.model.Hotel;
import sela.model.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, Long> {
	 	List<Hotel> findByName(String name);
}
