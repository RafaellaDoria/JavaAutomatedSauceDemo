package properties.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.varsG;
import java.time.Duration;
public class Base {
    public Base(){
        PageFactory.initElements(getDriver(), this);
    }
    public WebDriver getDriver() { return driver.DriverConfig.getDriver(); }
    public void navigateTo_URL(String url) { getDriver().get(url); }
    public String generateRandomNumber(int lenght){ return RandomStringUtils.randomNumeric(lenght); }
    public String generateRandomAlphabetical(int lenght){ return RandomStringUtils.randomAlphabetic(lenght); }

    //Actions for waiting, sendkeys, clicking and element present or not present
    public void sendKeys(By by, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(varsG.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).sendKeys(textToType);
    }
    public void sendKeys(WebElement element, String textToType){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(varsG.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(textToType);
    }
    public void waitFor(By by){ //wait the specific element to be visible - good to use a lot
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(varsG.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }
    public void waitFor(WebElement element){ //wait the specific element to be visible - good to use a lot
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(varsG.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public void waitForWebElementAndClick(By by){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(varsG.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }
    public void waitForWebElementAndClick(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(varsG.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void elementShoubNotBePresent(WebElement element){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(varsG.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.invisibilityOfElementLocated((By) element));
    }

}
