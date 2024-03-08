package properties.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import properties.pageObjects.*;

public class cartScreenSteps extends Base{
    private CartPage cartPage;
    private HomePage homePage;
    private Base basePage;
    public cartScreenSteps(CartPage cartPage, HomePage homePage,Base basePage) {
        this.cartPage = cartPage;
        this.basePage = basePage;
        this.homePage = homePage;
    }

    // This steps verifies all the actions of cart screen
    @And("The Shopping_cart_badge should not appear")
    public void the_Shopping_cart_badge_should_not_appear() throws InterruptedException {
        basePage.waitFor(cartPage.ShoppingCartContainer);
        Thread.sleep(2000);
        cartPage.ShoppingCartBadgeNotAppears();
    }

    @And("I click in Add To Cart button in first product")
    public void click_in_Add_To_Cart_button_in_first_product(){
        homePage.clickIn_AddToCart();
    }
    @Then("The Shopping_cart_badge should count 1")
    public void the_shopping_cart_badge_should_count() {
        cartPage.ShoppingCartBadgeAppears();
    }

    @Then("The Shopping_cart_badge should count 2")
    public void the_shopping_cart_badge_should_count2() {
        cartPage.ShoppingCartBadgeAppears();
    }
    @And("I click in Cart Icon")
    public void i_click_in_cart_icon(){
        cartPage.clickInCartIcon();
    }
    @And("I should be redirected to Cart Page")
    public void i_should_be_redirected_to_Cart_Page(){
        cartPage.cartPageValidating();
    }
    @And("I click in button to Remove From Cart")
    public void i_click_in_button_to_Remove_From_Cart(){
        cartPage.removeProductCart();
    }

    @And("I click on Continue Shopping button")
    public  void i_click_in_button_to_Continue_Shopping_From_Cart(){
        cartPage.continueShoppingButton();
    }

    @And("I click on Checkout button")
    public  void i_click_in_button_to_Chechout_From_Cart(){
        cartPage.checkoutButton();
    }

    @Then("The Remove button is displayed")
    public void cart_page_remove_button_is_displayed(){
        cartPage.removeProductCartText();
    }


    @Then("The Shopping_cart_badge should not be displayed")
    public void the_Shopping_cart_badge_should_not_be_displayed(){
        cartPage.shopping_cart_badgeShouldNotBeDisplayed();
    }



}
