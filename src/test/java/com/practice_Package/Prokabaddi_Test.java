package com.practice_Package;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Prokabaddi_Test {
	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.prokabaddi.com/standings");
		String team="Puneri Paltan";
		List<WebElement> names = driver.findElements(By.xpath("//p[.='"+team+"']/ancestor::div[@class='row-head']"));
		for(int i=0; i<names.size();i++)
		{
			String teamname = names.get(i).getText();
			System.out.println(teamname);
		}
	}

}
