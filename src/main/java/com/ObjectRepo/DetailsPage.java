package com.ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DetailsPage {
	@FindBy(xpath="//b[text()='Mobile Number: ']/parent::p")
	private WebElement Mobiles;
public DetailsPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public WebElement getMobiles() {
	return Mobiles;
}
public void validate(WebDriver driver, String mon)
{
	List<WebElement> res = driver.findElements(By.xpath("//b[text()='Mobile Number: ']/parent::p"));
	  for(int i=0; i<res.size();i++)
		{
			String mob = res.get(i).getText();
			if(mob.contains(mon))
			{
				System.out.println("The data is present");
				break;
			}
			else
			{
				System.out.print("");
			}
		} 
	
}
}
