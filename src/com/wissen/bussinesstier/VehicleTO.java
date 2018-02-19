package com.wissen.bussinesstier;

import java.util.Calendar;

public class VehicleTO {
	private String licencePlateNumber;
	public String maker;
	public String modelName;
	private Calendar manufactureDate;
	
	public VehicleTO(){
		
	}
	
	public VehicleTO(String licencePlateNumber,String maker,String modelName,Calendar manufactureDate){
		this.licencePlateNumber=licencePlateNumber;
		this.maker=maker;
		this.modelName=modelName;
		this.manufactureDate=manufactureDate;			
	}

	public String getLicencePlateNumber() {
		return licencePlateNumber;
	}

	public void setLicencePlateNumber(String licencePlateNumber) {
		this.licencePlateNumber = licencePlateNumber;
	}

	public String getMaker() {
		return maker;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public Calendar getManufactureDate() {
		return manufactureDate;
	}

	public void setManufactureDate(Calendar manufactureDate) {
		this.manufactureDate = manufactureDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((licencePlateNumber == null) ? 0 : licencePlateNumber
						.hashCode());
		result = prime * result + ((maker == null) ? 0 : maker.hashCode());
		result = prime * result
				+ ((manufactureDate == null) ? 0 : manufactureDate.hashCode());
		result = prime * result
				+ ((modelName == null) ? 0 : modelName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VehicleTO other = (VehicleTO) obj;
		if (licencePlateNumber == null) {
			if (other.licencePlateNumber != null)
				return false;
		} else if (!licencePlateNumber.equals(other.licencePlateNumber))
			return false;
		if (maker == null) {
			if (other.maker != null)
				return false;
		} else if (!maker.equals(other.maker))
			return false;
		if (manufactureDate == null) {
			if (other.manufactureDate != null)
				return false;
		} else if (!manufactureDate.equals(other.manufactureDate))
			return false;
		if (modelName == null) {
			if (other.modelName != null)
				return false;
		} else if (!modelName.equals(other.modelName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		String mDate=this.manufactureDate.get(Calendar.DATE)+"-"+(this.manufactureDate.get(Calendar.MONTH)+1)+"-"+this.manufactureDate.get(Calendar.YEAR);
		return "VehicleTO [licencePlateNumber=" + licencePlateNumber
				+ ", maker=" + maker + ", modelName=" + modelName
				+ ", manufactureDate=" + mDate + "]";
	}

	
	
	
}
