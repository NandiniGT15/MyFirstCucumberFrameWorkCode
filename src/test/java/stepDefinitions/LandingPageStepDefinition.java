package stepDefinitions;

import java.io.IOException;
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
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageproductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	
	
	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() throws IOException {
		//testContextSetup.driver = testContextSetup.testBaseClass.WebDriverManager();
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	

	
	
	//Below is when sending as Parametersised
	//@When("^User searched with shortname (.+) and extracted actual name of the product$")
	@When("User searched with shortname {string} and extracted actual name of the product")
	public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws InterruptedException {
		 System.out.println("Driver in StepDefinition = " + testContextSetup.driver);
	
		landingPage.searchProduct(shortName);
		Thread.sleep(5000);
		testContextSetup.landingPageproductName = landingPage.getProductName();
		//testContextSetup.landingPageproductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(testContextSetup.landingPageproductName
		        + " is the extracted name from landing page");
	}
	
	@When("Add {string} items of the seleted product to cart")
	public void addItemProducts(String quantity)
	{
	landingPage.incrementProduct(Integer.parseInt(quantity));
	landingPage.addToCart();
	}

}
