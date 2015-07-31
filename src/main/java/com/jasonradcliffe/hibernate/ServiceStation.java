package com.jasonradcliffe.hibernate;

public class ServiceStation {
	private int StationID;
	private String Name;
	private String Location;
	
	public ServiceStation(){
		
	}
	
	public ServiceStation(String Name, String Location){
		this.Name = Name;
		this.Location = Location;
	}
	
	public int getStationID() {
		return StationID;
	}
	public void setStationID(int stationID) {
		StationID = stationID;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
	
	

}
