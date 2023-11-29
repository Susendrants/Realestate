package com.practice_Package;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Icc_test {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.icc-cricket.com/rankings/mens/team-rankings/t20i");
		String countryName= "England";
	//	WebElement ele = driver.findElement(By.xpath("//span[.='"+countryName+"']/../following-sibling::td[1]"));
	//	System.out.println(ele.getText());
		List<WebElement> con = driver.findElements(By.xpath("//table/tbody/tr[*]/td[2]/span[2]"));
		boolean flag = false;
		for(WebElement webele : con)
		{
			String countryNames= webele.getText();
			if (countryNames.equals(countryName))
			{
				System.out.println("is present");
				flag=true;
				break;
			}
		}
		if(!flag)
		{
			System.out.println("not present");
		}
		
		}

}
