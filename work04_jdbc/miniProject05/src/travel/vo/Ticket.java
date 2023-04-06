package travel.vo;

public class Ticket {

	private int id;
	private int cnt;
	private String ssn;
	private int flightId; // flight_id
	public Ticket(int id, int cnt, String ssn, int flightId) {
		super();
		this.id = id;
		this.cnt = cnt;
		this.ssn = ssn;
		this.flightId = flightId;
	}
	
	
	
	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getCnt() {
		return cnt;
	}



	public void setCnt(int cnt) {
		this.cnt = cnt;
	}



	public String getSsn() {
		return ssn;
	}



	public void setSsn(String ssn) {
		this.ssn = ssn;
	}



	public int getFlightId() {
		return flightId;
	}



	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}



	@Override
	public String toString() {
		return "Ticket [id=" + id + ", cnt=" + cnt + ", ssn=" + ssn + ", flightId=" + flightId + "]";
	}
	
	
}
