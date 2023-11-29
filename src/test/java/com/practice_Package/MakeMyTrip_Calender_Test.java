package com.practice_Package;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTrip_Calender_Test {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();;
	
	driver.get("https://www.makemytrip.com/");
	Thread.sleep(7000);
	//driver.findElement(By.xpath("//a[@class='close']")).click();
	
	Actions action = new Actions(driver);
	action.doubleClick().perform();
	//Thread.sleep(5000);
	driver.findElement(By.xpath("//span[text()='Departure']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//div[text()='November 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='16']")).click();
	System.out.println("ok");
	
	
}
}
