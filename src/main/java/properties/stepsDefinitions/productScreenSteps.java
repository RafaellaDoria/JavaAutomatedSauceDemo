package properties.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.pageObjects.Base;
import properties.pageObjects.HomePage;
import properties.pageObjects.LoginPage;
import properties.pageObjects.ProductPage;
import properties.pageObjects.CartPage;
import Driver.DriverConfig;

import java.lang.Thread;
import java.util.List;

public class productScreenSteps extends Base {

    private HomePage homePage;
    private LoginPage loginPage;
    private ProductPage productPage;

//    private  WebDriver driver;

    private DriverConfig driver;
    private Base basePage;

    private CartPage cartPage;
//    WebDriver driver = new ChromeDriver(); // Or initialize WebDriver as per your needs


    public productScreenSteps(LoginPage loginPage, HomePage homePage, ProductPage productPage, CartPage cartPage, Base basePage, DriverConfig driver) {
        this.loginPage = loginPage;
        this.homePage = homePage;
        this.productPage = productPage;
        this.cartPage = cartPage;
        this.basePage = basePage;
        this.driver = driver;
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

    @And("^Select \"([^\"]*)\" option to filter$")
    public void sort_by_product(String Option) throws InterruptedException {
//        Base base = new Base();
//        WebDriver driver = base.getDriver();
//        ProductPage productPage = new ProductPage(driver);


        switch (Option.toLowerCase()){
            case "az":
                productPage.elementToSelect(Option);
//                Thread.sleep(500);
//                productPage.waitForWebElementAndClick(By.cssSelector("select.product_sort_container [value='az']"));
//                String optionCssSelector = String.format("select.product_sort_container [value='%s']", Option);
//                productPage.waitForWebElementAndClick(By.cssSelector(optionCssSelector));
                break;

            case "desc":

                Thread.sleep(500);
                productPage.waitForWebElementAndClick(By.cssSelector("select.product_sort_container [value='za']"));
                break;

            case "Low price":

                Thread.sleep(500);
                productPage.waitForWebElementAndClick(By.cssSelector("select.product_sort_container [value='lohi']"));
                break;

            case "High price":

                Thread.sleep(500);
                productPage.waitForWebElementAndClick(By.cssSelector("select.product_sort_container [value='hilo']"));
                break;



        }
    }

    @Then("The order of the name is ascending")
    public static boolean sort_by_asc(List<String> textList) throws InterruptedException{
        ProductPage productPage = new ProductPage();
        productPage.validateOrderNameBYAsc();
        return true;
    }



}
