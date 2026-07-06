package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By searchBox = By.xpath("//input[@type='search']");
	private By productNameTextBox = By.xpath("//h4[@class='product-name']");
	private By topDealLink = By.linkText("Top Deals");
	private By incrementButton = By.cssSelector("a.increment");
	private By addToCartButton = By.cssSelector(".product-action button");
	
	public void searchProduct(String name) {
	
		
		  System.out.println("Driver in LandingPage = " + driver);

		    driver.findElement(searchBox).clear();
	 driver.findElement(searchBox).sendKeys(name);
	}
	
	public void incrementProduct(int quantity) {
		
		int i= quantity-1;
		while(i>0) {
		driver.findElement(incrementButton).click();
		i--;
		}
	}
	
public void addToCart() {
		
		driver.findElement(addToCartButton).click();
	}
	
	
	public String getProductName() {
		
		   List<WebElement> products = driver.findElements(productNameTextBox);

		    System.out.println("Products found = " + products.size());

		    if (products.size() == 0) {
		        throw new RuntimeException(
		                "No products found. Current URL = "
		                + driver.getCurrentUrl());
		    }

		    return products.get(0).getText().split("-")[0].trim();
		
		//return driver.findElement(productNameTextBox).getText().split("-")[0].trim();
	}
	
	public void clickTopDealsLink() {
		driver.findElement(topDealLink).click();
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
}
