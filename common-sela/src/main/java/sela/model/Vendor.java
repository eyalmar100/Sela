package sela.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.*;

 
@Entity
public class Vendor {

	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Getter 
    @Column(nullable = false)
	private Long id;
	
	
	@Getter @Setter  
	@Column(nullable = false)
	private String name;
	
	@Getter @Setter   
	@Column(nullable = false)
	private String urlAddress;
	
	 @OneToMany(mappedBy = "vendor", cascade = CascadeType.ALL)
	 @Getter @Setter
	 @Column(nullable = false)
     private List<Hotel> hotelsList;
	 
	 

	 
	 
	

}
