package com.practice_Package;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.Random;

import java.util.Scanner;



import com.mysql.cj.jdbc.Driver;

import com.mysql.cj.xdevapi.Result;



public class AmarSqlTest {

	public static void main(String[] args) throws Throwable

	{

		Random ran = new Random();

		int ram=ran.nextInt(100);

		Driver driver= new Driver();

		DriverManager.registerDriver(driver);

		Connection c=  DriverManager.getConnection("jdbc:mysql://localhost:3306/EMPLOYEE","root","root");

		Statement st =c.createStatement();

		Scanner s= new Scanner(System.in);

	  System.out.println("Enter your name ");
	   String name = s.next();

		String query= "SELECT * FROM EMPLOYENAMEANDAGE;";

	 ResultSet result= st.executeQuery(query);

	  boolean flag=false;

	 while (result.next())

		 {

		

		if(!result.getString(1).equalsIgnoreCase(name)) 

		{

			flag=true;

			
          break;
			

		}

		

		

		

		 

		 c.close();

		 

		 

	 }

		
if (flag)

{

	  String query1="INSERT INTO EMPLOYENAMEANDAGE VALUES('"+name+"','"+ram+"');";
   st.executeUpdate(query1);


}

else 

{

	

System.out.println("name is already present in the table");
}
}
}