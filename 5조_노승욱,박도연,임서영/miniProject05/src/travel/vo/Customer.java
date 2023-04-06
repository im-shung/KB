package travel.vo;

import java.util.ArrayList;

public class Customer {

	private String ssn;
	private String name;
	private int asset;
	private ArrayList<Ticket> tickets;
	
	public Customer(String ssn, String name, int asset, ArrayList<Ticket> tickets) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.asset = asset;
		this.tickets = tickets;
	}
	
	
	
	public Customer(String ssn, String name, int asset) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.asset = asset;
	}



	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAsset() {
		return asset;
	}
	public void setAsset(int asset) {
		this.asset = asset;
	}
	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(ArrayList<Ticket> tickets) {
		this.tickets = tickets;
	}
	@Override
	public String toString() {
		return "Customer [ssn=" + ssn + ", name=" + name + ", asset=" + asset + ", tickets=" + tickets + "]";
	}
	
	
	
}
