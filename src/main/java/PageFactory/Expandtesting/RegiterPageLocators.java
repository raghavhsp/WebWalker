package PageFactory.Expandtesting;

import org.openqa.selenium.By;

public class RegiterPageLocators {
	
	
	public By userNameInput = By.xpath("//label[text()='Username']/following-sibling::input");
	public By passwordInput = By.xpath("//label[text()='Password']/following-sibling::input");
	public By confirmPassInput = By.xpath("//label[text()='Confirm Password']/following-sibling::input");
	public By regiterBtn = By.xpath("//button[text()='Register']");
	
	public By successFlashMsg = By.xpath("//div[@role='alert']/b");
}
