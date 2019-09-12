package sela.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.*;

@Entity
public class Hotel {
	
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(nullable = false)
	@Getter   private Long id;
	
	
	@Getter @Setter	
	@Column(nullable = false)
	private String name;
	
	@Getter @Setter 
	@Column(nullable = false)
	private String address;
	
	@Getter @Setter 
	@Column(nullable = false)
	private int price;
	
	 @ManyToOne
	 @JoinColumn
	 @Getter @Setter
	 private Vendor vendor; 
	
	 
	 
	 
	 

}
