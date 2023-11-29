package com.practice_Package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.jdbc.Driver;

public class RMGyantraTest {
public static void main(String[] args) throws SQLException {
	String ExpData="TY_Proj_0212";
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("http://rmgtestingserver:8084/");
	driver.findElement(By.name("username")).sendKeys("rmgyantra");
	driver.findElement(By.name("password")).sendKeys("rmgy@9999");
	driver.findElement(By.xpath("//button[text()='Sign in']")).click();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("//span[text()='Create Project']")).click();
	driver.findElement(By.name("projectName")).sendKeys("TY_Proj_0212");
	driver.findElement(By.name("createdBy")).sendKeys("Deepak H R");
	WebElement status = driver.findElement(By.name("status"));
	
	Select sel = new Select(status);
	sel.selectByVisibleText("Created");
	driver.findElement(By.xpath("//input[@value=\"Add Project\"]")).click();
	Connection con = null;
	try {
	Driver drive1=new Driver();
	DriverManager.registerDriver(drive1);
	con = DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
	Statement s = con.createStatement();
	String query = "select* from project;";
	
	 ResultSet result = s.executeQuery(query);
	boolean flag = false;
	while(result.next())
	{
		String actual = result.getString(4);
		if(actual.equalsIgnoreCase(ExpData))
		{
			flag=true;
				break;
		}
	}
	if (flag)
	{
		System.out.println("Project created successful");
	}
	else
	{
		System.out.println("Project not created ");
	}
	}
	catch(Exception e)
	{
		
	}
	finally {
	 con.close();
	}
	}

}
