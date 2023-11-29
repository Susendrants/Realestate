package com.practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;



public class EmpNameTest {
public static void main(String[] args) throws SQLException {
	Connection con=null;
	Random r=new Random();
	int age = r.nextInt(100);
	Scanner s= new Scanner(System.in);
	System.out.println("Enter your name");
	String ename=s.nextLine();
	try {
	Driver driver = new Driver();
	DriverManager.registerDriver(driver);
	
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/emp","root", "root");
	
	Statement st = con.createStatement();
	String q1="select empname from emp;";
	
	 ResultSet result = st.executeQuery(q1);
	 while(result.next())
	 {
		String name = result.getString(1);
		if(name.equals(ename))
		{
			System.out.println("The data is already present");
		}
		else
		{     
			
			PreparedStatement stmt=con.prepareStatement("insert into emp values(?,?)"); 
			stmt.setString(1,ename);
			stmt.setInt(2, age);
			stmt.executeUpdate();
			System.out.println("Data stored in the DB");
		}
		
		
	 }
	 }
	catch(Exception e)
	{
		System.out.println(" ");
	}
	finally
	{
	 
	      con.close();
	}
	 
		
}
}
