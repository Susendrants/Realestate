package com.practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Irctc_Calender_Test {
	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.irctc.co.in/");

		driver.findElement(By.xpath("//span[@class='ng-tns-c58-10 ui-calendar']/input")).click();
		
		driver.findElement(By.xpath("//div[@class=\"ui-datepicker-group ui-widget-content ng-tns-c58-10 ng-star-inserted\"]/descendant::a[text()='15']")).click();
		
	}

}
