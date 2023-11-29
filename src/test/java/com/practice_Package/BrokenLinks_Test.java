package com.practice_Package;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks_Test {
public static void main(String[] args) throws IOException {
	WebDriver driver =new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.ksrtc.in/");
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
	List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	System.out.println(allLinks.size());
	ArrayList<String> list=new ArrayList<String>();
	for(int i=0; i<allLinks.size();i++)
	{
	   String eachLink = allLinks.get(i).getAttribute("href");
	   System.out.println(eachLink);
	//  URL url=null;
	  int statusCode=0;
	  try
	  {
	 URL  url = new URL(eachLink);
	   HttpsURLConnection urlconn= (HttpsURLConnection)url.openConnection();
	 statusCode= urlconn.getResponseCode();
	  if (statusCode>=400)
	  {
		  list.add(eachLink);
		  System.out.println(eachLink+"------>"+statusCode);
	  }
	 
	  }
	  catch(MalformedURLException e) {
		  System.out.println(eachLink+"------>"+statusCode);
	  }
	   
	}
	
}
}
