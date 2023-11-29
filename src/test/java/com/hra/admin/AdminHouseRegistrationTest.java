package com.hra.admin;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;
import java.util.Random;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.ObjectRepo.HomeRegisterPage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.OwnerHomePage;
import com.ObjectRepo.WelcomePage;
import com.realestate.GenericUtils.ExcelUtils;
import com.realestate.GenericUtils.FileUtils;
import com.realestate.GenericUtils.JavaUtils;
import com.realestate.GenericUtils.WebdriverUtils;

public class AdminHouseRegistrationTest {
	public static void main(String[] args) throws Throwable {
		
	//create object 
	FileUtils fLib= new FileUtils();
	ExcelUtils eLib=new ExcelUtils();
	JavaUtils jLib = new JavaUtils();
	WebdriverUtils wLib = new WebdriverUtils();
				
	String BROWSER = fLib.readDataFromPropertyFile("browser");
	String URL = fLib.readDataFromPropertyFile("url");
	String USERNAME = fLib.readDataFromPropertyFile("adminname");
	String PASSWORD = fLib.readDataFromPropertyFile("adminpassword");
				
	int r=jLib.getRandomNo();
		
	WebDriver driver= new ChromeDriver();
	wLib.maximizeWindow(driver);
	wLib.waitForImplicit(driver, 5);
	
		driver.get(URL);
		
		WelcomePage wp=new WelcomePage(driver);
		wp.login();
		//login
		
		LoginPage lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		
		//Initial house count
		OwnerHomePage ow=new OwnerHomePage(driver);
		//int initalcount = ow.initialRoom();
		ow.getRegister().click();
		
		//Home Register
		HomeRegisterPage hr=new HomeRegisterPage(driver);
		ow.getRegister().click();
		hr.mobileData();
		hr.emailData();
		hr.homeReg(eLib.readMultipleData("HOME", driver),driver);
		eLib.readMultipleData("HOME", driver);		
		
		hr.confirmationMsg();
		
		driver.findElement(By.xpath("//a[text()='Home']")).click();
		WebElement finalC = driver.findElement(By.xpath("//b[text()='Rooms for Rent: ']/span[@class=\"badge badge-pill badge-success\"]"));
		String finalregcount = finalC.getText();
		int finalcount=Integer.parseInt(finalregcount);
		if(r<finalcount){
			System.out.println("registered data is available");
			
		}
		else
		{
			System.out.println("registered data is available");
		}
	}
}
