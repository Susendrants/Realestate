package com.practice_Package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WriteAndReadDatetoPropertyFileTest {
	public static void main(String[] args) throws IOException {
		//create object for Property class
		Properties pObj = new Properties();
		pObj.setProperty("browser", "chrome");
		pObj.setProperty("url","http://rmgtestingserver/domain/House_Rental_Application/");
		pObj.setProperty("username", "susee@gmail.com");
		pObj.setProperty("password","12345");
		
		FileOutputStream fout = new FileOutputStream(".\\src\\test\\resources\\CommonData.properties");
		pObj.store(fout, "Write the data");
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		String BROWSER=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String USERNAME=pObj.getProperty("username");
		String PASSWORD=pObj.getProperty("password");
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get(URL);
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("login")).click();
		
	}

}
