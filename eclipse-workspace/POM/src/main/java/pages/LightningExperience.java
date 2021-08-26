package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LightningExperience extends BaseClass {
	public LightningExperience(ChromeDriver driver) {
		this.driver=driver;
}
	public HomePage navigateHomePage() {
		return new HomePage(driver);
	}
}