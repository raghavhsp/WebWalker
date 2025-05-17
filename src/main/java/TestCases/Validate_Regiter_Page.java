package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import PageFactory.Expandtesting.HomePageLocators;
import PageFactory.Expandtesting.RegiterPageLocators;
import Selenium.Utils.GenericHelper;
import Selenium.Utils.MouseOperations;
import Test.Utils.TestBase;

public class Validate_Regiter_Page extends TestBase{
HomePageLocators homePageLocator = new HomePageLocators();
MouseOperations mouseOps = new MouseOperations();
RegiterPageLocators regiterPage = new RegiterPageLocators();
GenericHelper genHelper = new GenericHelper();
Faker fake = new Faker();

	@Test
	public void validateRegiterPage()
	{
		// Click on Application Link(Web inputs)
		By appLink= homePageLocator.getSampleAppLocator("Test Register Page");
		genHelper.scrollElementInView(driver, appLink);
		
		boolean appLinkClicked=mouseOps.click(driver, appLink);
		Assert.assertTrue(appLinkClicked , "App link button clicked successfully ?" );
		
		// Add Value to all fields
		genHelper.scrollElementInView(driver, regiterPage.userNameInput);
		driver.findElement(regiterPage.userNameInput).sendKeys(fake.name().firstName());
		driver.findElement(regiterPage.passwordInput).sendKeys("Password@1");
		driver.findElement(regiterPage.confirmPassInput).sendKeys("Password@1");
		mouseOps.click(driver, regiterPage.regiterBtn);
		
		//Wait For SuccessMessage
		genHelper.waitForPresence(driver, regiterPage.successFlashMsg, tenSec);
		
		// Get Success Message
		Assert.assertTrue(driver.findElement(regiterPage.successFlashMsg).getText().toLowerCase().contains("successfully registered"), "Success Message Displayed ?");
		
		
	}

}
