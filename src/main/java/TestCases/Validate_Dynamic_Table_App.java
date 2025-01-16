package TestCases;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageFactory.Expandtesting.HomePageLocators;
import PageFactory.Expandtesting.SampleApp_Dynamic_Tabel;
import Selenium.Utils.GenericHelper;
import Selenium.Utils.MouseOperations;
import Test.Utils.TestBase;

public class Validate_Dynamic_Table_App extends TestBase{
	HomePageLocators homePageLocator = new HomePageLocators();
	MouseOperations mouseOps = new MouseOperations();
	GenericHelper genHelper = new GenericHelper();
	SampleApp_Dynamic_Tabel saDynamicTable = new SampleApp_Dynamic_Tabel();
	
	
	@Test
	
	public void validateBrowserSpeeds()
	{
		
		// Click on Application Link(Test Login Page)
		By appLink= homePageLocator.getSampleAppLocator("Dynamic Table");
		genHelper.scrollElementInView(driver, appLink);
		
		// Click on Application Link
		mouseOps.click(driver, appLink);
		
		//Get Header elements and text
		genHelper.scrollElementInView(driver, saDynamicTable.getHeaderRow);
		
		Optional<LinkedHashMap<WebElement , String>>  elementNText = genHelper.getElementsNText(driver, saDynamicTable.getHeaderRow);
		
		Assert.assertTrue(elementNText.isPresent()," Header Elements located ?");
		
		// Get Index of CPU usage column
		Integer indexOfMatch= null;
		int count=0;
		for(WebElement element : elementNText.get().keySet())
		{
			if (elementNText.get().get(element).toLowerCase().equals("cpu"))
				{
				indexOfMatch=count;
				break;
				}
			
			else
				count++;
		}
		
		Assert.assertTrue(indexOfMatch!=null , "Header Colum with title CPU found ?");
		
		//Get CPU usage for chrome
		Optional<WebElement> cpuUsage = genHelper.locateElement(driver, saDynamicTable.getValueLocator(indexOfMatch, "Chrome"));
		Assert.assertTrue(cpuUsage.isPresent(),"Chrome CPU Usage located");
		
		// Check usage is less than 40%
		Assert.assertTrue(Double.valueOf(cpuUsage.get().getText().split("%")[0])<40,"Cpu Usage less than 40 %");
	
		
	}

}
