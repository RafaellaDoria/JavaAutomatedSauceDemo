package properties.pageObjects;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ProductPage extends Base{

    //Super(); method to use in cucumber/testNG to run
    public ProductPage(){
        super();
    }
    private Base basePage;

    //Inspect elements from cart page
    public ProductPage(Base basePage) {
        this.basePage = basePage;
    }
    public @FindBy(xpath = "//div[2]/div/div/div[2]/div")
    WebElement inventoryProductOpened;

    public @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productsHeader;
    public @FindBy(id = "back-to-products")
    WebElement backToProductsBtn;

    public @FindBy(className = "product_sort_container")
    WebElement sortByBtn;

    public @FindBy(id = "remove-sauce-labs-backpack")
    WebElement RemoveProductBtn;

    public @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack' and text()='Remove']")
    WebElement RemoveBtnProductLabel;


    //Methods using from Base class for each actions
    public void validate_openedProduct() {
        waitFor(backToProductsBtn);
        waitFor(inventoryProductOpened);
        Assert.assertEquals(inventoryProductOpened.getText(), "Sauce Labs Backpack");
    }

    public void removeProduct(){
        basePage.waitForWebElementAndClick(RemoveProductBtn);
    }

    public void removeProductCartText(){
        waitFor(RemoveBtnProductLabel);
        Assert.assertEquals(RemoveBtnProductLabel.getText(), "Remove");
    }

    public void validateProductsHeaderIsDisplayed(){
        waitFor(productsHeader);
        productsHeader.isDisplayed();
        Assert.assertTrue(true);
    }



}
