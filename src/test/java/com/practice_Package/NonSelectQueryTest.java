package com.practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQueryTest {
	public static void main(String[] args) throws Throwable {
		//register the driver
		Driver driver= new Driver();
		DriverManager.registerDriver(driver);
		//get connection
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
		//create statement
		Statement st = con.createStatement();
		String query = "insert into student values('105','Sureshwar',5,1);";
		//executeUpdate query
		int result = st.executeUpdate(query);
		if (result==1)
		{
			System.out.println("Data inserted successfully");
		}
		else
		{
			System.out.println("Data not inserted");
		}
		//close connection
		con.close();
	}
	
	
	
}
