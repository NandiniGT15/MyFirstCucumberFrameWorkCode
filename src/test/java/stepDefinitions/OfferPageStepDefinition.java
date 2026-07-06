package stepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {

    public TestContextSetup testContextSetup;
    public OfferPage offerPage;

    public OfferPageStepDefinition(TestContextSetup testContextSetup) {

        this.testContextSetup = testContextSetup;
        this.offerPage = testContextSetup.pageObjectManager.getOfferPage();
    }

    public void switchingToOffersPage() {
    	LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
        landingPage.clickTopDealsLink();
        testContextSetup.genericUtils.switchWindow();
    }

    //@Then("^User searched for (.+) shortname in offers page$")
    @Then("User searched for {string} shortname in offers page")
    public void user_searched_for_same_shortname_in_offers_page(String shortName) throws InterruptedException {
    	switchingToOffersPage();
        offerPage.searchProduct(shortName);
        Thread.sleep(2000);
        testContextSetup.offerPageProductName = offerPage.getProductName();
    }

    @Then("validate product name is same in both landing page and offer page")
    public void validate_product_name_is_same_in_both_landing_page_and_offer_page() {

    	System.out.println("Landing Page : "
    	        + testContextSetup.landingPageproductName);

    	System.out.println("Offer Page   : "
    	        + testContextSetup.offerPageProductName);
    	
        Assert.assertEquals(testContextSetup.offerPageProductName,
                            testContextSetup.landingPageproductName);

        System.out.println("PASSED");
    }
}


