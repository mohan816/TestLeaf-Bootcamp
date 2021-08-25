package week3.vennila_scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewAppointments {

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
		Thread.sleep(10000);
		WebElement viewAll = driver.findElementByXPath("(//button[text()='View All'])");
		viewAll.click();
		WebElement serviceAppointments=driver.findElement(By.xpath("//p[text()='Service Appointments']"));
		driver.executeScript("arguments[0].scrollIntoView();", serviceAppointments);
		driver.executeScript("arguments[0].click()", serviceAppointments);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//span[text()='Description']/following::textarea[@class=' textarea']")).sendKeys("Creating Service Appointments");
		driver.findElement(By.xpath("//input[@title='Search Accounts']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'createNew')]")).click();
		WebElement accountName=driver.findElement(By.xpath("//span[text()='Account Name']/following::input[@type='text'][1]"));
		accountName.sendKeys("Mohanrajan");
		accountName.getAttribute("value");
		Thread.sleep(5000);
		WebElement saveButton=	driver.findElement(By.xpath("(//button[contains(@class,'slds-button')]/span[text()='Save'])[1]"));
		driver.executeScript("arguments[0].click()", saveButton);
		driver.findElement(By.xpath("//button[@title='OK']")).click();
		Thread.sleep(10000);
		WebElement saveButton1=driver.findElement(By.xpath("(//button[contains(@class,'slds-button')]/span[text()='Save'])[1]"));
		Actions action=new Actions(driver);
		action.moveToElement(saveButton1).click();
		driver.findElement(By.xpath("//span[@class='pillText']"));
		String getText=driver.findElement(By.xpath("//span[@class='pillText']")).getText();
		if(accountName.getAttribute("value").equals(getText)) {
			System.out.println(getText);
		}
		driver.findElement(By.xpath("(//label[text()='Date']/following::span[text()='Date Picker'])[1]")).click();
		driver.findElement(By.xpath("//td[@class='slds-is-today uiDayInMonthCell']")).click();
		driver.findElement(By.xpath("(//div[@class='dateTime-inputTime form-element form-element__control']//input[@class=' input'])[1]")).click();
        




	}

}
