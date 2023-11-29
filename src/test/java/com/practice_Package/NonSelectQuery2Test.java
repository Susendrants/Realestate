package com.practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery2Test {
public static void main(String[] args) throws SQLException {
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
	Statement st = con.createStatement();
	String query = "insert into student values('106','Bhuvan',3,0),('107','Somu',3,0);";
	int result = st.executeUpdate(query);
	if (result>=1)
	{
		System.out.println("success");
	}
	else
	{
		System.out.println("query error");
	}
	con.close();
}
}
