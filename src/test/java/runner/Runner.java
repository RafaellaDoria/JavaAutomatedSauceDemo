package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;


// Defines the Cucumber options for running the tests
@CucumberOptions(features = {"classpath:features"}, glue = {"properties/stepsDefinitions"},
        tags = "@tests",
        monochrome = false, dryRun = false,
        plugin = {"pretty", "html:target/cucumber-reports.html", "json:target/cucumber.json"})

// Extends the AbstractTestNGCucumberTests to integrate Cucumber with TestNG
public class Runner extends AbstractTestNGCucumberTests {
    // Overrides the scenarios method to enable parallel execution of tests
    @Override
    @DataProvider(parallel = true)

    // Calls the superclass method to provide the scenarios for TestNG
    public Object[][] scenarios(){
        return super.scenarios();
    }

}
