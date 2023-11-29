package com.practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Goibibo_Calender_Test {
	
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		driver.findElement(By.xpath("//div[text()='November 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='15']")).click();
		driver.findElement(By.xpath("//p[text()=' Click to add a return flight for better discounts']")).click();
		
		for(;;)
		{
			try {
				driver.findElement(By.xpath("//div[text()='March 2024']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='17']")).click();
				//driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
				break;
				
				
			}
			catch (Exception e) {
				driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
				//driver.findElement(By.xpath("//div[text()='March 2024']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='17']")).click();
				
			}
	
			
		}
		driver.findElement(By.xpath("//span[text()='Done']")).click();
	}

}
