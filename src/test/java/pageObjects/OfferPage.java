package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {
	
		WebDriver driver;
		public OfferPage(WebDriver driver) {
			this.driver = driver;
		}


private By searchBox = By.xpath("//input[@type='search']");
private By productNameTextBox = By.cssSelector("tr td:nth-child(1)");



public void searchProduct(String name) {
	
 driver.findElement(searchBox).sendKeys(name);
}

public String getProductName() {
	
	return driver.findElement(productNameTextBox).getText();
}


}

