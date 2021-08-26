package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class AccountPage extends BaseClass {
	
	public AccountPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public NewAccountPage clickNew() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
		return new NewAccountPage(driver);
	}
	public AccountPage searchTextBox() throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Mohanrajan", Keys.ENTER);
		Thread.sleep(10000);
		return this;
	}
	public AccountDetailsPage clickAccountName() {
		driver.findElement(By.xpath("(//a[@title='Mohanrajan'])[1]")).click();
		return new AccountDetailsPage(driver);
	}
	public AccountPage clickDropListAccountName() {
		driver.findElement(By.xpath("(//div[@data-aura-class='forceVirtualAction'])[1]")).click();
		return this;
	}
	public EditAccountPage clickEdit() {
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		return new EditAccountPage(driver);
	}
	public AccountPage clickDelete() {
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String actual=driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		if(actual.equals(actual)) {
			System.out.println("Account is deleted successfully");
		}
		else {
			System.out.println("Account is no deleted");
		}
		return this;
	}
	
}
