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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.Ordering;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.BaseClassData;
import week1.venniala_scripts.BaseClass;

public class CertificationsSortOrder extends BaseClassData{
	
	@BeforeClass
	public void setFileName() {
		FileName="CertificationSortOrder";
	}
	@Test(dataProvider="fetchData")
	public void CertificationSortOrder(String userName, String Password) throws InterruptedException {
		WebElement user=driver.findElementById("username");
		user.sendKeys(userName, Keys.TAB);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementById("Login").click();
		Thread.sleep(5000);
		//click sliding icon
		WebElement click1=driver.findElement(By.xpath("//button[@data-aura-class='uiButton']/span[text()='Scroll Right']"));
		driver.executeScript("arguments[0].click()",click1);
		Thread.sleep(5000);
		WebElement click2=driver.findElement(By.xpath("//button[@data-aura-class='uiButton']/span[text()='Scroll Right']"));
		driver.executeScript("arguments[0].click()", click2);
		Thread.sleep(5000);
		WebElement click3=driver.findElement(By.xpath("//button[@data-aura-class='uiButton']/span[text()='Scroll Right']"));
		driver.executeScript("arguments[0].click()", click3);
		Thread.sleep(5000);
		WebElement getStarted=driver.findElement(By.xpath(("(//article[@class='onesetupHelpTile']//following::span[text()='Get Started'])[7]")));
		driver.executeScript("arguments[0].click()", getStarted);
		Thread.sleep(10000);
		Set<String> window=driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(window);
		driver.switchTo().window(windows.get(1));
		Thread.sleep(5000);
		System.out.println(driver.getTitle());
		//click on homedrop list
		driver.findElement(By.xpath("//div[@onclick='displayDropdown()']")).click();
		driver.findElement(By.xpath("//li[@id='Compliance']")).click();
		driver.findElement(By.xpath("//a[text()='Services']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()=' Sort by popularity ']")).click();
		Thread.sleep(5000);
		List<WebElement> totalSize=driver.findElements(By.xpath("//div[@class='slds-grid slds-wrap slds-gutters']/div//h2//span/span"));
		System.out.println(totalSize.size());
		List<String> totalText=new ArrayList<String>();
		Thread.sleep(5000);
		for(int i=0;i<=totalSize.size()-1;i++) {
			totalSize=driver.findElements(By.xpath("//div[@class='slds-grid slds-wrap slds-gutters']/div//h2//span/span"));
			driver.executeScript("arguments[0].scrollIntoView();",totalSize.get(i));
			String text=totalSize.get(i).getText().trim();
			totalText.add(text);
		}
		for (String string : totalText) {
			System.out.println(string);	
		}

		boolean sorted=	Ordering.natural().isOrdered(totalText);
		System.out.println(sorted);

	}

}
