package com.practice_Package;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class BbTest {
public static void main(String[] args) {
	WebDriver driver= new ChromeDriver();
	
	driver.get("https://www.bigbasket.com/");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.findElement(By.xpath("//header[@class=\"sm:hidden z-30 flex flex-col col-span-12\"]/descendant::*[name()='svg' and @height=\"16\" and @fill='none']")).click();
     String value="Foodgrains, Oil & Masala";
	WebElement j = driver.findElement(By.xpath("//ul[@class=\"jsx-1259984711 w-56 px-2.5 bg-darkOnyx-800 text-silverSurfer-100 rounded-l-xs\" and @role=\"none\"]/descendant::a[text()=\"Fruits & Vegetables\"]"));
	  
//	WebElement k = driver.findElement(By.xpath("//ul[@class='jsx-1259984711 w-56 px-2.5 bg-darkOnyx-800 text-silverSurfer-100 rounded-l-xs' and @role='none']/descendant::a[text()="+value+"]"));
//	Actions a=new Actions(driver);
// a.moveToElement(k).perform();
    	
	
	WebElement i = driver.findElement(By.xpath("//ul[@class=\"jsx-1259984711 w-56 px-2.5 bg-darkOnyx-800 text-silverSurfer-100 rounded-l-xs\" and @role=\"none\"]/following-sibling::ul[@class=\"jsx-1259984711 w-56 px-2.5 bg-silverSurfer-200 text-darkOnyx-800\"]"));
    WebElement q = driver.findElement(By.xpath("//ul[@class=\"jsx-1259984711 w-56 px-2.5 bg-darkOnyx-800 text-silverSurfer-100 rounded-l-xs\" and @role=\"none\"]/following-sibling::ul[@class=\"jsx-1259984711 w-56 px-2.5 bg-white text-darkOnyx-800 rounded-r-xs\"]")); 
	String r = j.getText();
      String e = i.getText();
      String f =q.getText();
      System.out.println(r);
      System.out.println(" ");
      System.out.println(e);
      System.out.println(" ");
      System.out.println(r);

}
}
