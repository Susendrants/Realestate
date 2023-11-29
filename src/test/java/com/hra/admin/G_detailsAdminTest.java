package com.hra.admin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepo.DetailsPage;
import com.ObjectRepo.HomeRegisterPage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.OwnerHomePage;
import com.ObjectRepo.WelcomePage;
import com.realestate.GenericUtils.ExcelUtils;
import com.realestate.GenericUtils.FileUtils;
import com.realestate.GenericUtils.JavaUtils;
import com.realestate.GenericUtils.WebdriverUtils;

public class G_detailsAdminTest {
	@Test
	public  void detailsAdminTest(String[] args) throws Throwable {
		//create object 
		FileUtils fLib= new FileUtils();
		ExcelUtils eLib=new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
		WebdriverUtils wLib = new WebdriverUtils();
		
		
//		String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		String USERNAME = fLib.readDataFromPropertyFile("adminname");
		String PASSWORD = fLib.readDataFromPropertyFile("adminpassword");
		
		int r=jLib.getRandomNo();
			
		//Launch the browser	
		WebDriver driver= new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForImplicit(driver, 5);
		
		driver.get(URL);
		WelcomePage wp=new WelcomePage(driver);
		wp.login();
		//login
		
		LoginPage lp=new LoginPage(driver);
		lp.Login(USERNAME, PASSWORD);
		
		OwnerHomePage ow=new OwnerHomePage(driver);
		HomeRegisterPage hr=new HomeRegisterPage(driver);   
		
		
		ow.getRegister().click();
		String mon = hr.mobileData();
		hr.emailData();
		hr.homeReg(eLib.readMultipleData("HOME", driver), driver);
		eLib.readMultipleData("HOME", driver);		
		
		hr.confirmationMsg();
		
		ow.getUpdates().click();
		DetailsPage dp=new DetailsPage(driver);
		dp.validate(driver, mon);
		
		
	}
}
