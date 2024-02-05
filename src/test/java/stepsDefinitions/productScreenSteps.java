package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import properties.pageObjects.Base;
import properties.pageObjects.HomePage;
import properties.pageObjects.LoginPage;
import properties.pageObjects.ProductPage;
import properties.pageObjects.CartPage;

public class productScreenSteps extends Base {

    private HomePage homePage;
    private LoginPage loginPage;
    private ProductPage productPage;

    private Base basePage;

    private CartPage cartPage;
    public productScreenSteps(LoginPage loginPage, HomePage homePage, ProductPage productPage, CartPage cartPage) {
        this.loginPage = loginPage;
        this.homePage = homePage;
        this.productPage = productPage;
        this.cartPage = cartPage;
    }

    // This steps verifies all the actions of product screen
    @And("I click on the Product Name")
    public void i_click_on_the_product_name() {
        homePage.clickOn_FirstProduct();
    }
    @Then("The Product Page Details should be opened")
    public void the_product_page_details_should_be_opened() {
        productPage.validate_openedProduct();
    }
    @And ("I click in button to remove from product screen")
        public void  remove_product_button_productscreen(){
        productPage.removeProduct();

    }

    @Then("The Remove button should be displayed of product screen")
    public void product_page_remove_button_is_displayed(){
        productPage.removeProductCartText();

    }

    @Then("Back to Product Screen")
    public void product_page_back(){
        productPage.validateProductsHeaderIsDisplayed();
    }



}
