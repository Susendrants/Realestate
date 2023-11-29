package com.practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class SelectQueryTest {
    public static void main(String[] args) throws SQLException {
		//register the driver
    	Driver driver= new Driver();
    	DriverManager.registerDriver(driver);
    	//get connection
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root", "root");
    	//create statement
    	Statement st = con.createStatement();
    	String query = "select* from student;";
    	//execute query
    	ResultSet result = st.executeQuery(query);
    	while(result.next())
    	{
    		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
    	}
    	//close connection 
    	con.close();
	}
}
