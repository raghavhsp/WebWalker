package StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.github.javafaker.Faker;

import PageFactory.Expandtesting.HomePageLocators;
import PageFactory.Expandtesting.RegiterPageLocators;
import Selenium.Utils.GenericHelper;
import Selenium.Utils.MouseOperations;
import Test.Utils.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class BackGrounds {
	WebDriver driver;
	HomePageLocators homePageLocator = new HomePageLocators();
	MouseOperations mouseOps = new MouseOperations();
	RegiterPageLocators regiterPage = new RegiterPageLocators();
	GenericHelper genHelper = new GenericHelper();
	Faker fake = new Faker();
	TestBase base = new TestBase();
	
	@Given("Browser Started and Window Maximized")
	public void intializeBrowser()
	{
		System.out.println("Starting Web Browser with Background Step");
		driver=base.getBrowser();
	}
	
	@Given("User is on Home Page")
	public void navigateToHomePage()
	{
		
		driver.navigate().to("https://practice.expandtesting.com/");
	}
	
	@When("User navigate to Regiter Page")
	public void navigateToRegiterPage()
	{
		// Click on Application Link(Web inputs)
		By appLink= homePageLocator.getSampleAppLocator("Test Register Page");
		genHelper.scrollElementInView(driver, appLink);
		
		boolean appLinkClicked=mouseOps.click(driver, appLink);
		Assert.assertTrue(appLinkClicked , "App link button clicked successfully ?" );
	}
	
	@When("Enter Details in regiter page")
	public void enterDetails()
	{
		// Add Value to all fields
				genHelper.scrollElementInView(driver, regiterPage.userNameInput);
				driver.findElement(regiterPage.userNameInput).sendKeys(fake.name().firstName());
				driver.findElement(regiterPage.passwordInput).sendKeys("Password@1");
				driver.findElement(regiterPage.confirmPassInput).sendKeys("Password@1");
				mouseOps.click(driver, regiterPage.regiterBtn);
	}
	
	@When("Enter Invalid Details in regiter page")
	public void enterInvalidDetails()
	{
		// Add Value to all fields
				genHelper.scrollElementInView(driver, regiterPage.userNameInput);
				driver.findElement(regiterPage.userNameInput).sendKeys("raghavhsp@gmail.com");
				driver.findElement(regiterPage.passwordInput).sendKeys("Password@1");
				driver.findElement(regiterPage.confirmPassInput).sendKeys("Password@1");
				mouseOps.click(driver, regiterPage.regiterBtn);
	}
	
	@Then("Registration success message should appear")
	public void confirmRegistration()
	{
		//Wait For SuccessMessage
		genHelper.waitForPresence(driver, regiterPage.successFlashMsg, base.tenSec);
		
		// Get Success Message
		Assert.assertTrue(driver.findElement(regiterPage.successFlashMsg).getText().toLowerCase().contains("successfully registered"), "Success Message Displayed ?");
		
	}
	
	@Then("Registration success message should not appear")
	public void confirmFailedRegistration()
	{
		//Wait For SuccessMessage
		genHelper.waitForPresence(driver, regiterPage.successFlashMsg, base.tenSec);
		
		// Get Success Message
		Assert.assertFalse(driver.findElement(regiterPage.successFlashMsg).getText().toLowerCase().contains("successfully registered"), "Success Message Displayed ?");
		
	}

}
