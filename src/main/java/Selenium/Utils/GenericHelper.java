package Selenium.Utils;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GenericHelper {
	
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

}
