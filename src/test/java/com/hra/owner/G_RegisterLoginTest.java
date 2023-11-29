package com.hra.owner;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.ObjectRepo.LoginPage;
import com.ObjectRepo.OwnerHomePage;
import com.ObjectRepo.RegisterPage;
import com.ObjectRepo.WelcomePage;
import com.realestate.GenericUtils.ExcelUtils;
import com.realestate.GenericUtils.FileUtils;
import com.realestate.GenericUtils.JavaUtils;
import com.realestate.GenericUtils.WebdriverUtils;

public class G_RegisterLoginTest {
	@Test
	public  void RegisterLoginTest() throws Throwable {
		
		
		//create object 
		FileUtils fLib= new FileUtils();
		ExcelUtils eLib=new ExcelUtils();
		JavaUtils jLib = new JavaUtils();
		WebdriverUtils wLib = new WebdriverUtils();
				
				
		//	String BROWSER = fLib.readDataFromPropertyFile("browser");
		String URL = fLib.readDataFromPropertyFile("url");
		
		
		WebDriver driver=new ChromeDriver();
		wLib.maximizeWindow(driver);
		wLib.waitForImplicit(driver, 5);
		driver.get(URL);
		WelcomePage wp = new WelcomePage(driver);
		wp.register();
		RegisterPage rp=new RegisterPage(driver);

		rp.ownerReg(eLib.readMultipleData("OWNER_REG", driver), driver);
		
		rp.getLogin().click();
		LoginPage lp=new LoginPage(driver);
		lp.regLogin();
		
		OwnerHomePage ow=new OwnerHomePage(driver);
		ow.getLogout().click();
		
		
	}

}
