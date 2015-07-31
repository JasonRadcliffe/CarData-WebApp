package com.jasonradcliffe.hibernate;

import java.util.Date;

public class Car {
	
	private int CarID;
	private String LicensePlate;
	private String Make;
	private String Model;
	private int ModelYear;
	private double OdometerReading;
	
	
	public Car(){
		
	}
	
	public Car(String LicensePlate, String Make, String Model, int ModelYear, double OdometerReading){
		this.LicensePlate = LicensePlate;
		this.Make = Make;
		this.Model = Model;
		this.ModelYear = ModelYear;
		this.OdometerReading = OdometerReading;
	}
	
	
	public int getCarID() {
		return CarID;
	}
	public void setCarID(int carID) {
		CarID = carID;
	}


	public String getLicensePlate() {
		return LicensePlate;
	}


	public void setLicensePlate(String licensePlate) {
		LicensePlate = licensePlate;
	}


	public String getMake() {
		return Make;
	}


	public void setMake(String make) {
		Make = make;
	}


	public String getModel() {
		return Model;
	}


	public void setModel(String model) {
		Model = model;
	}


	public int getModelYear() {
		return ModelYear;
	}


	public void setModelYear(int modelYear) {
		ModelYear = modelYear;
	}


	public double getOdometerReading() {
		return OdometerReading;
	}


	public void setOdometerReading(double odometerReading) {
		OdometerReading = odometerReading;
	}
	
	

}
