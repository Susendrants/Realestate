package com.hra.owner;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.ObjectRepo.DetailsPage;
import com.ObjectRepo.HomeRegisterPage;
import com.ObjectRepo.OwnerHomePage;
import com.realestate.GenericUtils.BaseClass;

public class G_DetailsUpdateTest extends BaseClass {
	
	@Test
	public  void DetailsUpdateTest() throws Throwable {
		
		//Initial house count
		OwnerHomePage ow=new OwnerHomePage(driver);
		int initialcount = ow.initialRoom();
		ow.getRegister().click();   
				//Home Register
		HomeRegisterPage hr=new HomeRegisterPage(driver);   
		ow.getRegister().click();
		
		String mon=hr.mobileData();
		hr.emailData();
		
		hr.homeReg(eLib.readMultipleData("HOME", driver), driver);
		eLib.readMultipleData("HOME", driver);		
		hr.confirmationMsg();
		
		ow.validateCount(initialcount);
			
	//verify data flow in details module
	  ow.getUpdates().click();
	  DetailsPage dp=new DetailsPage(driver);
	 // Assert.fail();
	  dp.validate(driver, mon);
	  
	}
}
