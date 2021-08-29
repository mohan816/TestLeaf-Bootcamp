package pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class SalesforceClassic extends BaseClass {
	
	public SalesforceClassic(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	public LightningExperience clickLightningExperiene() {
		List<WebElement> newPage=driver.findElements(By.xpath("//a[@class='switch-to-lightning']"));
		if(newPage.size()>=1) {
			newPage.get(0).click();
		}
		return new LightningExperience(driver,prop);
	}
	public SalesforceClassic clickCreateNew() {
		driver.findElement(By.id("createNewButton")).click();
		return this;
	}
	public EventPage clickEvent() {
		driver.findElement(By.xpath("//a[text()='Event']")).click();
		return new EventPage(driver,prop);
	}

}
