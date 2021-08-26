package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class EditAccountPage extends BaseClass {
	
	public EditAccountPage(ChromeDriver driver) {
		this.driver=driver;
	}
	public EditAccountPage selectTypeDroplist() throws InterruptedException {
	driver.findElement(By.xpath("(//label[text()='Type']/following::div[@role='none'])[1]")).click();
	 Thread.sleep(10000);
	 driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
	 return this;
}
	public EditAccountPage selectTechnologydroplist() {
	WebElement industryDroplist=driver.findElement(By.xpath("(//label[text()='Industry']/following::div[@role='none'])[1]"));
	 driver.executeScript("arguments[0].scrollIntoView();",industryDroplist);
	 driver.executeScript("arguments[0].click()",industryDroplist);
	 driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
	 return this;
	}
	public EditAccountPage enterBillingStreet() {
		driver.findElement(By.xpath("(//textarea[@autocomplete='street-address'])[1]")).sendKeys("gudiyatham");
		return this;
	}
	public EditAccountPage enterShippingStreet() {
		driver.findElement(By.xpath("(//textarea[@autocomplete='street-address'])[2]")).sendKeys("vellore");
		return this;
	}
	public EditAccountPage selectCustomerPriority() {
		WebElement customerDroplist=driver.findElement(By.xpath("(//label[text()='Customer Priority']/following::div[@role='none'])[1]"));
		 driver.executeScript("arguments[0].scrollIntoView();",customerDroplist);
		 driver.executeScript("arguments[0].click()",customerDroplist);
		 driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']")).click();
		return this;
	}
	public EditAccountPage selectSLA() {
		WebElement slaDropList=driver.findElement(By.xpath("(//label[text()='SLA']/following::div[@role='none'])[1]"));
		 driver.executeScript("arguments[0].scrollIntoView();",slaDropList);
		 driver.executeScript("arguments[0].click()",slaDropList);
		 driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Silver']")).click();
		return this;
	}
	public EditAccountPage selectActive() {
		WebElement activeDroplist=driver.findElement(By.xpath("(//label[text()='Active']/following::div[@role='none'])[1]"));
		 driver.executeScript("arguments[0].scrollIntoView();",activeDroplist);
		 driver.executeScript("arguments[0].click()",activeDroplist);
		 driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
		return this;
	}
	public EditAccountPage enterPhone() {
		driver.findElement(By.xpath("//input[@name='Phone']")).clear();
		 WebElement phone=driver.findElement(By.xpath("//input[@name='Phone']"));
		 driver.executeScript("arguments[0].scrollIntoView();",phone);
		 phone.sendKeys("8940042534");
		return this;
	}
	public EditAccountPage selectUpsellOpportunity() {
		WebElement upsellOpportunity=driver.findElement(By.xpath("(//label[text()='Upsell Opportunity']/following::div[@role='none'])[1]"));
		 driver.executeScript("arguments[0].scrollIntoView();",upsellOpportunity);
		 driver.executeScript("arguments[0].click()",upsellOpportunity);
		 driver.findElement(By.xpath("(//lightning-base-combobox-item[@data-value='No'])[1]")).click();
		return this;
	}
	public AccountPage clickSave() throws InterruptedException {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(5000);
		return new AccountPage(driver);
		
		
	}
}