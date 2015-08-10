package com.jasonradcliffe.hibernate;


import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;



public class Program {
	
	
	//TODO: Plug the real db info back in to avoid throwing an exception on the 
	//getSessionFactory(u, p) method.
	
	//Checks the database for a user with the strings provided
	public static boolean isValidUser(String username, String password){
		
		//standard beginnings - using the username and pass for the database connection also		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(username, password);
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//uses HQL instead of SQL
		Query query = session.createQuery("from User");
		@SuppressWarnings("unchecked")
		List<User> userList = (List<User>)query.list();
		
		//loops through User table and checks first username, then password.
		for(int index=0; index < userList.size(); index++){
			String currentUsername = (String)userList.get(index).getUsername();
			if(currentUsername.equals(username)){
				String currentPassword = (String)userList.get(index).getPassword();
				if(currentPassword.equals(password)){
					session.close();
					return true;
				}
				
			}
		}
		
		//failure condition, didn't find a user in the table that matched the parameters
		session.close();
		return false;
	}
	
	
	public static void insertCar(String user, String password, String licensePlate,
			String make, String model, int modelYear, double odometerReading){
		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(user, password);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Car newCar = new Car(licensePlate, make, model, modelYear, odometerReading);
		
		session.save(newCar);
		
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public static List<Car> viewCars(String user, String password){
		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(user, password);		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Car");
		List<Car> data  = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return data;
	}
	
	
	public static void insertStation(String user, String password, String name, String location){
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(user, password);		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		ServiceStation station = new ServiceStation();
		
		station.setName(name);
		station.setLocation(location);
		
		session.save(station);
		
		session.getTransaction().commit();
		session.close();
	}
	
	
@SuppressWarnings("unchecked")
public static List<ServiceStation> viewStations(String user, String password){
		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(user, password);		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		Query query = session.createQuery("from ServiceStation");
		List<ServiceStation> data  = query.list();
		
		session.getTransaction().commit();
		session.close();
		
		return data;
	}
	
	
	
	public static void insertFillUp(String user, String password, int carID, int stationID, Date purchaseDate, double gallonsPurchased,
			boolean isFillUp, double tripMileage, double odometerReading, double cost){
		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(user, password);
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		//Run a query to get the car the fillup is on
		Query carQuery = session.createQuery("from Car where CarID = "  + carID);
		Car thisCar = (Car)carQuery.uniqueResult();
		
		FillUp fillUp = new FillUp();
		fillUp.setCarID(carID);
		
		if(isFillUp){
			//Figure out if the trip mileage they gave matches
			double calculatedTripMileage = odometerReading - thisCar.getOdometerReading();
			
			if( Math.abs(tripMileage - calculatedTripMileage) > 1.1  ){
				//must have missed something, use their trip mileage
				fillUp.setTripMileage(tripMileage);
				fillUp.setOdometerReading(odometerReading);
				
			}
			else{
				//the values are super close. Use the odometer reading
				fillUp.setTripMileage(calculatedTripMileage);
				fillUp.setOdometerReading(odometerReading);
			}
			
			
		}
		
		//Setting the car's odometer to what they entered in the fill-up
		thisCar.setOdometerReading(odometerReading);
		
		
		fillUp.setStationID(stationID);
		fillUp.setPurchaseDate(purchaseDate);
		fillUp.setGallonsPurchased(gallonsPurchased);
		fillUp.setIsFillUp(isFillUp);
		
		fillUp.setCost(cost);
		
		
		//saving both the car and the fill-up
		session.save(thisCar);
		session.save(fillUp);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	
	
	
	public static void insertRepair(String user, String password, int carID, int stationID, Date purchaseDate,
			double odometerReading,	double cost, String description, String mechanicName){
		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(user, password);
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
	
	
	
	@SuppressWarnings("unchecked")
	public static List<Car> getCarsList(String user, String password){
		
		
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(user, password);		
		Session session = sessionFactory.openSession();
		
		//HQL query runs and returns entire Car table - does not need IDs to be sequential
		Query query = session.createQuery("from Car");
		List<Car> carList = query.list();
		
		session.close();
		
		return carList;
		
	}
	
	
	//Gets the list of  stations
	@SuppressWarnings("unchecked")
	public static List<ServiceStation> getStationsList(String user, String password){
	
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(user, password);		
		Session session = sessionFactory.openSession();
		
		//HQL query runs and returns entire ServiceStation table - does not need IDs to be sequential
		Query query = session.createQuery("from ServiceStation");
		List<ServiceStation> stationList = query.list();
		
		session.close();
		
		return stationList;
		
	}
	
	/*++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	//TODO: impliment selective stationlist getting based on contexts:
	 * Gas
	 * Repair
	 * All
	public static ArrayList<ServiceStation> getStationsList(String user, String password){
	
		SessionFactory sessionFactory = HibernateUtilities.getSessionFactory(user, password);		
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
		+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++=
	}
	
	
	*/
	
	
	
}