package testRunners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions ( features = "src/main/java/featureFiles/SmokeTest.feature" , monochrome = true , glue = "StepDefinations")
public class SmokeTestRunner extends AbstractTestNGCucumberTests{

}
