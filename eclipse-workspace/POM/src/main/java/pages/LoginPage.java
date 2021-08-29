package pages;
import java.util.Properties;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	
	public LoginPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	
	public LoginPage enterUsername(String UserName) {
		WebElement user=driver.findElementById(prop.getProperty("LoginPage.Username.id"));
		user.sendKeys(UserName, Keys.TAB);
		return this;
	}
	public LoginPage enterPassword(String password) {
		driver.findElementById(prop.getProperty("LoginPage.Password.id")).sendKeys(password);
		return this;
	}
	public SalesforceClassic clickLogin() {
		driver.findElementById(prop.getProperty("LoginPage.Login.id")).click();
		return new SalesforceClassic(driver);
	}

}