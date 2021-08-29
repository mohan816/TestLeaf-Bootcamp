package pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import base.BaseClass;

public class OpportunityPage extends BaseClass{
	public OpportunityPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}

	
	public NewOpportunityPage clickNew() {
		driver.findElement(By.xpath("//div[text()='New']")).click();
		return new NewOpportunityPage(driver,prop);
	}
	public OpportunityPage enterValueInSerachTextBox(String textbox) throws InterruptedException {
		driver.findElement(By.xpath("//input[@name='Opportunity-search-input']")).sendKeys(textbox,Keys.ENTER);
		WebElement ourName=driver.findElement(By.xpath("//a[@title='"+textbox+"']"));
		Actions action=new Actions(driver);
		action.moveToElement(ourName);
		//click droplist
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='"+textbox+"']/following::div[@data-aura-class='forceVirtualAction'][1]")).click();
		return this;
	}
	public EditOpportunity clickEdit() throws InterruptedException {
		Thread.sleep(10000);
		WebElement clickEdit=driver.findElement(By.xpath("//a[@title='Edit']/div"));
		driver.executeScript("arguments[0].click()", clickEdit);
		return new EditOpportunity(driver,prop);
	}
	
	public OpportunityPage verifySuccessMessage(String textbox) throws InterruptedException {
		Thread.sleep(5000);
		String successMessage=driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(successMessage);
		String replaced=successMessage.replace("\"", "");
		String[] split = replaced.split(" ");
		System.out.println(split[1]);
		if(textbox.equals(split[1])) {
			System.out.println("Opportunity is successfully created");
		}
		else {
			System.out.println("Opportunity is not created");
		}
		
		return this;	
	}
	public OpportunityPage clickOpportunityName(String textbox) throws InterruptedException {
		Thread.sleep(5000);
		WebElement ourName1=driver.findElement(By.xpath("//a[@title='"+textbox+"']"));
		driver.executeScript("arguments[0].click()", ourName1);
		Thread.sleep(5000);
		return this;
	}
	public OpportunityPage clickDetails() {
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		return this;
	}
	public OpportunityPage verifyOpportunityIsEdited(String droplist) {
		String dropListValue=driver.findElement(By.xpath("//lightning-formatted-text[text()='"+droplist+"']")).getText();
		if(dropListValue.equals("Perception Analysis")) {
			System.out.println("Opportunity is edited successfully");
		}
		else {
			System.out.println("Opportunity is not edited");
		}
		return this;
	}

}
