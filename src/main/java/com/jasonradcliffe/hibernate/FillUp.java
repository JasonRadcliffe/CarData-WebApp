package com.jasonradcliffe.hibernate;

import java.util.Date;

public class FillUp {
	private int PurchaseID;
	private int CarID;
	private int StationID;
	private Date PurchaseDate;
	private double GallonsPurchased;
	private boolean IsFillUp;
	private double TripMileage;
	private double OdometerReading;
	private double Cost;
	
	public FillUp(){
		
	}
	
	
	public FillUp(int carID, int stationID, Date purchaseDate, double gallonsPurchased,
			boolean isFillUp, double tripMileage, double odometerReading, double cost){
		this.setCarID(carID);
		this.setStationID(stationID);
		this.setPurchaseDate(purchaseDate);
		this.setGallonsPurchased(gallonsPurchased);
		this.setIsFillUp(isFillUp);
		this.setTripMileage(tripMileage);
		this.setOdometerReading(odometerReading);
		this.setCost(cost);
		
	}


	public int getPurchaseID() {
		return PurchaseID;
	}


	public void setPurchaseID(int purchaseID) {
		PurchaseID = purchaseID;
	}


	public int getCarID() {
		return CarID;
	}


	public void setCarID(int carID) {
		CarID = carID;
	}


	public int getStationID() {
		return StationID;
	}


	public void setStationID(int stationID) {
		StationID = stationID;
	}


	public Date getPurchaseDate() {
		return PurchaseDate;
	}


	public void setPurchaseDate(Date purchaseDate) {
		PurchaseDate = purchaseDate;
	}


	public double getGallonsPurchased() {
		return GallonsPurchased;
	}


	public void setGallonsPurchased(double gallonsPurchased) {
		GallonsPurchased = gallonsPurchased;
	}


	public boolean isIsFillUp() {
		return IsFillUp;
	}


	public void setIsFillUp(boolean isFillUp) {
		IsFillUp = isFillUp;
	}


	public double getTripMileage() {
		return TripMileage;
	}


	public void setTripMileage(double tripMileage) {
		TripMileage = tripMileage;
	}


	public double getOdometerReading() {
		return OdometerReading;
	}


	public void setOdometerReading(double odometerReading) {
		OdometerReading = odometerReading;
	}


	public double getCost() {
		return Cost;
	}


	public void setCost(double cost) {
		Cost = cost;
	}
	
	
	
	
	
	
	
	
}



