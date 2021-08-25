package week2.vennila_scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.BaseClassData;
import week1.venniala_scripts.BaseClass;

public class CustomerServiceOptions extends BaseClassData {
	@BeforeClass
	public void setFileName() {
		FileName="CustomerServiceOptions";
	}
	@Test(dataProvider="fetchData")
	public void customerServiceOptions(String userName, String Password) throws InterruptedException {
		
		WebElement user=driver.findElementById("username");
		user.sendKeys(userName, Keys.TAB);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementById("Login").click();
		Thread.sleep(10000);
		//click learn more
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Thread.sleep(5000);
		Set<String> allWindows=driver.getWindowHandles();
		List<String> allWindows1=new ArrayList<String>(allWindows);
		driver.switchTo().window(allWindows1.get(1));
		WebElement product=driver.findElement(By.xpath("//button/span[text()='Products']"));
		Actions action=new Actions(driver);
		action.moveToElement(product).perform();
		driver.findElement(By.xpath("//span[text()='Service ']/parent::a")).click();
		List<WebElement> tabs=driver.findElements(By.xpath("(//ul[contains(@class,'wwww-main-nav')]//button/span[text()])"));
		List<String> toVerifyTab=new ArrayList<String>();
		for(int i=0;i<tabs.size()-2;i++) {
		String tabName=tabs.get(i).getText();
		System.out.println(tabName);
		toVerifyTab.add(tabName);
		}
		
		

	}

}
