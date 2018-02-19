package com.wissen.presentationtier;

import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.wissen.bussinesstier.VehicleManager;
import com.wissen.bussinesstier.VehicleOwner;
import com.wissen.bussinesstier.VehicleTO;

public class Tester {

	/**
	 * displays vehicle owner details include the vehicle details he owns
	 * @param vehicleOwner
	 */
	public static void showVehicleOwnerDetails(VehicleOwner vehicleOwner){
		System.out.println("Vehicle Owner Details...");
		System.out.println("Owner Name: "+ vehicleOwner.getOwnerName());
		System.out.println("PAN Card Number: "+ vehicleOwner.getPanCardNumber());
		System.out.println("Email Id: "+ vehicleOwner.getEmailId());
		
		Map<String,VehicleTO> vehicles= vehicleOwner.getVehicles();
		if(vehicles!=null){
			System.out.println("Details of the vehicles owned by "+ vehicleOwner.getOwnerName());
			for(Map.Entry<String,VehicleTO> entry: vehicles.entrySet()){
				System.out.println(entry.getValue());
			}
		}
		
		/*Iterator iterator = vehicles.entrySet().iterator();
		while(iterator.hasNext()){
			Map.Entry entry = (Map.Entry)iterator.next();
			System.out.println(entry.getValue());
		}*/
	}
	
	/**
	 * invokes getVehicle() of VehicleManager class
	 * @param licencePlateNumber
	 * @return
	 */
	public static VehicleTO getVehicle(String licencePlateNumber){
		VehicleManager manager=new VehicleManager();
		try{
			VehicleTO vehicleTO = manager.getVehicle(licencePlateNumber);
			return vehicleTO;
		}
		catch(Exception exception){
			exception.printStackTrace();
			throw exception;
		}                
	}
		
	public static void addNewVehicle(VehicleTO vehicleTO){
		VehicleManager manager= new VehicleManager();
		String message=manager.addNewVehicle(vehicleTO);
		System.out.println(message);
	}
	
	public static void getVehicles(){
		List<VehicleTO> vehicleList=new VehicleManager().getVehicles();
		
		System.out.println("Details of the vehicles...");
		Iterator<VehicleTO> iterator = vehicleList.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
	
	public static void main(String[] args) {
		/*try{
			Map<String,VehicleTO>  vehicles=new HashMap<>();
			VehicleTO vehicle1= Tester.getVehicle("999BH3675");
			VehicleTO vehicle2=Tester.getVehicle("AP93670");
			// add the above vehicle objects to HashMap
			if(vehicle1 != null){
				vehicles.put(vehicle1.getLicencePlateNumber(), vehicle1);
			}
			if(vehicle2!=null){
				vehicles.put(vehicle2.getLicencePlateNumber(), vehicle2);
			}
			
			VehicleOwner vehicleOwner=new VehicleOwner("ACCPA 9B", "Ravi Kumar","ravi2015@yahoo.co.in");
			if(vehicles!=null){
				vehicleOwner.setVehicles(vehicles);
			}
			Tester.showVehicleOwnerDetails(vehicleOwner);
		}
		catch(Exception exception){
			exception.printStackTrace();
		}*/
		
		
		/*VehicleTO vehicle1= Tester.getVehicle("AP09AH6372");
		System.out.println(vehicle1);
	*/	
		VehicleTO vehicleTO = new VehicleTO();
		vehicleTO.setLicencePlateNumber("99KA51CE367");
		vehicleTO.setMaker("Hyundai");
		vehicleTO.setModelName("i20");
		vehicleTO.setManufactureDate(new GregorianCalendar(2015,0,15));
		Tester.addNewVehicle(vehicleTO);
		
		//Tester.getVehicles();

	}

}
