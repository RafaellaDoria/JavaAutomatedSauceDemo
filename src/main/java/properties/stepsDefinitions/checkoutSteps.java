package properties.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import properties.pageObjects.*;

public class checkoutSteps extends Base{

    private CartPage cartPage;

    private CheckoutPage checkoutPage;
    private Base    basePage;

    // This steps verifies all the actions of checkout screen
    public checkoutSteps(Base basePage, CartPage cartPage, CheckoutPage checkoutPage){
        this.basePage = basePage;
        this.cartPage = cartPage;
        this.checkoutPage = checkoutPage;

    }

    @And("I insert first name input")
    public void checkout_page_insert_first_name(){
        checkoutPage.insertFirstNameInput("teste");

    }

    @And("I insert last name input")
    public void checkout_page_insert_last_name(){
        checkoutPage.insertLastNameInput("teste");

    }

    @And("I insert postal code")
    public void checkout_page_insert_postal_code(){
        checkoutPage.insertPostalCodeInput("400000");

    }

    @And("I click on continue button")
    public void checkout_page_continue_button(){
        checkoutPage.clickOnContinueButtonFromCheckout();
    }

    @And("I click on cancel button")
    public void checkout_page_cancel_button(){
        checkoutPage.clickOnCancelButtonFromCheckout();
    }

    @Then("The inputs: first name, last name and postal code should be displayed")
    public void checkout_page_all_inputs_is_displayed(){
        checkoutPage.checkoutScreenFirstNameDetailsAppears();
        checkoutPage.checkoutScreenLastNameDetailsAppears();
        checkoutPage.checkoutScreenPostalDetailsAppears();

    }

    @Then("The first name is required error message is displayed")
    public void checkout_page_all_inputs_null(){
        checkoutPage.errorMessageAppearsAllInputsAreEmpty();
    }
}
