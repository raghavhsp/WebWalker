package StepDefinations;

import java.util.List;
import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FlightBooking {
	
	@Given("User is on login page")
	public void user_is_on_login_page() {
	   System.out.println("User is On Login Page");
	}
	@When("^User enter creds as (.+) and (.+)$")
	public void user_enter_creds_as_and(String username, String password) {
	    System.out.println("Entered Username :"+username+" Password:"+password);
	}
	@Then("User should be able to login")
	public void user_should_be_able_to_login() {
	  System.out.println("User Logged In successfully");
	}
	
	
	@Given("User is on regiter user page")
	public void user_is_on_regiter_user_page() {
	    System.out.println("User is on registration page");
	}
	@When("User enter data as below and create user")
//	public void user_enter_data_as_below_and_create_user( List<String> list) {
		public void user_enter_data_as_below_and_create_user(DataTable dataTable) {
		List<String> list = dataTable.asList(String.class);
		for(String value : list)
		{
			System.out.println("List Value :"+value);
		}
	   
	}
	@Then("Registration successfull should appear on screen")
	public void registration_successfull_should_appear_on_screen() {
	    System.out.println("Registration Success Page Appears");
	}
	
	
	@Given(": User has list of filghts and its pilots for today")
	public void user_has_list_of_filghts_and_its_pilots_for_today() {
	 System.out.println("\n\n User Has Fligh Details with its pilots");
	}
	@When(": User match fligh to pilot details as below")
	public void user_match_fligh_to_pilot_details_as_below(DataTable dataTable) {
	   List< Map<String,String>> map = dataTable.asMaps();
	    System.out.println("Flight With Pilot Details as floows :"+map);
	    
	}


}
