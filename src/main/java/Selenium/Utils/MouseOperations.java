package Selenium.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Test.Utils.TestBase;

public class MouseOperations {
	
	JavaScriptUtil javaScriptUtil = new JavaScriptUtil();
	
	
	/**
	 * @description click method
	 * @author raghavagnihotri
	 * @since 10-JAN-2025
	 * @param driver - valid driver instance
	 * @param locator - by locator of element to be clicked
	 * @return boolean - true if clicked
	 */
	public boolean click(WebDriver driver, By locator)
	{
		boolean isClicked = false;
		
		// Wait for element to be present
		WebDriverWait wait = new WebDriverWait(driver , TestBase.tenSec);
		if ((wait.until(ExpectedConditions.presenceOfElementLocated(locator)))!=null)
		{
			javaScriptUtil.highlightMe(driver,locator);
			
			try {
				driver.findElement(locator).click();
				isClicked=true;
			}
			catch (Exception e) {
				WebElement element;
				try {
					element=driver.findElement(locator);
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("argument[0].click()", element);
					isClicked=true;
		
				}
				catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Error locating element. Click operation failed");
				}
				
			}
		}
		
		return isClicked;
			
		
	}
	
	
	/**
	 * @description click method
	 * @author raghavagnihotri
	 * @since 10-JAN-2025
	 * @param driver - valid driver instance
	 * @param element - webElement to be clicked
	 * @return boolean - true if clicked
	 */
	public boolean click(WebDriver driver, WebElement element)
	{
		boolean isClicked = false;
		
		// Wait for element to be present
		WebDriverWait wait = new WebDriverWait(driver , TestBase.tenSec);
		if ((wait.until(ExpectedConditions.elementToBeClickable(element)))!=null)
		{
			javaScriptUtil.highlightMe(driver,element);
			
			try {
				element.click();
				isClicked=true;
			}
			catch (Exception e) {
				
				try {
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("argument[0].click()", element);
					isClicked=true;
					System.out.println("Clicked with Java Script");
					
				}
				catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Error locating element. Click operation failed");
				}
				
			}
		}
		
		return isClicked;
		
	}
	
	

}
