package week1.venniala_scripts;

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

public class EditOpportunity extends BaseClass {
	@BeforeClass
	public void setFileName() {
		FileName="CreateOpportunity";
	}
	@Test(dataProvider="fetchData")
	public void EditOpportunity(String userName, String Password) throws InterruptedException {
		//click togge
		WebElement user=driver.findElementById("username");
		user.sendKeys(userName, Keys.TAB);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementById("Login").click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click sales
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//click opportunities
		WebElement clickOpportunity=driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click()",clickOpportunity);
		Thread.sleep(5000);
		//Search Opportunity
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys("Salesforce Automation By Mohan",Keys.ENTER);
		//click value with our name
		WebElement ourName=driver.findElement(By.xpath("//a[@title='Salesforce Automation By Mohan']"));
		Actions action=new Actions(driver);
		action.moveToElement(ourName);
		//click droplist
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Salesforce Automation By Mohan']/following::div[@data-aura-class='forceVirtualAction'][1]")).click();
		//click Edit
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		//enter value in closedate
		Thread.sleep(5000);
		WebElement closeDate=driver.findElement(By.xpath("//input[@name='CloseDate']"));
		driver.executeScript("arguments[0].click()", closeDate);
		closeDate.clear();
		closeDate.sendKeys("7/31/2021");
		driver.findElement(By.xpath("//label[text()='Stage']/following::lightning-base-combobox[1]")).click();
		WebElement dropListPerception=driver.findElement(By.xpath("//label[text()='Stage']/following::span[@title='Perception Analysis']"));
		driver.executeScript("arguments[0].click()",dropListPerception);
		WebElement deliveryDroplist=driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following::input[1]"));
		driver.executeScript("arguments[0].scrollIntoView();", deliveryDroplist);
		driver.executeScript("arguments[0].click()",deliveryDroplist);
		driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following::span[text()='In progress']")).click();
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Salesforce");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		//driver.findElement(By.xpath("(//li[@title='Details'])[3]")).click();
		Thread.sleep(5000);
		WebElement ourName1=driver.findElement(By.xpath("//a[@title='Salesforce Automation By Mohan']"));
		driver.executeScript("arguments[0].click()", ourName1);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		String dropListValue=driver.findElement(By.xpath("//lightning-formatted-text[text()='Perception Analysis']")).getText();
		if(dropListValue.equals("Perception Analysis")) {
			System.out.println("Opportunity is edited successfully");
		}
		else {
			System.out.println("Opportunity is not edited");
		}



	}

}
