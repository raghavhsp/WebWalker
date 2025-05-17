package Selenium.Utils;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import fixedData.BrowserType;

public class BrowserFactory {
	
	public WebDriver initializeBrowser(BrowserType browser)
	{
		WebDriver driver = null;
		
		// Get Operating System
		String osName = System.getProperty("os.name");
        System.out.println("Operating System: " + osName);
		
        switch (browser) 
		{
			case CHROME->
			{ ChromeOptions options;
				
		        if (osName.toLowerCase().contains("windows"))
		        {
		        options = new ChromeOptions().setBinary("C:\\Program Files\\BraveSoftware\\Brave-Browser\\Application\\brave.exe");
		        }
		        else
				 options = new ChromeOptions().setBinary("/Applications/Brave Browser.app/Contents/MacOS/Brave Browser");
			//	options.addExtensions(new File(System.getProperty("user.dir")+File.pathSeparator+"BrowserOptions"+File.separator+"Chrome"+File.separator+"AD_Blocker.crx"));
			//	options.addExtensions(new File("/Users/raghavagnihotri/Raghav_Agnihotri/Projects/WebWalker/BrowserExtensions/Chrmoe/AD_Blocker.crx"));
				
				driver=new ChromeDriver(options);
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
