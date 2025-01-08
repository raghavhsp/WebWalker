package Selenium.Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import FixedData.BrowserType;

public class BrowserFactory {
	
	public WebDriver initializeBrowser(BrowserType browser)
	{
		WebDriver driver = null;
		
		switch (browser) 
		{
			case CHROME->
			{
				driver=new ChromeDriver();
			}
			case FIREFOX->
			{
				driver=new FirefoxDriver();
			}
			case EDGE->
			{
				driver=new EdgeDriver();
			}
			case SAFARI->
			{
				driver=new SafariDriver();
			}	
		
		}
		
		return driver;
		
	}

}
