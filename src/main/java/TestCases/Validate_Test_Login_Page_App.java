package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import PageFactory.Expandtesting.HomePageLocators;
import PageFactory.Expandtesting.SampleApp_Test_Login_Page_Locators;
import Selenium.Utils.GenericHelper;
import Selenium.Utils.MouseOperations;
import Test.Utils.TestBase;

public class Validate_Test_Login_Page_App extends TestBase{
HomePageLocators homePageLocator = new HomePageLocators();
MouseOperations mouseOps = new MouseOperations();
SampleApp_Test_Login_Page_Locators saLogin = new SampleApp_Test_Login_Page_Locators();
GenericHelper genHelper = new GenericHelper();
Faker fake = new Faker();
	
	@Test
	public void validateLoginLogOut()
	{
		// Click on Application Link(Test Login Page)
		By appLink= homePageLocator.getSampleAppLocator("Test Login Page");
		genHelper.scrollElementInView(driver, appLink);
		
		// Click on Application Link
		mouseOps.click(driver, appLink);
		
		// Get User name as password from screen
		String userName =genHelper.grabText(driver, saLogin.userNameTxt).get();
		String password =genHelper.grabText(driver, saLogin.passwordTxt).get();
		
		Assert.assertTrue(null!=userName && null!=password ,"User name and password found ?");
		
		// Enter UserName and password
		genHelper.sendKeys(driver, saLogin.userNameTxt, userName);
		genHelper.sendKeys(driver, saLogin.passwordTxt, password);
		
		// Hit Login button
		mouseOps.click(driver, saLogin.loginBtn);
		
		// Check of Login Message
		Assert.assertTrue(genHelper.grabText(driver, saLogin.loginSucessTxt).isPresent() , "Login success text displayed ?");
		System.out.println("Login success text is :" +genHelper.grabText(driver, saLogin.loginSucessTxt).get());
		
		
		// Click On Logout button
		Assert.assertTrue( mouseOps.click(driver, saLogin.logOutBtn),"Is logout button clicked ?");
		
		// Grab Logout text
		Assert.assertTrue(genHelper.grabText(driver, saLogin.logOutSuccessTxt)!=null ,"Logout success text displayed ?");
		System.out.println("Logout success text is :"+genHelper.grabText(driver, saLogin.logOutSuccessTxt));
		
	}

}
