package com.practice_Package;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Amazon_Test {
	public static void main(String[] args) {
	WebDriver driver= new EdgeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.amazon.in/");
	WebElement search = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
	search.sendKeys("google pixel");
	search.sendKeys(Keys.ENTER);
	List<WebElement> iphone = driver.findElements(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']"));
	List<WebElement> price = driver.findElements(By.xpath("//span[@class='a-price-whole']"));
	//ArrayList<Object> al=new ArrayList<Object>();
	for(int i=0,j=0;i<iphone.size();i++,j++)
	{
	String ip = iphone.get(i).getText();
	String p= price.get(j).getText();
	String mprice=p.replace(",","");
	int pr=Integer.parseInt(mprice);
	if(pr<=60000)
	{
		System.out.println(ip +"----"+ pr);
	}
	
	
	}
		
			
	}
	}
	
	
	
	

