package com.jasonradcliffe.hibernate;

import java.util.Date;

public class Repair {
	
	private int TransactionID;
	private int CarID;
	private int StationID;
	private Date PurchaseDate;
	private double OdometerReading;
	private double Cost;
	private String Description;
	private String MechanicName;
	
	public Repair(){
		
	}
	
	public Repair(int CarID, int StationID, Date PurchaseDate, double OdometerReading, double Cost, String Description, String MechanicName){
		this.setCarID(CarID);
		this.setStationID(StationID);
		this.setPurchaseDate(PurchaseDate);
		this.setOdometerReading(OdometerReading);
		this.setCost(Cost);
		this.setDescription(Description);
		this.setMechanicName(MechanicName);		
	}

	public int getTransactionID() {
		return TransactionID;
	}
	
	public void setTransactionID(int transactionID){
		TransactionID = transactionID;
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

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMechanicName() {
		return MechanicName;
	}

	public void setMechanicName(String mechanicName) {
		MechanicName = mechanicName;
	}
	

}







