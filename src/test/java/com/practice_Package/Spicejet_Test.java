package com.practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Spicejet_Test {
public static void main(String[] args) throws InterruptedException {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.spicejet.com/");
	driver.findElement(By.xpath("//div[@data-testid='round-trip-radio-button'] ")).click();
	driver.findElement(By.xpath("//div[text()='From']")).click();
	driver.findElement(By.xpath("//div[text()='India']")).click();
	driver.findElement(By.xpath("//div[text()='Agra']")).click();
	//driver.findElement(By.xpath("//div[text()='To']")).click();
	//driver.findElement(By.xpath("//div[text()='India']")).click();
	driver.findElement(By.xpath("//div[text()='Delhi']")).click();
	driver.findElement(By.xpath("//div[@data-testid=\"undefined-month-November-2023\"]/descendant::div[@data-testid=\"undefined-calendar-day-17\"]")).click();
	driver.findElement(By.xpath("//div[@data-testid=\"undefined-month-December-2023\"]//div[@data-testid=\"undefined-calendar-day-14\"]")).click();
	driver.findElement(By.xpath("//div[@data-testid=\"home-page-flight-cta\"]")).click();
	driver.findElement(By.xpath("//div[text()='Passengers']")).click();

	driver.findElement(By.xpath("//div[@data-testid=\"Adult-testID-plus-one-cta\"]")).click();
	
  //  driver.findElement(By.xpath("//div[@data-testid=\"home-page-travellers-done-cta\"]")).click();
  
	driver.findElement(By.xpath("//div[text()='Currency']")).click();
	driver.findElement(By.xpath("//div[@class=\"css-1dbjc4n r-1habvwh r-1loqt21 r-1777fci r-1mi0q7o r-1yt7n81 r-m611by r-1otgn73\"]//div[.='INR']")).click();
	driver.findElement(By.xpath("//div[text()='Students']")).click();
	//driver.findElement(By.xpath("//div[@data-testid=\"home-page-travellers-done-cta\"]")).click();
}
}
