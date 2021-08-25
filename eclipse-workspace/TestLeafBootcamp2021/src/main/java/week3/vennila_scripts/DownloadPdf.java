package week3.vennila_scripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadPdf {

	public static void main(String[] args) throws InterruptedException { 
		WebDriverManager.chromedriver().setup();
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		//  chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("plugins.always_open_pdf_externally", true);
		chromePrefs.put("download.default_directory", "C:\\Mohan");
		//   chromePrefs.put("safebrowsing.enabled", "false");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("makaia@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("SelBootcamp$123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(10000);
		//click left scroll
		WebElement scrollView = driver.findElement(By.xpath("//button[contains(@class,'slds-button')]/span[text()='Scroll Left']"));
		driver.executeScript("arguments[0].click()",scrollView);
		Thread.sleep(5000);
		WebElement scrollView1 = driver.findElement(By.xpath("//button[contains(@class,'slds-button')]/span[text()='Scroll Left']"));
		driver.executeScript("arguments[0].click()",scrollView1);
		//click getStarted
		Thread.sleep(5000);
		WebElement getStarted= driver.findElement(By.xpath("(//span[text()='Learn all about the current Salesforce release.']/following::div[@class='tileNavButton']/button)[1]"));
		driver.executeScript("arguments[0].click()",getStarted);
		Thread.sleep(10000);
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> handle=new ArrayList<String>(windowHandles);
		driver.switchTo().window(handle.get(1));
		WebElement popButton = driver.findElement(By.xpath("//button[text()='OK']"));
		driver.executeScript("arguments[0].click()",popButton);
		Thread.sleep(10000);
		//click droplist
		WebElement dropList=driver.findElement(By.xpath("//input[@class='slds-input slds-combobox__input']"));
		driver.executeScript("arguments[0].scrollIntoView();",dropList);
		driver.executeScript("arguments[0].click()", dropList);
		driver.findElement(By.xpath("(//div[contains(@class,'slds-listbox')]//span[contains(@title,'20')])[1]")).click();
		driver.findElement(By.xpath("//button[@title='Open PDF']")).click();
	}

}
