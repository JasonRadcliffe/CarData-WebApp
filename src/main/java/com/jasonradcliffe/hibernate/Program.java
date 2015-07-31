package com.jasonradcliffe.hibernate;


import java.util.ArrayList;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class Program {
	
	//Checks the database for a user with the strings provided
	public static boolean isValidUser(String username, String password){
		
		//standard beginnings - using the username and pass for the database connection also		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(username, password);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Create array to hold all users
		ArrayList<User> userList = new ArrayList<User>();
		
		//Add in empty user
		User emptyUser = new User();
		userList.add(0, emptyUser);
		
		//Loops until the database has no value at the next index position
		boolean another = true;
		for(int index = 1; another; index++){
			User thisUser = (User)session.get(User.class, index);
			userList.add(index, thisUser);
			
			
			//Check the username and password, return true if it's a match
			if(thisUser.getUsername().equals(username))
				if(thisUser.getPassword().equals(password))
					return true;				
			
			
			
			if((User)session.get(User.class, index+1) == null ){
				another = false;
			}
			
		}
		
		
		

		
		
		
		session.close();
		
		return false;
		
		
		
	}
	
	
	public static void insertCar(String licensePlate, String make, String model, int modelYear, double odometerReading){
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(new String(), new String());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Car newCar = new Car(licensePlate, make, model, modelYear, odometerReading);
		
		session.save(newCar);
		
		session.getTransaction().commit();
		session.close();
		
		
	}
	
	
	public static void insertStation(String name, String location){
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(new String(), new String());		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		ServiceStation station = new ServiceStation();
		
		station.setName(name);
		station.setLocation(location);
		
		session.save(station);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
	
	public static void insertFillUp(int carID, int stationID, Date purchaseDate, double gallonsPurchased, boolean isFillUp,
			double tripMileage, double odometerReading, double cost){
		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(new String(), new String());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		FillUp fillUp = new FillUp();
		fillUp.setCarID(carID);
		fillUp.setStationID(stationID);
		fillUp.setPurchaseDate(purchaseDate);
		fillUp.setGallonsPurchased(gallonsPurchased);
		fillUp.setIsFillUp(isFillUp);
		fillUp.setTripMileage(tripMileage);
		fillUp.setOdometerReading(odometerReading);
		fillUp.setCost(cost);
		
		
		
		session.save(fillUp);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	
	
	public static void insertRepair(int carID, int stationID, Date purchaseDate, double odometerReading,
			double cost, String description, String mechanicName){
		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(new String(), new String());
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Repair repair = new Repair();
		repair.setCarID(carID);
		repair.setStationID(stationID);
		repair.setPurchaseDate(purchaseDate);
		repair.setOdometerReading(odometerReading);
		repair.setCost(cost);
		repair.setDescription(description);
		repair.setMechanicName(mechanicName);
		
		
		
		session.save(repair);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	
	public static ArrayList<Car> getCarsList(String user, String password){
		
		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(user, password);		
		Session session = sessionFactory.openSession();
		
		ArrayList<Car> list = new ArrayList();
		
		Car emptyCar = new Car();
		list.add(0, emptyCar);
		
		//Loops until there are no more cars in the car table
		boolean another = true;
		for(int index=1; another; index++){
			list.add(index, (Car)session.get(Car.class, index));
			if((Car)session.get(Car.class, index+1) == null ){
				another = false;
			}
		}
		
		session.close();
		
		return list;
		
	}
	
	
	//Gets the list of applicable stations. Contexts are:
		//Gas
		//Repair
		//All
	public static ArrayList<ServiceStation> getStationsList(String context, boolean recent){
	
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(new String(), new String());		
		Session session = sessionFactory.openSession();
		
		ArrayList<ServiceStation> allList = new ArrayList();
		
		ServiceStation emptyStation = new ServiceStation();
		allList.add(0, emptyStation);
		boolean another = true;
		int allIndex;
		for(allIndex=1; another; allIndex++){
			allList.add(allIndex, (ServiceStation)session.get(ServiceStation.class, allIndex));
			if((ServiceStation)session.get(ServiceStation.class, allIndex+1) == null ){
				another = false;
			}
		}
		boolean[] alreadyUsed = new boolean[allIndex+1];
		
		
		switch (context){
		case "Gas":
			ArrayList<ServiceStation> gasList = new ArrayList();
			gasList.add(0,emptyStation);
			another = true;
			
			for(int index=1; another; index++){
				FillUp fill = (FillUp)session.get(FillUp.class, index);
				if(!alreadyUsed[fill.getStationID()]){
					gasList.add(1, allList.get(fill.getStationID()) );
				}
				
				if((FillUp)session.get(FillUp.class, index+1) == null ){
					another = false;
				}
			}
			
			
			session.close();
			return gasList;
		
		case "Reapir":
			session.close();			
			return allList;
			
			
		default:
			session.close();
			return allList;
			
		
		}
		//Loops until there are no more cars in the car table
		
		
		
		
		
	}
	
	
	
}