package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBaseClass {
	
	public WebDriver driver;
	

	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//gobal.properties");
		Properties prop = new Properties();
		prop.load(file);
		String url = prop.getProperty("QAURL");
		String browser_properties = prop.getProperty("browser");
		String browser_maven = System.getProperty("browser");
		
		String browser = browser_maven!=null?browser_maven:browser_properties;
		
		if(driver == null) {
			
			if(browser.equalsIgnoreCase("chrome")) {
			
		//System.setProperty("webdriver.chrome.driver", "E:/Nandini_GT/chromedriver");
				driver = new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.get(url);
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				driver = new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				driver.get(url);
			}
		}
				return driver;
		
	}

}
