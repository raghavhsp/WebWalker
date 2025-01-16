package PageFactory.Expandtesting;

import org.openqa.selenium.By;

public class SampleApp_Dynamic_Tabel {
	
	public By getHeaderRow = By.xpath("//div[text()='Task Manager']/parent::div//th");
	
	
	/**
	 * @description get value locator for a browser in dynamic table with Browser name and index of table header column
	 * @param headerIndex - index of header 
	 * @param broswerName - Name of browser to look data for
	 * @return By locator
	 */
	public By getValueLocator (int headerIndex , String broswerName)
	
	{
		return By.xpath("(//div[text()='Task Manager']/parent::div//td[text()='"+broswerName+"']/following-sibling::td)["+String.valueOf(headerIndex)+"]");
	}
	
	
	

}
