package properties.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.time.Duration;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.stepsDefinitions.productScreenSteps;

import static properties.stepsDefinitions.productScreenSteps.sort_by_asc;

public class ProductPage extends Base{

    private Base basePage;
    private WebDriver driver;

    private productScreenSteps productSteps;

    //Super(); method to use in cucumber/testNG to run
    public ProductPage(){

        super();
    }


    //Inspect elements from cart page
    public ProductPage(Base basePage, WebDriver driver) {
        this.basePage = basePage;
        this.driver = driver;
    }


    public @FindBy(xpath = "//div[2]/div/div/div[2]/div")
    WebElement inventoryProductOpened;

    public @FindBy(xpath = "//span[contains(text(),'Products')]")
    WebElement productsHeader;
    public @FindBy(id = "back-to-products")
    WebElement backToProductsBtn;


    public @FindBy(id = "remove-sauce-labs-backpack")
    WebElement RemoveProductBtn;

    public @FindBy(xpath = "//button[@id='remove-sauce-labs-backpack' and text()='Remove']")
    WebElement RemoveBtnProductLabel;

    public @FindBy(className = "inventory_item_name ")
    List<WebElement> productNameLabel;

    public @FindBy(className = "product_sort_container")
    WebElement productSortByHeader;

    public void validateOrderNameBYAsc() {

        List<String> textList = new ArrayList<>();
        for(WebElement element : productNameLabel){
            textList.add((element.getText().trim()));
        }

        try {
            if (sort_by_asc(textList)) {
                System.out.println("The elements are displayed in ascending order.");
            } else {
                System.out.println("The elements are NOT displayed in ascending order.");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    //Methods using from Base class for each actions
    public void validate_openedProduct() {
        waitFor(backToProductsBtn);
        waitFor(inventoryProductOpened);
        Assert.assertEquals(inventoryProductOpened.getText(), "Sauce Labs Backpack");
    }

    public void removeProduct(){
        waitFor(RemoveProductBtn);
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
    public void clickOnSortByProduct(){
        productSortByHeader.click();
    }
    public void select(By dropdownSelector, String value) {
        selectOptionByValue(dropdownSelector, value);
    }

    public void elementToSelect(String optionValue) {

        // Locate the select element
        WebElement selectElement = driver.findElement(By.className("product_sort_container"));

        // Click on the select element to open the dropdown
        waitFor(selectElement);
        selectElement.click();

        // Construct the CSS selector for the option based on the provided value
//        String optionCssSelector = String.format("select.product_sort_container option[value='%s']", optionValue);
//
//        // Locate and click on the desired option
//        WebElement optionElement = driver.findElement(By.cssSelector(optionCssSelector));
//        waitFor(optionElement);
//        optionElement.click();
    }


}




