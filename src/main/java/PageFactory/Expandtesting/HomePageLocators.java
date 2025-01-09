package PageFactory.Expandtesting;

import org.openqa.selenium.By;

public class HomePageLocators {
	
	
	public By getSampleAppLocator(String appLabel)
	{
		return By.xpath("//*[contains(text(),'Sample applications')]/parent::section//a[text()='"+appLabel+"']");
	}

}
