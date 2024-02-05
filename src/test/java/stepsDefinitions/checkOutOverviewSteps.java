package stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import properties.pageObjects.*;

public class checkOutOverviewSteps extends Base{

   private Base  basePage;

   private CheckoutOverviewPage checkoutOverviewPage;

   public checkOutOverviewSteps(Base basePage, CheckoutOverviewPage checkoutOverviewPage){
       this.basePage = basePage;
       this.checkoutOverviewPage = checkoutOverviewPage;
   }
    // This steps verifies all the actions of checkout overview screen
   @And("I click on finish button")
   public void checkout_overview_click_finish_button(){
       checkoutOverviewPage.clickOnfinishButton();

   }

   @Then("^The informations of \"([^\"]*)\", \"([^\"]*)\" and \"([^\"]*)\" are displayed$")
   public void checkout_overview_infos(String paymentInfo, String shippingInfo, String priceInfo){
        checkoutOverviewPage.checkoutOverviewPaymentDetailsIsDisplayed(paymentInfo);
        checkoutOverviewPage.checkoutOverviewShippingDetailsIsDisplayed(shippingInfo);
        checkoutOverviewPage.checkoutOverviewPriceTotalDetailsIsDisplayed(priceInfo);
    }

    @Then("The informations of completed checkout are displayed")
    public void checkout_overview_completed(){
       checkoutOverviewPage.validateCompleteDetailsHeader();
       checkoutOverviewPage.validateCompleteDetailsTitle();
       checkoutOverviewPage.validateCompleteDetailsDescription();
    }

}
