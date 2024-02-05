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

public class CartPage extends Base {

    //Super(); method to use in cucumber/testNG to run
    public CartPage(){
        super();
    }
    private Base base_po;
    public CartPage(Base base_po) {
        this.base_po = base_po;
    }

    //Inspect elements from cart page
    public @FindBy(xpath = "//div[@id='shopping_cart_container']/a/span")
    WebElement shoppingCartBadge1;

    public @FindBy(className = "shopping_cart_link")
    WebElement cartBtn;

    public @FindBy(id = "remove-sauce-labs-backpack")
    WebElement RemoveProductCartBtn;
    public @FindBy(id = "shopping_cart_container")
    WebElement ShoppingCartContainer;

    public @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack' and text()='Remove']")
    WebElement RemoveBtnLabel;
    public @FindBy(xpath = "//span[contains(text(),'Your Cart')]")
    WebElement YourCartLbl;

    public @FindBy(id = "continue-shopping")
    WebElement ContinueShoppingBtn;

    public @FindBy(id= "checkout")
    WebElement CheckoutBtn;

    //Methods using from Base class for each actions
    public void ShoppingCartBadgeNotAppears() {
        if (shoppingCartBadge1.isDisplayed()) {
            Assert.fail("Shopping cart badge is present.");
        }
    }

    public void ShoppingCartBadgeAppears() {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(varsG.DEFAULT_EXPLICT_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOf(shoppingCartBadge1));
        if (shoppingCartBadge1.isDisplayed()) {
            Assert.assertTrue(true);
        }
    }
    public void clickInCartIcon(){
        base_po.waitForWebElementAndClick(ShoppingCartContainer);
    }
    public void removeProductCart(){
        base_po.waitForWebElementAndClick(RemoveProductCartBtn);
    }

    public void continueShoppingButton(){
        base_po.waitForWebElementAndClick(ContinueShoppingBtn);
    }

    public void checkoutButton(){
        base_po.waitForWebElementAndClick(CheckoutBtn);
    }


    public void removeProductCartText(){
        waitFor(RemoveBtnLabel);
        Assert.assertEquals(RemoveBtnLabel.getText(), "Remove");
    }
    public void cartPageValidating(){
        waitFor(YourCartLbl);
        Assert.assertEquals(YourCartLbl.getText(), "Your Cart");
    }

    public void shopping_cart_badgeShouldNotBeDisplayed(){
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(2));
        try {
            boolean elementInvisible = wait.until(ExpectedConditions.invisibilityOf(shoppingCartBadge1));
            if (!elementInvisible) {
                Assert.fail("Shopping cart badge is still displayed");
            }
        } catch (NoSuchElementException e) {
            Assert.assertTrue(true);
        }
    }

    public void shopping_cart_screen_product_details(){

    }

}
