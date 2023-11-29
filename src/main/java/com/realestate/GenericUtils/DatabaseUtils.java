package com.realestate.GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils {
   Connection con =null;
   public void connectDB() throws Throwable
   {
	   Driver driver= new Driver();
	   DriverManager.registerDriver(driver);
	   con=DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DB_Username, IpathConstants.DB_Password);
	   
   }
   public String executeAndGetData(int colData, String ExpData) throws Exception
   {
	   Statement state = con.createStatement();
	   String query="Select* from emp";
	   ResultSet result = state.executeQuery(query);
	   boolean flag=false;
	   while(result.next())
	   {
		   String actual = result.getString(colData);
		   if(actual.equalsIgnoreCase(ExpData))
		   {
			   flag=true;
			   break;
		   }
	   }
        if(flag)
        {
        	System.out.println("project created successfully");
        	return ExpData;
        }
        else
        {
        	System.out.println("project is not created ");
        	return "";
        }
   
   }
   public void disconnectDB() throws Throwable
   {
	     con.close();
   }
   

}
