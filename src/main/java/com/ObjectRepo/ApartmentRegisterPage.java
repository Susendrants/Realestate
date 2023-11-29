package com.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApartmentRegisterPage {
@FindBy(xpath="//a[text()='Apartment Registration']")
private WebElement Apartmentlink;


@FindBy(xpath="//input[@name=\"apartment_name\"]")
private WebElement Apartmentname;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='mobile']")
private WebElement Mobile;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='alternat_mobile']")
private WebElement AlMobile ;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='email']")
private WebElement Email;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='plot_number']")
private WebElement PlotNum ;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='country']")
private WebElement Country;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='state']")
private WebElement State;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='city']")
private WebElement City;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='landmark']")
private WebElement Landmark;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='address']")
private WebElement Address ;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::input[@name='image']")
private WebElement Image;
@FindBy(xpath="//h2[text()='Apartment Room']/parent::div[@class='alert alert-info']/descendant::button[@name='register_apartment']")
private WebElement Submit;

public ApartmentRegisterPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public WebElement getApartmentname() {
	return Apartmentname;
}

public WebElement getMobile() {
	return Mobile;
}

public WebElement getAlMobile() {
	return AlMobile;
}

public WebElement getEmail() {
	return Email;
}

public WebElement getPlotNum() {
	return PlotNum;
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
public WebElement getApartmentlink() {
	return Apartmentlink;
}

public void ApartmentLink()
{
	Apartmentlink.click();
}

public void submitButton()
{
	Submit.click();
}
public void UploadImage()
{
	Image.sendKeys("C:\\Users\\SUSEE\\OneDrive\\Pictures\\Dp1.jpg");
}

}
