package com.ObjectRepo;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.realestate.GenericUtils.ExcelUtils;
import com.realestate.GenericUtils.JavaUtils;
import com.realestate.GenericUtils.WebdriverUtils;

public class HomeRegisterPage {
	String expmob=null;
	
	@FindBy(xpath="//a[text()='Individual Home Registration']")
	private WebElement Homeform;
	@FindBy(xpath="//input[@name=\"fullname\"]")
	private WebElement FullNmae;
	@FindBy(xpath="//input[@name=\"mobile\"]")
	private WebElement Mobile;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"email\"]")
	private WebElement Email;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"alternat_mobile\"]")
	private WebElement AlMobile;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"plot_number\"]")
	private WebElement Plotno; ;
	@FindBy(xpath="//input[@name=\"rooms\"]")
	private WebElement AvaRoom;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"country\"]")
	private WebElement Country;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"state\"]")
	private WebElement State;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"city\"]")
	private WebElement City;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"rent\"]")
	private WebElement Rent;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"sale\"]")
	private WebElement Sale ;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"deposit\"]")
	private WebElement Deposit;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"accommodation\"]")
	private WebElement Facility;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"description\"]")
	private WebElement Description ;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"landmark\"]")
	private WebElement Landmark;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"address\"]")
	private WebElement Address ;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::input[@name=\"image\"]")
	private WebElement Image;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::button[text()='Submit']")
	private WebElement Submit;
	@FindBy(xpath="//h2[text()='Register Room']/parent::div[@class=\"alert alert-info\"]/descendant::div[text()='Registration successfull. Thank you']")
	private WebElement ConfirmationMsg;
	@FindBy(xpath="//select[@name=\"vacant\"]")
	private WebElement Dropdown;
	
	public HomeRegisterPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public WebElement getHomeform() {
		return Homeform;
	}

	public WebElement getFullNmae() {
		return FullNmae;
	}
	public WebElement getMobile() {
		return Mobile;
	}

	public WebElement getEmail() {
		return Email;
	}
	public WebElement getAlMobile() {
		return AlMobile;
	}
	public WebElement getPlotno() {
		return Plotno;
	}
	public WebElement getAvaRoom() {
		return AvaRoom;
	}
	public WebElement getCountry() {
		return Country;
	}
	public WebElement getState() {
		return State;
	}
	public WebElement getCity() {
		return City;
	}
	public WebElement getRent() {
		return Rent;
	}
	public WebElement getSale() {
		return Sale;
	}
	public WebElement getDeposit() {
		return Deposit;
	}
	public WebElement getFacility() {
		return Facility;
	}
	public WebElement getDescription() {
		return Description;
	}
	public WebElement getLandmark() {
		return Landmark;
	}
	public WebElement getAddress() {
		return Address;
	}
	public WebElement getImage() {
		return Image;
	}
	public WebElement getSubmit() {
		return Submit;
	}
	public WebElement getConfirmationMsg() {
		return ConfirmationMsg;
	}
	public WebElement getDropdown() {
		return Dropdown;
	}
	public String mobileData() throws Throwable
	{
		ExcelUtils eLib=new ExcelUtils();
		JavaUtils jLib=new JavaUtils();
		int ram = jLib.getRandomNo();
		String mvalue = eLib.readDataFromExcel("HOME", 7, 3);
		String expmob = mvalue+ram;
		Mobile.sendKeys(expmob);
		return expmob;
	}
	public void emailData() throws Throwable
	{
		ExcelUtils eLib=new ExcelUtils();
		JavaUtils jLib=new JavaUtils();
		int ram = jLib.getRandomNo();
		String evalue = eLib.readDataFromExcel("HOME", 8, 3);
		Email.sendKeys(evalue+ram);
	}
	
	
	public void homeReg(HashMap<String,String> map, WebDriver driver)
	{
		for(Entry<String, String> set:map.entrySet())
		{
			
			
				driver.findElement(By.xpath(set.getKey())).sendKeys(set.getValue());
			
		}
		
	
		Dropdown.click();
		WebdriverUtils wLib = new WebdriverUtils();
		wLib.dropdown(Dropdown, "Vacant");
	    Image.sendKeys("C:\\Users\\SUSEE\\OneDrive\\Desktop\\TY project\\admin.jpg");
	    Submit.click();
	}
	public void confirmationMsg()
	{
		String act=ConfirmationMsg.getText();
		String exp = "Registration successfull. Thank you";
	/*	if(act.equalsIgnoreCase(exp))
		{
			System.out.println("Succeefull");
		}
		else
		{
			System.out.println(" not Succeefull");
		}*/
		Assert.assertEquals(act, exp);
		System.out.println("Succeefull");
		
	}
	
	
	
	
	

	
	}
	
	
	

