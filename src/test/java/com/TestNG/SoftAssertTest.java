package com.TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void soft()
	{
		String exp="app";
		SoftAssert sa = new SoftAssert();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver/domain/House_Rental_Application/");
		String act = driver.getTitle();
		sa.assertEquals(act, exp);
		System.out.println(act);
		sa.assertAll();
	}

}
