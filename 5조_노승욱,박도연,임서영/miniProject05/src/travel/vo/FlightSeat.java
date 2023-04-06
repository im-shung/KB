package travel.vo;

public class FlightSeat {
	private int flightId;
	private int restSeat;
	
	public FlightSeat(int flightId, int restSeat) {
		super();
		this.flightId = flightId;
		this.restSeat = restSeat;
	}
	@Override
	public String toString() {
		return "FlightSeat [flightId=" + flightId + ", restSeat=" + restSeat + "]";
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public int getRestSeat() {
		return restSeat;
	}
	public void setRestSeat(int restSeat) {
		this.restSeat = restSeat;
	}
	
	
}
