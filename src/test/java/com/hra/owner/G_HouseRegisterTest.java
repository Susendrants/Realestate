package com.hra.owner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import com.ObjectRepo.HomeRegisterPage;
import com.ObjectRepo.LoginPage;
import com.ObjectRepo.OwnerHomePage;
import com.ObjectRepo.WelcomePage;
import com.realestate.GenericUtils.BaseClass;
import com.realestate.GenericUtils.ExcelUtils;
import com.realestate.GenericUtils.FileUtils;
import com.realestate.GenericUtils.JavaUtils;
import com.realestate.GenericUtils.WebdriverUtils;

public class G_HouseRegisterTest extends BaseClass {
	
	@Test(groups="integration")
	public void HouseRegisterTestain() throws Throwable {
		
		//Initial house count
		OwnerHomePage ow=new OwnerHomePage(driver);
		int initialcount = ow.initialRoom();
		ow.getRegister().click();   
		
		//Home Register
		HomeRegisterPage hr=new HomeRegisterPage(driver);   
		ow.getRegister().click();
		hr.mobileData();
		hr.emailData();
		hr.homeReg(eLib.readMultipleData("HOME", driver), driver);
		eLib.readMultipleData("HOME", driver);		
		hr.confirmationMsg();
		ow.validateCount(initialcount);
		

	}

}
