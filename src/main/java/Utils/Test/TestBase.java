package Utils.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.time.Duration;
import java.util.Optional;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utils.ExtentReport.ReportPropertiesReader;
import Utils.Selenium.BrowserFactory;
import fixedData.BrowserType;



public class TestBase {
	
	public WebDriver driver=null;
	public static int testCaseCounter=1;
	BrowserFactory browserFactory = new BrowserFactory();
	public static Duration tenSec = Duration.ofSeconds(10);
	public static Duration fifteenSec = Duration.ofSeconds(10);
	public static Duration twentySec = Duration.ofSeconds(10);
	public static Duration fiftySec = Duration.ofSeconds(10);
	
	private static final Logger log = LoggerFactory.getLogger(TestBase.class);
	
	@Parameters({"browserType"})
	@BeforeClass (alwaysRun = true ,description = "Get browser method runs before each and every class to generate a driver instance") 
	public WebDriver getBrowser()
	{
		this.driver=browserFactory.initializeBrowser( BrowserType.valueOf("CHROME"));
		this.driver.get("https://practice.expandtesting.com/");
		this.driver.manage().window().maximize();
		return driver;
	}
	
	
	@AfterClass (alwaysRun = true)
	public void afterEachClass()
	{
		driver.quit();
	}
	


}
