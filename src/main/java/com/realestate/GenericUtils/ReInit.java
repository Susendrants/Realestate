package com.realestate.GenericUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class ReInit {
    
	public WebdriverUtils wLib = new WebdriverUtils();
	public FileUtils fLib = new FileUtils();
	public WebDriver driver;
public static WebDriver sdriver;
	
	
	
	@BeforeClass(alwaysRun = true)
	public void reinitbrowser() throws Throwable
	{
        String BROWSER = fLib.readDataFromPropertyFile("browser");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
			System.out.println("--CHROME BROWSER LAUNCHED---");
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
	@AfterClass(alwaysRun = true)
	public void conf_AC()
	{
		driver.quit();
		System.out.println("--BROWSER CLOSED--");
	}
	
}
