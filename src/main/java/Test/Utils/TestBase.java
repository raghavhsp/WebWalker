package Test.Utils;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;

import Selenium.Utils.BrowserFactory;



public class TestBase {
	
	WebDriver driver=null;
	BrowserFactory browserFactory = new BrowserFactory();
	
	
	@BeforeClass
	public void getBrowser()
	{
		
	}

}
