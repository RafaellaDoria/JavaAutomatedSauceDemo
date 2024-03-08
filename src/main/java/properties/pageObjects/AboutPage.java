package properties.pageObjects;

import Driver.DriverConfig;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;
import properties.pageObjects.*;

public class AboutPage extends Base{
    private Base base;
    private HomePage homePage;

    private WebDriver driver;

    public AboutPage(){
        super();
    }

    public AboutPage(Base base, HomePage homePage, WebDriver driver){
        this.base = base;
        this.homePage = homePage;
        this.driver = driver;
    }

    public @FindBy(css = "img[src*='/_next/image?url=https%3A%2F%2Fimages.ctfassets.net%2Fvrc8wif0t20g%2F2HX4HAZ0lFaJ2ZK9eabUoT%2Feda1664bd0956d02cd0a7474f24b5b01%2FScreenshot_2023-01-23_at_18.06.16.png&w=3840&q=75']")
    WebElement srcImage;

    public @FindBy(css = "img[srcset*='/images/logo.svg']")
    WebElement sauceLogo;

    public @FindBy(className = "MuiTypography-root MuiTypography-h1 css-9sm5so")
    WebElement webMobileText;

    public void imageSauceLabs(){
        waitFor(srcImage);
        srcImage.isDisplayed();

    }

    public void webMobileTextLabel(){
        webMobileText.getText();
        Assert.assertEquals(webMobileText,"Website and mobile testing at every stage of development");
    }
}
