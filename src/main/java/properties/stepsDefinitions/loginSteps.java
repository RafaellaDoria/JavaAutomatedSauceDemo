package properties.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import properties.pageObjects.Base;
import properties.pageObjects.HomePage;
import properties.pageObjects.LoginPage;
import properties.stepsDefinitions.*;
import properties.stepsDefinitions.base.Hooks;
import utils.varsG;
public class loginSteps extends Base {

    public loginSteps(){
        super();
    }
    private HomePage homePage;
    private Hooks hooks;

    private Base basePage;
    private LoginPage loginPage;
    public loginSteps(LoginPage loginPage, HomePage homePage) {
        this.loginPage = loginPage;
        this.homePage = homePage;
        this.basePage = basePage;
        this.hooks = hooks;
    }

    // This steps verifies all the actions of login
    @Given("I access the Saucedemo Login Page")
    public void i_access_the_saucedemo_login_page() {
        loginPage.NavigateToLoginPage();
    }
    @When("I enter a username {}")
    public void i_enter_a_username_non_existent(String username) {
        loginPage.setUserName(username);
    }
    @And("I enter a password {}")
    public void i_enter_a_password_secret_sauce(String password) {
        loginPage.setUserPassword(password);
    }
    @And("I click on the Login button")
    public void i_click_on_the_login_button() {
        loginPage.clickOn_Login_Button();
    }
    @Then("I should be presented with the following login validation message {}")
    public void i_should_be_presented_with_the_following_login_validation_message(String text) {
        loginPage.waitForAlert_And_ValidateLOGINText(text);
    }
    @And("I click on burger menu")
    public void clickOnBurguerMenu() throws InterruptedException{
        homePage.clickOn_BugerMenu();
    }

    @And("I go to the About Screen")
    public void clickOnAboutMenu() throws InterruptedException{
        homePage.GoToAboutPage();
    }

    @Then("I should be Logged in and the Header should present the message Swag Labs")
    public void i_should_be_presented_with_the_following_login_validation_message(){
        homePage.validate_SuccessfulSubmissionMessage_Text();
    }
    @And("Click in Burger menu to expand the sidebar menu")
    public void click_in_burger_menu_to_expand_the_sidebar_menu() {
        homePage.clickOn_BugerMenu();
    }
    @And("Click in LogOut")
    public void click_in_log_out() {
        homePage.clickOn_LogOutBtn();
    }
    @Then("The user must be logged out")
    public void the_user_must_be_logged_out() {
        loginPage.validateLoginPageBtn();
    }
    @Given("I access the Saucedemo Login Page and I Login In {} {}")
    public void i_access_the_saucedemo_login_page_and_i_Login_in(String username, String password){
        loginPage.FirstStepOpenAndLogIn(varsG.GlobalUsername, varsG.GlobalUserPassword);
    }
}
