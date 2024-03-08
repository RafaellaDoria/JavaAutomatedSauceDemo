package properties.stepsDefinitions.base;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.sql.Timestamp;
import static Driver.DriverConfig.cleanupDriver;
import static Driver.DriverConfig.getDriver;

public class Hooks {

    // This method is executed before each scenario.
    // It ensures that a WebDriver instance is available for the test.
    @Before
    public void setup() {
        getDriver();  // Initializes the WebDriver instance for the test.
    }

    // This method is executed after each step in a scenario.
    // It's used to capture a screenshot if the current step fails.
    @AfterStep
    public void captureExceptionImage(Scenario scenario){

        // Checks if the current step failed.
        if(scenario.isFailed()){
            // Creates a timestamp to use in the screenshot filename.
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            String timeMilliseconds = Long.toString(timestamp.getTime());

            // Captures a screenshot of the current browser state.
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            // Attaches the screenshot to the report with the timestamp as the name.
            scenario.attach(screenshot,  "image/png", timeMilliseconds);
        }
    }

    // This method is executed after each scenario.
    // It's responsible for cleaning up the WebDriver instance.
    @After
    public void tearDown() {
        cleanupDriver(); // Closes the browser and cleans up the WebDriver instance.
    }
}
