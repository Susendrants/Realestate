package com.hra.owner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ObjectRepo.ApartmentRegisterPage;
import com.ObjectRepo.HomeRegisterPage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.OwnerHomePage;
import com.ObjectRepo.WelcomePage;
import com.realestate.GenericUtils.BaseClass;
import com.realestate.GenericUtils.ExcelUtils;
import com.realestate.GenericUtils.FileUtils;
import com.realestate.GenericUtils.WebdriverUtils;

public class G_apartmentRoomRegTest extends BaseClass {
	
	@Test(groups="smoke")
	public void apartmentRoomRegTest() throws Throwable {
		
		//Initial house count
		OwnerHomePage ow=new OwnerHomePage(driver);
		int initialcount = ow.initialRoom();
		
		ow.getRegister().click();
		
		//Apartment Register
			OwnerHomePage om= new OwnerHomePage(driver)	;
			om.getRegister().click();
			ApartmentRegisterPage ar= new ApartmentRegisterPage(driver);
			ar.ApartmentLink();
		eLib.readMultipleData("APARTMENT", driver);
		ar.UploadImage();
		
		ar.submitButton();
		
		//verify the data flow from register to home page
		ow.validateCount(initialcount);
		
		
	}	

}
