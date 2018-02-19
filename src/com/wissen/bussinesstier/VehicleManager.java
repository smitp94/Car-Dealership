package com.wissen.bussinesstier;

import java.util.List;

import com.wissen.persistencetier.VehicleService;
import com.wissen.utility.AppConfig;

public class VehicleManager {
	public VehicleTO getVehicle(String licencePlateNumber){
		
		VehicleTO vehicleTO = new VehicleTO();
		VehicleService service=new VehicleService();
		try{			
		
			vehicleTO = service.getVehicle(licencePlateNumber);	
		
			return vehicleTO;
		}
		catch(Exception exception){			
			System.out.println(AppConfig.PROPERTIES.getProperty(exception.getMessage()));	
		}
		return null;
	}
	
	public String addNewVehicle(VehicleTO vehicleTO){
		
		VehicleValidator validator=new VehicleValidator();
		
		
		try{
			validator.validate(vehicleTO);
			VehicleService service=new VehicleService();
			return service.addNewVehicle(vehicleTO);
		}
		catch(Exception exception){
			exception.printStackTrace();
		}
				
		return "unable to add vehicle object to the database";
	} 
	
	public List<VehicleTO> getVehicles(){
		return new VehicleService().getVehicles();
	}
}
