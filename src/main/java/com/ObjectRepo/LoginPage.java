package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.realestate.GenericUtils.ExcelUtils;
import com.realestate.GenericUtils.WebdriverUtils;

public class LoginPage {
	
	@FindBy(name="username")
	private WebElement Email;
	@FindBy(name="password")
	private WebElement Password;
	@FindBy(xpath="//button[text()='Submit']")
	private WebElement Submit;
	@FindBy(xpath="//a[text()='Register']")
	private WebElement Register;
	
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getSubmit() {
		return Submit;
	}

	public WebElement getRegister() {
		return Register;
	}
	
	public void Login(String username,String password)
	{
		Email.sendKeys(username);
		Password.sendKeys(password);
		Submit.click();
	}
	
	public void regLogin() throws Throwable
	{
		ExcelUtils eLib=new ExcelUtils();
		Email.sendKeys(eLib.readDataFromExcel("OWNER_REG", 3, 1));
		Password.sendKeys(eLib.readDataFromExcel("OWNER_REG", 4, 1));
		Submit.click();
	}
}
