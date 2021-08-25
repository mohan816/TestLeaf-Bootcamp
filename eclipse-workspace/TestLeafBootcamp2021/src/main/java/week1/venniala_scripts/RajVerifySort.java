package week1.venniala_scripts;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RajVerifySort extends BaseClass {
@Test
	public void verifySort() throws InterruptedException{
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		WebElement user = driver.findElementById("username");
		user.sendKeys("makaia@testleaf.com", Keys.TAB);
		driver.findElementById("password").sendKeys("SelBootcamp$123");
		driver.findElementById("Login").click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		Thread.sleep(5000);
		WebElement viewAll = driver.findElementByXPath("(//button[text()='View All'])");
		viewAll.click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		driver.findElement(By.xpath("//div[@role='list']/one-app-nav-bar-item-root[6]")).click();
		 List<WebElement> listOfDashboard = driver.findElementsByXPath("//th[@data-aura-class='forceInlineEditCell']//a");
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].scrollIntoView(true);", listOfDashboard.get(listOfDashboard.size()-1));
		 Thread.sleep(10000);
		 List<WebElement> listOfDashboardNames = driver.findElementsByXPath("//th[@data-aura-class='forceInlineEditCell']//a");
		 ArrayList<String> dashboardNames = new ArrayList<String>();
		 for(int i=1; i<listOfDashboardNames.size(); i++) {
		driver.executeScript("arguments[0].scrollIntoView(true);", listOfDashboardNames.get(i));
		 String names = listOfDashboardNames.get(i).getText().trim();
		 dashboardNames.add(names);
		 }
		 Collections.sort(dashboardNames);
		 System.out.println(dashboardNames);

	}

}
