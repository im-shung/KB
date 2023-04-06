package travel.vo;

import java.sql.Date;

public class Flight {

	private int flightId; // flight_id
	private int price;
	private Date startTime; // start_time
	private Date arriveTime; //arrive_time
	private int startArea; //start_area
	private int arriveArea; //arrive_area
	private int quantity;
	

	public Flight(int flightId, int price, Date startTime, Date arriveTime, int startArea, int arriveArea,
			int quantity) {
		super();
		this.flightId = flightId;
		this.price = price;
		this.startTime = startTime;
		this.arriveTime = arriveTime;
		this.startArea = startArea;
		this.arriveArea = arriveArea;
		this.quantity = quantity;
	}


	public int getFlightId() {
		return flightId;
	}


	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public Date getStartTime() {
		return startTime;
	}


	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}


	public Date getArriveTime() {
		return arriveTime;
	}


	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}


	public int getStartArea() {
		return startArea;
	}


	public void setStartArea(int startArea) {
		this.startArea = startArea;
	}


	public int getArriveArea() {
		return arriveArea;
	}


	public void setArriveArea(int arriveArea) {
		this.arriveArea = arriveArea;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
