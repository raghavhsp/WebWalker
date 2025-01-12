package Test.Utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Selenium.Utils.BrowserFactory;
import fixedData.BrowserType;



public class TestBase {
	
	public WebDriver driver=null;
	BrowserFactory browserFactory = new BrowserFactory();
	public static Duration tenSec = Duration.ofSeconds(10);
	public static Duration fifteenSec = Duration.ofSeconds(10);
	public static Duration twentySec = Duration.ofSeconds(10);
	public static Duration fiftySec = Duration.ofSeconds(10);
	
	@Parameters({"browserType"})
	@BeforeClass (alwaysRun = true ,description = "Get browser method runs before each and every class to generate a driver instance") 
	public void getBrowser()
	{
		this.driver=browserFactory.initializeBrowser( BrowserType.valueOf("CHROME"));
		this.driver.get("https://practice.expandtesting.com/");
		this.driver.manage().window().maximize();
	}

}
