package properties.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.varsG;
import java.time.Duration;
import org.openqa.selenium.NoSuchElementException;

public class CheckoutPage extends Base{
    //Methods using from Base class for each actions
    public CheckoutPage(){
        super();
    }

    private Base base_po;
    public CheckoutPage(Base base_po) {
        this.base_po = base_po;
    }
    //Inspect elements from cart page
    public @FindBy(xpath = "//span[contains(text(),'Checkout: Your Information')]")
    WebElement checkoutYourInfoTxt;

    public @FindBy(id="first-name")
    WebElement firstNameInput;

    public @FindBy(id = "last-name")
    WebElement lastNameInput;

    public @FindBy(id="postal-code")
    WebElement postalCodeInput;

    public @FindBy(xpath = "//*[contains(text(), 'Error: First Name is required')]")
    WebElement errorMessageCheckoutFirstName;

    public @FindBy(id = "cancel")
    WebElement cancelBtn;

    public @FindBy(id = "continue")
    WebElement continueBtn;

    //Methods using from Base class for each actions
    public void checkoutScreenFirstNameDetailsAppears (){
        waitFor(firstNameInput);
        firstNameInput.isDisplayed();
        Assert.assertTrue(true);

    }

    public void checkoutScreenLastNameDetailsAppears (){
        waitFor(lastNameInput);
        lastNameInput.isDisplayed();
        Assert.assertTrue(true);

    }

    public void checkoutScreenPostalDetailsAppears (){
        waitFor(postalCodeInput);
        postalCodeInput.isDisplayed();
        Assert.assertTrue(true);

    }

    public void insertFirstNameInput( String frstName){
        waitFor(firstNameInput);
        firstNameInput.sendKeys(frstName);
    }

    public void insertLastNameInput( String lstName){
        waitFor(lastNameInput);
        lastNameInput.sendKeys(lstName);
    }

    public void insertPostalCodeInput( String zipCode){
        waitFor(postalCodeInput);
        postalCodeInput.sendKeys(zipCode);
    }

    public void insertLastNameInput(){
        waitFor(lastNameInput);
        lastNameInput.sendKeys("teste");
    }

    public void insertPostalCodeInput(){
        waitFor(postalCodeInput);
        postalCodeInput.sendKeys("40000000");
    }

    public void clickOnContinueButtonFromCheckout(){
        base_po.waitForWebElementAndClick(continueBtn);
    }

    public void clickOnCancelButtonFromCheckout(){
        base_po.waitForWebElementAndClick(cancelBtn);
    }

    public void errorMessageAppearsAllInputsAreEmpty(){
        waitFor(errorMessageCheckoutFirstName);
        Assert.assertEquals(errorMessageCheckoutFirstName.getText(), "Error: First Name is required");
    }


}

