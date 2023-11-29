package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertTest {
	@Test
	public void hardAssert_1()
	{
		String exp="App";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		String act = driver.getTitle();
		Assert.assertEquals(act, exp, "exp is not found");
		System.out.println(act);
		
	}
	@Test
	public void hardAssert_2()
	{
		String a = "26";
		System.out.println("-----s------");
		System.out.println("-----u------");
		System.out.println("-----s------");
		System.out.println("-----e------");
		Assert.assertNull(a);
		System.out.println("-----2------");
		System.out.println("-----6------");
			
	}
	
	public void hardAssert_3()
	{
		String a = "26";
		System.out.println("-----s------");
		System.out.println("-----u------");
		System.out.println("-----s------");
		System.out.println("-----e------");
		Assert.assertNull(a);
		System.out.println("-----2------");
		System.out.println("-----6------");
			
	}
}
