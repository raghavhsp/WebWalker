package Selenium.Utils;

import java.time.Duration;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Test.Utils.TestBase;

public class GenericHelper extends TestBase{
	
	
	/**
	 * @description method to locate webElement with By locator
	 * @since 13-JAN-2025
	 * @author raghavagnihotri
	 * @param driver - Web drive instance
	 * @param locator - by locator of element
	 * @return Options<WebElement> - WebElement / null
	 */
	
	public Optional <WebElement> locateElement(WebDriver driver , By locator)
	{
		try {
			return Optional.ofNullable(driver.findElement(locator));
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	
	/**
	 * @description scroll element into view with Java Script
	 * @param driver - webElement instance
	 * @param element - element to scroll to
	 */
	public  void scrollElementInView(WebDriver driver, WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public  void scrollElementInView(WebDriver driver, By locator)
	{
		WebElement element =driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @description method to grab text of an element with By locator
	 * @author raghavagnihotri
	 * @since 13-JAN-2025
	 * @param driver - WebDriver object
	 * @param locator - By locator
	 * @return Optional<String> : text/null
	 */
	
	public Optional <String> grabText(WebDriver driver , By locator)
	{
		String elementText=null;
		
		
		// Wait for element to be present then grab text 
		waitForPresence(driver ,locator , tenSec);
		elementText= locateElement(driver , locator).isPresent() ?  locateElement(driver , locator).get().getText()  : null;
		
		return Optional.ofNullable(elementText);
	}
	
	/**
	 * @description type into a web element 
	 * @param driver - web driver instance
	 * @param locator- By locator
	 * @param keys - keys to send / text to type
	 * @return boolean - true if sent 
	 */
	
	public boolean sendKeys (WebDriver driver ,By locator, String keys)
	{
		boolean flag=false;
		
		// Wait for element to be present then send keys 
		waitForPresence(driver ,locator , tenSec);
		
		try{
			
			// SendKeys after clear
			if (null == keys || keys.isBlank() || keys.isEmpty())
			 {
				driver.findElement(locator).clear();
				return true;
			 }
			 
			 // Send keys if valid
			else
			 {
				 driver.findElement(locator).sendKeys(keys);
				 return true;
			 }
				
			}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		
		return flag;
		
		
	}
	
	/**
	 * @description wait for presence of element
	 * @author raghavagnihotri
	 * @since 13-JAN-2024
	 * @param driver - web driver instance
	 * @param locator - By locator
	 * @param duation - time to wait
	 */
	
	public void waitForPresence(WebDriver driver,By locator, Duration duation)
	{
		WebDriverWait wait = new WebDriverWait(driver , duation);
		
		// Wait for element to be present then grab text 
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

}
