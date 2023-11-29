package com.realestate.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils {
	/**
	 * This method is used to maximize window
	 * @param driver
	 */
     public void maximizeWindow(WebDriver driver)
     {
    	 driver.manage().window().maximize();
     }
     /**
      * This method is used to minimize window
      * @param driver
      */
     public void minimizeWindow(WebDriver driver)
     {
    	 driver.manage().window().minimize();
     }
     /**
      * 
      * @param driver
      * @param sec
      */
     public void waitForPageLoad(WebDriver driver, int sec)
     {
    	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(sec));
     }
     /**
      * 
      * @param driver
      * @param sec
      */
     public void waitForImplicit(WebDriver driver, int sec)
     {
    	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(sec));
     }
     /**
      * This method is used to wait until the element is clickable
      * @param driver
      * @param element
      * @param sec
      */
     public void waitUntilEleToBeClickable(WebDriver driver,WebElement element, int sec)
     {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
    	 wait.until(ExpectedConditions.elementToBeClickable(element));
     }
     /**
      * 
      * @param driver
      * @param element
      * @param sec
      */
     public void waitUntilEleToBeVisible(WebDriver driver,WebElement element, int sec)
     {
    	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(sec));
    	 wait.until(ExpectedConditions.visibilityOf(element));
     }
     public void dropdown(WebElement element, int index)
     {
    	 Select sel=new Select(element);
    	 sel.selectByIndex(index);
     }
     public void dropdown(WebElement element, String vtext)
     {
    	 Select sel=new Select(element);
    	 sel.selectByVisibleText(vtext);
     }
     public void dropdown(String value,WebElement element )
     {
    	 Select sel=new Select(element);
    	 sel.selectByValue(value);
     }
     public void mouseOver(WebDriver driver, WebElement element)
     {
    	 Actions action = new Actions(driver);
    	 action.moveToElement(element).perform();
     }
     public void dragAndDrop(WebDriver driver, WebElement src, WebElement target)
     {
    	 Actions action = new Actions(driver);
    	 action.dragAndDrop(src, target).perform();
     }
     public void clickonWebpage(WebDriver driver)
     {
    	 Actions action = new Actions(driver);
    	 action.click().perform();
     }
     public void clickonWebEle(WebDriver driver,WebElement element)
     {
    	 Actions action = new Actions(driver);
    	 action.click(element).perform();
     }
     public void doubleClickonWebpage(WebDriver driver)
     {
    	 Actions action = new Actions(driver);
    	 action.doubleClick().perform();
     }
     public void doubleClickonWebpage(WebDriver driver,WebElement element)
     {
    	 Actions action = new Actions(driver);
    	 action.doubleClick(element).perform();
     }
     public void rightClickonWebpage(WebDriver driver)
     {
    	 Actions action = new Actions(driver);
    	 action.contextClick().perform();
     }
     public void rightClickonWebEle(WebDriver driver,WebElement element)
     {
    	 Actions action = new Actions(driver);
    	 action.contextClick(element).perform();
     }
     public void enterKeyPress(WebDriver driver)
     {
    	 Actions action = new Actions(driver);
    	 action.sendKeys(Keys.ENTER);
     }
     public void keyPressEnter() throws Throwable
     {
          Robot rb= new Robot();
          rb.keyPress(KeyEvent.VK_ENTER);
     }
     public void keyReleaseEnter() throws Throwable
     {
          Robot rb= new Robot();
          rb.keyRelease(KeyEvent.VK_ENTER);
     }
     public void switchToFrame(WebDriver driver,int index)
     {
    	 driver.switchTo().frame(index);
     }
     public void switchToFrame(WebDriver driver, String nameorId)
     {
    	 driver.switchTo().frame(nameorId);
     }
     public void switchToFrame(WebDriver driver, WebElement address)
     {
    	 driver.switchTo().frame(address);
     }
     /**
      * This method will accept alert popup
      * @param driver
      */
     public void acceptAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().accept();
     }
     /**
      * This method will cancel alert popup
      * @param driver
      */
     public void cancelAlert(WebDriver driver)
     {
    	 driver.switchTo().alert().dismiss();
     }
     /**
      * This method will switch between windows
      * @param driver
      * @param partialWinTitle
      */
     public void switchToWindow(WebDriver driver,String partialWinTitle)
     {
    	//step.1 use getWindowHandles to capture all window ids
    	Set<String> windows = driver.getWindowHandles();
    	 //step.2 iterate through the windows
    	Iterator<String> it = windows.iterator();
    	//step3: check whether there is next window
    	while(it.hasNext())
    	{
    		//step4: capture current window id
    		String winId = it.next();
    		//step5: switch to current window and capture title
    		String currentWinTitle = driver.switchTo().window(winId).getTitle();
    		//step6: check whether the current window is expected
    		if(currentWinTitle.contains(partialWinTitle))
    		{
    			break;
    		}
    	}
     }
     /**
      * This method will take screenshot and store it in folder called as Screenshot
      * @param driver
      * @param screenShotName
      * @return
      * @throws Throwable
      */
     public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable 
     {
    	 TakesScreenshot ts = (TakesScreenshot)driver;
    	 File src = ts.getScreenshotAs(OutputType.FILE);
    	 String path = ".\\screenshot\\"+screenShotName+".png";
    	 File dst = new File(path);
    	 FileUtils.copyFile(src, dst);
    	 return dst.getAbsolutePath();
     }
     public void scrollBarAction(WebDriver driver)
     {
    	 JavascriptExecutor jse = (JavascriptExecutor)driver;
    	 jse.executeScript("window.scrollBy(0,500)", "");
     }
     public void scrollAction(WebDriver driver, WebElement element)
     {
    	 JavascriptExecutor js = (JavascriptExecutor) driver;
    	 int y = element.getLocation().getY();
    	 js.executeScript("window.scrollBy(0,"+y+")", element); 	
    	//js.executeScript("argument[0].scrollIntoView()",element);
     }
     
}
