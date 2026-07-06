package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
	WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By cartImage = By.cssSelector("[alt='Cart']");
	private By checkoutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By promoButton = By.cssSelector(".promoBtn");
	private By placeorderButton = By.xpath("//button[contains(text(),'Place Order')]");
	
	
	public void checkoutITems() {
	
	driver.findElement(cartImage).click();
	driver.findElement(checkoutButton).click();
	
	}
	
	public boolean verifyPromoButton() {
		
		return driver.findElement(promoButton).isDisplayed();
		
		}
public boolean verifyPlaceOrder() {
		
		return driver.findElement(placeorderButton).isDisplayed();
		
		}	
public boolean verifyPlaceOrder1() {
	
	return driver.findElement(placeorderButton).isDisplayed();
	
	}	
public boolean verifyPlaceOrder2() {
	
	return driver.findElement(placeorderButton).isDisplayed();
	
	}	

}
