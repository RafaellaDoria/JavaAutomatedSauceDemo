package properties.stepsDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import properties.pageObjects.*;
import properties.pageObjects.HomePage;
import properties.pageObjects.Base;
import properties.pageObjects.AboutPage;

public class aboutScreenSteps extends Base{
    private AboutPage aboutPage;
    private HomePage homePage;
    private Base basePage;
    public aboutScreenSteps(AboutPage aboutPage, HomePage homePage,Base basePage) {
        this.aboutPage = aboutPage;
        this.basePage = basePage;
        this.homePage = homePage;
    }

//    @Then("I can see the sauce labs image")
//    public void validateTheSauceImage(){
//
//    }

    @Then("I can see the sauce labs image")
    public void i_can_see_the_sauce_labs_image() {
        aboutPage.imageSauceLabs();
    }


}
