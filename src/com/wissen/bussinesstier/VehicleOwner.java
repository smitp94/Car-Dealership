package com.wissen.bussinesstier;

import java.util.HashMap;
import java.util.Map;

public class VehicleOwner {
	private String panCardNumber;
	private String ownerName;
	private String emailId;
	private Map<String,VehicleTO> vehicles;
	
	public VehicleOwner(){
		this.vehicles=new HashMap<>();
	}
	
	public VehicleOwner(String panCardNumber,String ownerName,String emailId){
		this.panCardNumber=panCardNumber;
		this.ownerName=ownerName;
		this.emailId=emailId;
		this.vehicles=new HashMap<>();
		
	}

	public String getPanCardNumber() {
		return panCardNumber;
	}

	public void setPanCardNumber(String panCardNumber) {
		this.panCardNumber = panCardNumber;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Map<String,VehicleTO> getVehicles() {
		return vehicles;
	}

	public void setVehicles(Map<String, VehicleTO> vehicles) {
		this.vehicles = vehicles;
	}
	
	
}
