package properties.pageObjects;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutOverviewPage extends  Base {
    //Super(); method to use in cucumber/testNG to run
    public CheckoutOverviewPage(){
        super();
    }

    private Base base_po;

    public CheckoutOverviewPage(Base base_po) {
        this.base_po = base_po;
    }

    //Inspect elements from checkout overview page
    public @FindBy(xpath = "//span[contains(text(),'Checkout: Overview')]")
    WebElement checkoutOverviewHeader;

    public @FindBy(className = "cart_item")
    WebElement checkoutCartProduct;


    public @FindBy(className = "summary_info_label")
    List<WebElement> summaryLabels;

    public String getSummaryInfoLabels(String infosLabel){
        for (WebElement label: summaryLabels){
            label.getText();
        }

        return infosLabel;
    }
    //Inspected all elements from checkout overview
    public @FindBy(id = "finish")
    WebElement finishButton;

    public @FindBy(xpath = "//span[contains(text(),'Checkout: Complete!')]")
    WebElement checkoutCompleteHeader;

    public @FindBy(className = "complete-header")
    WebElement checkoutCompleteTitle;

    public @FindBy(className = "complete-text")
    WebElement checkoutCompleteDescription;

    public @FindBy(id = "back-to-products")
    WebElement backHomeBtn;

    //Methods using from Base class for each action

    public String checkoutOverviewPaymentDetailsIsDisplayed(String paymentInfo){
        paymentInfo = summaryLabels.get(0).getText();
        Assert.assertEquals(paymentInfo, "Payment Information");
        return paymentInfo;

    }

    public String checkoutOverviewShippingDetailsIsDisplayed(String shippingInfo){
        shippingInfo = summaryLabels.get(1).getText();
        Assert.assertEquals(shippingInfo, "Shipping Information");
        return shippingInfo;

    }

    public String checkoutOverviewPriceTotalDetailsIsDisplayed(String priceTotalInfo) {
        priceTotalInfo = summaryLabels.get(2).getText();
        Assert.assertEquals(priceTotalInfo, "Price Total");
        return priceTotalInfo;

    }

    public void clickOnfinishButton(){
        base_po.waitForWebElementAndClick(finishButton);
    }

    public void validateCompleteDetailsHeader(){
        waitFor(checkoutCompleteHeader);
        String actualHeadertext = checkoutCompleteHeader.getText();
        Assert.assertEquals(actualHeadertext, "Checkout: Complete!");
    }

    public void validateCompleteDetailsTitle(){
        waitFor(checkoutCompleteTitle);
        String actualTitleText = checkoutCompleteTitle.getText();
        Assert.assertEquals(actualTitleText, "Thank you for your order!");
    }

    public void validateCompleteDetailsDescription(){
        waitFor(checkoutCompleteDescription);
        String actualDescriptionText = checkoutCompleteDescription.getText();
        Assert.assertEquals(actualDescriptionText, "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }


}
