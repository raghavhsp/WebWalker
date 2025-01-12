package PageFactory.Expandtesting;

import org.openqa.selenium.By;

public class SampleApp_Test_Login_Page_Locators {
	
	public  By userNameTxt = By.xpath("//li[text()='Username: ']/b");
	public By passwordTxt = By.xpath("//li[text()='Password: ']/b");
	
	public By userNameTxtBox = By.xpath("//input[@id='username']");
	public By passwordTxtBox = By.xpath("//input[@id='password']");
	public By loginBtn = By.xpath("//button[@type='submit']");
	
	public By loginSucessTxt = By.xpath("//div[@id='flash']//*[contains(text(),'logged into')]");
	public By logOutSuccessTxt = By.xpath("//div[@id='flash']//*[contains(text(),'logged out')]");
	
	public By logOutBtn= By.xpath(" //i[contains(text(),'Logout')]/parent::a");
	
	

}
