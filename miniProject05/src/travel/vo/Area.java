package travel.vo;

import java.sql.Date;

public class Area {

	private int areaCode; // area_code
	private int temperature;
	private Date areaTime; // area_time
	private int rainfall;

	public Area(int areaCode, int temperature, Date areaTime, int rainfall) {
		super();
		this.areaCode = areaCode;
		this.temperature = temperature;
		this.areaTime = areaTime;
		this.rainfall = rainfall;
	}
	public int getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}
	public int getTemperature() {
		return temperature;
	}
	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}
	public Date getAreaTime() {
		return areaTime;
	}
	public void setAreaTime(Date areaTime) {
		this.areaTime = areaTime;
	}
	public int getRainfall() {
		return rainfall;
	}
	public void setRainfall(int rainfall) {
		this.rainfall = rainfall;
	}
	@Override
	public String toString() {
		return "Area [areaCode=" + areaCode + ", temperature=" + temperature + ", areaTime=" + areaTime + ", rainfall="
				+ rainfall + "]";
	}
	
	
}
