package driver;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class DriverConfig {


    // ThreadLocal to maintain a WebDriver instance for each thread
    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    // Returns the WebDriver instance for the current thread. If it doesn't exist, creates a new one using createDriver().
    public static WebDriver getDriver() {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    // Creates a new WebDriver instance based on the browser type specified in system properties or the configuration file.
    private static WebDriver createDriver() {
        WebDriver driver = null;

        switch (getBrowserType()) {

            // Sets the path for the Chrome driver and configures browser options
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new ChromeDriver(chromeOptions);
                break;
            }

            // Sets the path for the Firefox driver and configures browser options
            case "firefox" -> {
                System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/java/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }

        // Maximizes the browser window
        driver.manage().window().maximize();
        return driver;
    }

    // Determines the browser type to be used based on the system properties or the configuration file.
    private static String getBrowserType() {
        String browserType = null;
        String browserTypeRemoteValue = System.getProperty("browserType");

        try {

            // Reads the browser type from the configuration file if not specified in system properties
            if (browserTypeRemoteValue == null || browserTypeRemoteValue.isEmpty()) {
                Properties properties = new Properties();
                FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
                properties.load(file);
                browserType = properties.getProperty("browser").toLowerCase().trim();
            } else {
                browserType = browserTypeRemoteValue;
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return browserType;
    }

    // Closes the browser and clears the WebDriver instance from the ThreadLocal for the current thread.
    public static void cleanupDriver() {
        webDriver.get().quit();
        webDriver.remove();
        //webDriver.get().manage().deleteAllCookies();
    }

}
