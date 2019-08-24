package sela.model;

public class Hotel {
	
	private int id;
	private String name;
	private String address;
	private int price;
	
	
	/*public Hotel(String name,String address,int price) {
		this.name=name;
		this.address=address;
		this.price=price;
	}*/
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
