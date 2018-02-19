package com.wissen.bussinesstier;

import java.util.Calendar;

import org.apache.log4j.Logger;


public class VehicleValidator {
	public Boolean isValidLicencePlateNumber(String  licencePlateNumber){
		//AADAADDDD
		
		if(licencePlateNumber.matches("^[A-Z]{2}[0-9]{1,2}[A-Z]{2}[0-9]{4}$")){
			return true;
		}else{
			return false;
		}
	}
	
	public Boolean isValidManufactureDate(Calendar manufactureDate){
		if(manufactureDate.before(Calendar.getInstance())){
			return true;
		}else{
			return false;
		}
	}
	
	public void validate(VehicleTO  vehicleTO) throws Exception{
		String errorStatus=null;
		if(!isValidLicencePlateNumber(vehicleTO.getLicencePlateNumber())){		
				errorStatus="VehicleValidator.INVALID_LICENCEPLATENUMBER";
		}
		else if(!isValidManufactureDate(vehicleTO.getManufactureDate())){ 
			errorStatus="VehicleValidator.INVALID_MANUFACTUREDATE";
		}
				
		
		if(errorStatus != null){
			Exception exception=new Exception(errorStatus);
			Logger logger=Logger.getLogger(this.getClass());
			
			logger.error(exception.getMessage(),exception);
			throw exception;

		}
	}

}
