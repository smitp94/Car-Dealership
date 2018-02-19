package com.wissen.persistencetier;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.wissen.bussinesstier.VehicleTO;
import com.wissen.utility.MyOracleConnection;

public class VehicleService {
	public VehicleTO getVehicle(String licencePlateNumber) throws Exception{
		VehicleTO vehicleTO=new VehicleTO();
		Connection connection=null;
		PreparedStatement preparedstatement=null;
		ResultSet resultSet=null;
		try{
			connection=MyOracleConnection.getConnection();
			String sql="select licenceplatenumber,maker,modelname,manufacturedate from vehicle where licenceplatenumber=?";
			preparedstatement=connection.prepareStatement(sql);
			preparedstatement.setString(1, licencePlateNumber);
			resultSet = preparedstatement.executeQuery();
			if(resultSet.next()){
				vehicleTO.setLicencePlateNumber(resultSet.getString(1));
				vehicleTO.setMaker(resultSet.getString(2));
				vehicleTO.setModelName(resultSet.getString(3));
				// convert java.sql.Date to java.util.Date
				java.sql.Date  mdate = resultSet.getDate(4);				
				java.util.Date udate = new java.util.Date(mdate.getTime());
				// convert java.util.Date to java.util.Calendar
				java.util.Calendar cdate = Calendar.getInstance();
				
				cdate.setTime(udate);
				
				/*cdate.set(Calendar.YEAR, udate.getYear());
				cdate.set(Calendar.MONTH, udate.getMonth());
				cdate.set(Calendar.DATE,udate.getDate());*/
				vehicleTO.setManufactureDate(cdate);
				return vehicleTO;
			}else{
				System.out.println("Invalid Licenseplatenumber");
				return null;
			}
		}
		catch(SQLException exception){
			exception.printStackTrace();
			Logger logger=Logger.getLogger(VehicleService.class);
			logger.error(exception.getMessage());
		}
		catch(Exception exception){
			exception.printStackTrace();
			Logger logger=Logger.getLogger(VehicleService.class);
			logger.error(exception.getMessage());
			throw new Exception("VehicleValidator.INVALID_LICENCEPLATENUMBER");
		}
		finally{
			if(connection !=null){
				try {
					connection.close();
					resultSet.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
			}
		}
		return null;
	}
	
	public String addNewVehicle(VehicleTO vehicleTO){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String sql="insert into vehicle values(?,?,?,?)";
		try{
			connection=MyOracleConnection.getConnection();
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, vehicleTO.getLicencePlateNumber());
			preparedStatement.setString(2, vehicleTO.getMaker());
			preparedStatement.setString(3, vehicleTO.getModelName());
			
			Calendar calendar = vehicleTO.getManufactureDate();
			//convert java.util.Calendar to java.util.Date to java.sql.Date
			java.util.Date date =calendar.getTime();
			java.sql.Date sdate = new java.sql.Date(date.getTime());
			
			preparedStatement.setDate(4, sdate); 
			int n= preparedStatement.executeUpdate();
			if(n==1){
				return "1 vehicle object added to the database";
			}else {
				return "Unable to add vehicle object to the database";
			}
		}
		catch(SQLException exception){
			exception.printStackTrace();
			Logger logger=Logger.getLogger(VehicleService.class);
			logger.error(exception.getMessage());
		}
		catch(Exception exception){
			exception.printStackTrace();
			Logger logger=Logger.getLogger(VehicleService.class);
			logger.error(exception.getMessage());
		}
		finally{
			if(connection !=null){
				try {
					connection.close();					
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
			}
		}
		return "Unable to add vehicle object to the database";
	}
	
	public List<VehicleTO> getVehicles(){
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		List<VehicleTO> vehicleList=new ArrayList<>();
		try{
			connection = MyOracleConnection.getConnection();
			statement = connection.createStatement();
			resultSet=statement.executeQuery("select licenceplatenumber,maker,modelname,manufacturedate from vehicle");
			
			while(resultSet.next()){
				VehicleTO vehicleTO=new VehicleTO();
				
				vehicleTO.setLicencePlateNumber(resultSet.getString(1));
				vehicleTO.setMaker(resultSet.getString(2));
				vehicleTO.setModelName(resultSet.getString(3));
				java.sql.Date sdate=resultSet.getDate(4);
				java.util.Date udate=new java.util.Date(sdate.getTime());
				java.util.Calendar cdate = Calendar.getInstance();
				cdate.setTime(udate);
				vehicleTO.setManufactureDate(cdate);
				
				vehicleList.add(vehicleTO);				
			}
			return vehicleList;
		}
		catch(SQLException exception){
			exception.printStackTrace();
			Logger logger=Logger.getLogger(VehicleService.class);
			logger.error(exception.getMessage());
		}
		catch(Exception exception){
			exception.printStackTrace();
			Logger logger=Logger.getLogger(VehicleService.class);
			logger.error(exception.getMessage());
		}
		finally{
			if(connection !=null){
				try {
					connection.close();
					resultSet.close();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
				
			}
		}
		
		return null;
		
	}
	
	
}
