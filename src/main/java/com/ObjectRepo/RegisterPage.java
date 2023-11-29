package com.ObjectRepo;

import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.text.html.FormSubmitEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.realestate.GenericUtils.ExcelUtils;
import com.realestate.GenericUtils.JavaUtils;

public class RegisterPage extends ExcelUtils {

	@FindBy(xpath="//input[@name=\"fullname\"]")
	private WebElement Fullname;
	@FindBy(xpath="//input[@id=\"username\"]")
	private WebElement Username;
	@FindBy(xpath="//input[@id=\"mobile\"]")
	private WebElement Mobile;
	@FindBy(xpath="//input[@id=\"email\"]")
	private WebElement Email;
	@FindBy(xpath="//input[@id=\"password\"]")
	private WebElement Password;
	@FindBy(xpath="//input[@id=\"c_password\"]")
	private WebElement Cpassword;
	@FindBy(xpath="//button[@name=\"register\"]")
	private WebElement Register;
	@FindBy(xpath="//a[text()='Login']")
	private WebElement Login;
	
	public RegisterPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getFullname() {
		return Fullname;
	}

	public WebElement getUsername() {
		return Username;
	}

	public WebElement getMobile() {
		return Mobile;
	}

	public WebElement getEmail() {
		return Email;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getCpassword() {
		return Cpassword;
	}

	public WebElement getRegister() {
		return Register;
	}

	public WebElement getLogin() {
		return Login;
	}
	
	//Business logic
	public void ownerReg(HashMap<String,String> map , WebDriver driver) 
	{
		for(Entry<String,String> set : map.entrySet() )
		{
			
		driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
		}
		Register.click();
   	}
	
}
