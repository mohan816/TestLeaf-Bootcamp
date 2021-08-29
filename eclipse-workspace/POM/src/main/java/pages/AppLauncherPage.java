package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class AppLauncherPage extends BaseClass {
	
	public AppLauncherPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	public AccountPage clickAccounts() {
		WebElement accountClick=driver.findElementByXPath("(//p[text()='Accounts'])");
		driver.executeScript("arguments[0].scrollIntoView();",accountClick);
		driver.executeScript("arguments[0].click()",accountClick);
		return new AccountPage(driver,prop);
	}
	public HomePage clickSales() {
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		return new HomePage(driver,prop);
		
	}

}
