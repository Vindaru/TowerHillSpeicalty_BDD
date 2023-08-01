package runner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	    features = "src/test/resources/featureFiles/basicinformationPage/ths_states_DP1_testcases/AL_DP1.feature",
	    glue = {"steps"},
	    plugin = {"json:target/cucumber.json"}
	)
	public class TestRunner extends AbstractTestNGCucumberTests {
	    
	}
