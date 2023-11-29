package com.TestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DpTest {
	@DataProvider
	public Object[][] data()
	{
		Object [][] obj=new Object[4][3];
		obj[0][0]="Chennai";
		obj[0][1]="Bangalore";
		obj[0][2]=700;
		
		obj[1][0]="Mysore";
		obj[1][1]="Pune";
		obj[1][2]=500;
		
		obj[2][0]="Mumbai";
		obj[2][1]="Goa";
		obj[2][2]=600;
		
		obj[3][0]="Coimbatore";
		obj[3][1]="Mysore";
		obj[3][2]=800;
		
		return obj;
	}
	
	@DataProvider
	public Object[][] store()
	{
		Object[][] obj=new Object[2][2];
		obj[0][0]="Bangalore";
		obj[0][1]="Hyderabad";
		
		obj[1][0]="coimbatore";
		obj[1][1]="Mysore";
		
		return obj;
		
	}
	
	@Test(dataProvider = "data" )
	public void book(String from,String to,int price)
	{
		System.out.println("From---> "+from+" To--> "+to+" Price :"+price);
	}
	

}
