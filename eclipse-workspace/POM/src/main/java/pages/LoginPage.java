package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	public LoginPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public LoginPage enterUsername(String UserName) {
		WebElement user=driver.findElementById("username");
		user.sendKeys(UserName, Keys.TAB);
		return this;
	}
	public LoginPage enterPassword(String password) {
		driver.findElementById("password").sendKeys(password);
		return this;
	}
	public SalesforceClassic clickLogin() {
		driver.findElementById("Login").click();
		return new SalesforceClassic(driver);
	}

}
