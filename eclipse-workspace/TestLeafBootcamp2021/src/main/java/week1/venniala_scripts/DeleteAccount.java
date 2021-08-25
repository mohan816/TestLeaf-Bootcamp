package week1.venniala_scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteAccount extends BaseClass {
	@BeforeClass
	public void setFileName() {
		FileName="EditAccounts";
	}
	@Test(dataProvider="fetchData")
	public void DeleteAccount(String userName, String Password) throws InterruptedException {
		WebElement user=driver.findElementById("username");
		user.sendKeys(userName, Keys.TAB);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementById("Login").click();
		//To click the toggle
		Thread.sleep(5000);
		driver.findElement(By.className("slds-icon-waffle")).click();
		//To click view all
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//To click sales
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		driver.findElement(By.xpath("//div[@role='list']/one-app-nav-bar-item-root[6]")).click();
		driver.findElement(By.xpath("//input[@name='Account-search-input']")).sendKeys("Mohanrajan", Keys.ENTER);
		Thread.sleep(5000);
		//to click the drop list
		driver.findElement(By.xpath("(//div[@data-aura-class='forceVirtualAction'])[1]")).click();
		//to delete
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//span[text()='Delete']")).click();
		String actual=driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		if(actual.equals(actual)) {
			System.out.println("Account is deleted successfully");
		}
		else {
			System.out.println("Account is no deleted");
		}
	}	

}


