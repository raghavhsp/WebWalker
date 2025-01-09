package TestCases;

import static org.testng.Assert.ARRAY_MISMATCH_TEMPLATE;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import PageFactory.Expandtesting.HomePageLocators;
import PageFactory.Expandtesting.SampleApp_WebInputs_Locators;
import Selenium.Utils.GenericHelper;
import Selenium.Utils.MouseOperations;
import Test.Utils.TestBase;

public class Validate_Web_Inputs_App extends TestBase{
HomePageLocators homePageLocator = new HomePageLocators();
MouseOperations mouseOps = new MouseOperations();
SampleApp_WebInputs_Locators saWebInputs = new SampleApp_WebInputs_Locators();
GenericHelper genHelper = new GenericHelper();
Faker fake = new Faker();
	
	@Test
	public void validateAllInputs()
	{
		// Click on Application Link(Web inputs)
		By appLink= homePageLocator.getSampleAppLocator("Web inputs");
		genHelper.scrollElementInView(driver, appLink);
		
		boolean appLinkClicked=mouseOps.click(driver, appLink);
		System.out.println("Is App Link Clicked" +appLinkClicked);
		// Add Value to all fields
		driver.findElement(saWebInputs.inputNumber).sendKeys(String.valueOf(fake.number().numberBetween(10, 100)));
		driver.findElement(saWebInputs.inputText).sendKeys(fake.funnyName().name());
		driver.findElement(saWebInputs.inputPassword).sendKeys(fake.gameOfThrones().dragon());
		driver.findElement(saWebInputs.inputDate).sendKeys("01/01/2024");
		
		// Display Values
		genHelper.scrollElementInView(driver, saWebInputs.displayInputsBtn);
		mouseOps.click(driver,saWebInputs.displayInputsBtn);
		
	}

}
