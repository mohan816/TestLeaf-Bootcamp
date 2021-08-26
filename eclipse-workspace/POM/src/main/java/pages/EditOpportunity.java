package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class EditOpportunity extends BaseClass {
	
	public EditOpportunity(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public EditOpportunity enterCloseDate(String Date) {
		WebElement closeDate=driver.findElement(By.xpath("//input[@name='CloseDate']"));
		driver.executeScript("arguments[0].click()", closeDate);
		closeDate.clear();
		closeDate.sendKeys(Date);
		return this;
	}
	public EditOpportunity clickStage() {
		driver.findElement(By.xpath("//label[text()='Stage']/following::lightning-base-combobox[1]")).click();
		WebElement dropListPerception=driver.findElement(By.xpath("//label[text()='Stage']/following::span[@title='Perception Analysis']"));
		driver.executeScript("arguments[0].click()",dropListPerception);
		return this;
	}
	public EditOpportunity clickDeliveryInstallation() {
		WebElement deliveryDroplist=driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following::input[1]"));
		driver.executeScript("arguments[0].scrollIntoView();", deliveryDroplist);
		driver.executeScript("arguments[0].click()",deliveryDroplist);
		driver.findElement(By.xpath("//label[text()='Delivery/Installation Status']/following::span[text()='In progress']")).click();
		return this;
	}
	public EditOpportunity enterDescription() {
		driver.findElement(By.xpath("//textarea[@class='slds-textarea']")).sendKeys("Salesforce");
		return this;
		
	}
	public OpportunityPage clickSave() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		return new OpportunityPage(driver);
	}

}
