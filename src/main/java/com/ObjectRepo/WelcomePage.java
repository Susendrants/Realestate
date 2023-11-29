package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {
    //declaration
	@FindBy(xpath="//a[text()='Login']")
	private WebElement Loginlink;
	@FindBy(xpath="//a[text()='Search']")
	private WebElement Searchlink;
	@FindBy(xpath="//a[text()='Register']")
	private WebElement Registerlink;
	
	//initialization
	public WelcomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
   
	//Utilization
	public WebElement getLoginlink() {
		return Loginlink;
	}

	public WebElement getSearchlink() {
		return Searchlink;
	}

	public WebElement getRegisterlink() {
		return Registerlink;
	}
	
	//Business logic
	public void login()
	{
		Loginlink.click();
	}
	public void register()
	{
		Registerlink.click();
	}
	public void search()
	{
		Searchlink.click();
	}
	
}
