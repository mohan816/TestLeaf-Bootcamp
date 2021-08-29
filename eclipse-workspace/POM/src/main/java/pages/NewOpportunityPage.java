package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class NewOpportunityPage extends BaseClass {
	public NewOpportunityPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
	}
	
	public String value;
	
	public NewOpportunityPage enterOpportunityName(String textbox) throws InterruptedException {
	WebElement opportunityName=	driver.findElement(By.xpath("//input[@name='Name']"));
	opportunityName.sendKeys(textbox);
	value=opportunityName.getAttribute("value");
	System.out.println(value);
	return this;
	}
	public NewOpportunityPage sendValueToCLoseDate(String Date) {
		WebElement click=driver.findElement(By.xpath("//input[@name='CloseDate']"));
		click.click();
		click.sendKeys(Date);
		return this;
	}
	public NewOpportunityPage selectNeedAnalysisInStage() {
		WebElement sDroplist=driver.findElement(By.xpath("(//div[@role='none'])[3]"));
		driver.executeScript("arguments[0].click()",sDroplist);	
		WebElement stageDroplist=driver.findElement(By.xpath("//label[text()='Stage']/following::span[@title='Needs Analysis']"));
		stageDroplist.click();
		return this;	
	}
	public OpportunityPage clickSave() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		return new OpportunityPage(driver);
	}
	
}
