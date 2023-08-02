package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
	    features = "src\\test\\resources\\featureFiles",
	    glue = "stepDefenitions", tags = "@DP1_OWNER_ACV",
	    plugin = {"html:target/Destination/cucumber-pretty","json:target/cucumber.json"})
	
	public class TestRunner extends AbstractTestNGCucumberTests {
	    
	}
