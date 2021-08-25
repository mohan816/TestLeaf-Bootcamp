package week1.venniala_scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortOpportunites {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement user = driver.findElementById("username");
		user.sendKeys("makaia@testleaf.com", Keys.TAB);
		driver.findElementById("password").sendKeys("SelBootcamp$123");
		driver.findElementById("Login").click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		Thread.sleep(5000);
		WebElement viewAll = driver.findElementByXPath("(//button[text()='View All'])");
		viewAll.click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		
		

	}

}
