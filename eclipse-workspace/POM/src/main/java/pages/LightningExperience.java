package pages;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LightningExperience extends BaseClass {
	public LightningExperience(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
}
	public HomePage navigateHomePage() {
		return new HomePage(driver,prop);
	}
}