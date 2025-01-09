package Selenium.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptUtil {
	

	/**
	 * @description Highlight given element
	 * @author raghavagnihotri
	 * @since 09-JAN-2025
	 * @param driver- Valid driver instance
	 * @param locator - By locator of webElement
	 * @return boolean - true if highlighted
	 */
	public boolean highlightMe(WebDriver driver, By locator)
	{
		boolean isHighlighted= false;
		
		WebElement element =null;
		try {
			element= driver.findElement(locator);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		if (element!=null)
		{
			try {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].style.border='3px solid green'", element);
				isHighlighted=true;
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return isHighlighted;
		
	}
	
	/**
	 * @description Highlight given element
	 * @author raghavagnihotri
	 * @since 09-JAN-2025
	 * @param driver- Valid driver instance
	 * @param element - By locator of webElement
	 * @return boolean - true if highlighted
	 */
	public boolean highlightMe(WebDriver driver, WebElement element)
	{
		boolean isHighlighted= false;

		if (element!=null)
		{
			try {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				js.executeScript("arguments[0].style.border='3px solid green'", element);
				isHighlighted=true;
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return isHighlighted;
		
	}

}
