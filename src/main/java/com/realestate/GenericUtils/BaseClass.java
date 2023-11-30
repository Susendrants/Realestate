package com.realestate.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.ObjectRepo.LoginPage;
import com.ObjectRepo.OwnerHomePage;
import com.ObjectRepo.WelcomePage;
import com.beust.jcommander.Parameter;

public class BaseClass {
	
	public DatabaseUtils dLib = new DatabaseUtils();
	public FileUtils fLib = new FileUtils();
	public ExcelUtils eLib = new ExcelUtils();
	public WebdriverUtils wLib = new WebdriverUtils();
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void conf_BS() throws Throwable
	{
		dLib.connectDB();
		System.out.println("DB CONNECTED");
	}
//	@Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void conf_BC() throws Throwable
	{
        String BROWSER = fLib.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("--CHROME BROWSER LAUNCHED---");
			Thread.sleep(15000);
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
			System.out.println("--EDGE BROWSER LAUNCHED---");
		}
		else
		{
			System.out.println("INVALID BROWSER");
		}
		sdriver=driver;
		
	}
	@BeforeMethod(alwaysRun = true)
	public void conf_BM() throws Throwable
	{
	String URL =	fLib.readDataFromPropertyFile("url");
	String USERNAME = fLib.readDataFromPropertyFile("username");
	String PASSWORD = fLib.readDataFromPropertyFile("password");
	
	wLib.maximizeWindow(driver);
	wLib.waitForImplicit(driver, 5);
	
	driver.get(URL);
	LoginPage lp=new LoginPage(driver);
	WelcomePage wp=new WelcomePage(driver);
	wp.getLoginlink().click();
	lp.Login(USERNAME, PASSWORD);
	
	System.out.println("--LOGIN TO APPLICATION--");
	}
	
	@AfterMethod(alwaysRun = true)
	public void conf_AM()
	{
		OwnerHomePage ow=new OwnerHomePage(driver);
		ow.getLogout().click();
		System.out.println("--LOGGED OUT TO APPLICATION--");
				
	}
	
	@AfterClass(alwaysRun = true)
	public void conf_AC()
	{
		driver.quit();
		System.out.println("--BROWSER CLOSED--");
	}
	
	@AfterSuite(alwaysRun = true)
	public void conf_AS() throws Throwable
	{
		dLib.disconnectDB();
		System.out.println("--DB DISCONNECTED--");
	}
	
	

}
