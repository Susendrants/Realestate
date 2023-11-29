package com.practice_Package;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Icc_NameMatchPoint_Test {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		List<WebElement> con = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/span[2]"));
		List<WebElement> matchs = driver.findElements(By.xpath("//table/tbody/tr[*]/td[3]"));
		List<WebElement> points = driver.findElements(By.xpath("//table/tbody/tr[*]/td[4]"));
		//ArrayList<String> table=new ArrayList<String>();
		
		for(int i=0,j=0,z=0; i<con.size();i++,j++,z++)
		{
			String c = con.get(i).getText();
			String m = matchs.get(j).getText();
			String p = points.get(z).getText();
			System.out.println("Team :"+ c +" Matches :"+ m +" Points :"+ p);
			
		}
	        
	}

}
