package com.practice_Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipKart_Test {
public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://www.flipkart.com/search?q=iphone+14+plus&sid=tyy%2C4io&as=on&as-show=on&otracker=AS_QueryStore_OrganicAutoSuggest_2_6_na_na_ps&otracker1=AS_QueryStore_OrganicAutoSuggest_2_6_na_na_ps&as-pos=2&as-type=RECENT&suggestionId=iphone+14+plus%7CMobiles&requestId=9ba7aef1-fd50-44a1-994a-97f43c689473&as-searchtext=iphone");
	List<WebElement> iphone = driver.findElements(By.xpath("//div[@class='col col-7-12']/child::div[@class='_4rR01T']"));
	List<WebElement> price = driver.findElements(By.xpath("//div[@class='col col-7-12']/child::div[@class='_4rR01T']/ancestor::div[@class='_3pLy-c row']//div[@class='_30jeq3 _1_WHN1']"));
	for(int i=0,j=0;i<iphone.size();i++,j++)
	{
		String ip = iphone.get(i).getText();
		String p= price.get(j).getText();
		System.out.println(ip +"--"+ p);
		
	}
}
}

