package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions (features = "src/main/java/featureFiles/FlightBooking.feature" , 
glue="StepDefinations", monochrome = true ,tags = "@Regression or @Smoke or not @Regression" , 
plugin = {"pretty", "html:target/Cucumber/Report.html"} , publish = true , dryRun=false)
public class FlightBookingTestRunner extends AbstractTestNGCucumberTests{

}
