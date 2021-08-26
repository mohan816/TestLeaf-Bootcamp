package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class NewAccountPage extends BaseClass {
	public NewAccountPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public NewAccountPage enterAccountName() {
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Mohanrajan");
		return this;
	}
	public NewAccountPage selectOwnership() {
		WebElement ownershipDroplist=driver.findElement(By.xpath("(//div[@role='none'])[5]"));
		driver.executeScript("arguments[0].scrollIntoView();",ownershipDroplist);
		driver.executeScript("arguments[0].click()",ownershipDroplist);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		return this;
	}
	public AccountDetailsPage clickSave() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		return new AccountDetailsPage(driver);
	}

}
