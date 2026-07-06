package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public WebDriver driver;
	public String landingPageproductName;
	public String offerPageProductName;
	public PageObjectManager pageObjectManager;
	public TestBaseClass testBaseClass;
	public GenericUtils genericUtils;
	
	
	public TestContextSetup() throws IOException {
		
		 testBaseClass = new TestBaseClass();

		    driver = testBaseClass.WebDriverManager();

		    pageObjectManager = new PageObjectManager(driver);

		    genericUtils = new GenericUtils(driver);
	}
}
