package com.practice_Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Oly_Test {
public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
	String country="Brazil";
	List<WebElement> cnames = driver.findElements(By.xpath("//div[@class='styles__CountryWrapper-sc-fehzzg-4 hjfJyH']"));
	List<WebElement> gold = driver.findElements(By.xpath("//div[@title='Gold']"));
	List<WebElement> silver = driver.findElements(By.xpath("//div[@title='Silver']"));
	List<WebElement> bronze = driver.findElements(By.xpath("//div[@title='Bronze']"));
	List<WebElement> total = driver.findElements(By.xpath("//div[contains(@data-medal-id,'total-medals-row')]"));
	for(int i=0,j=0,k=0,l=0,m=0; i<cnames.size(); i++,j++,k++,l++,m++)
	{
		String teamname = cnames.get(i).getText();
		String cgold = gold.get(j).getText();
		String csilver = silver.get(k).getText();
		String cbronze = bronze.get(l).getText();
		String tp = total.get(m).getText();
		if(country.equals(teamname))
		{
			System.out.println("Country="+ teamname +" Gold=" + cgold + " Silver="+ csilver + " Bronze="+ cbronze +" Points="+ tp);
		}
	
}
}	
}

