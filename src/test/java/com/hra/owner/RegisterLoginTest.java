package com.hra.owner;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.realestate.GenericUtils.ExcelUtils;
import com.realestate.GenericUtils.FileUtils;
import com.realestate.GenericUtils.WebdriverUtils;

public class RegisterLoginTest {
	public static void main(String[] args) throws Throwable  {
		
		FileUtils fLib= new FileUtils();
		ExcelUtils eLib=new ExcelUtils();
		WebdriverUtils wLib = new WebdriverUtils();
		
		String URL=fLib.readDataFromPropertyFile("url");
	
		//Launch the browser
		WebDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForImplicit(driver, 5);
		driver.get(URL);
		
		//Register for owner
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		
		eLib.readMultipleData("OWNER_REG", driver);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//Confirmation msg
		String con = "Registration successfull. Now you can login";
		WebElement act = driver.findElement(By.xpath("//div[text()='Registration successfull. Now you can login']"));
		String actual = act.getText();
		if(actual.equalsIgnoreCase(con))
		{
			System.out.println("Registration successfull");
		}
		else
		{
			System.out.println("Registration not successfull");
		}
		
		//Login
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(eLib.readDataFromExcel("OWNER_REG", 3, 1));
		driver.findElement(By.name("password")).sendKeys(eLib.readDataFromExcel("OWNER_REG", 4, 1));
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		
		//Logout
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
	}


}
