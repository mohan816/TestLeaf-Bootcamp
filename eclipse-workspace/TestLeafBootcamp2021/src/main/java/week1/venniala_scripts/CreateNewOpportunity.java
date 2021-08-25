package week1.venniala_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateNewOpportunity extends BaseClass {
	@BeforeClass
	public void setFileName() {
		FileName="CreateOpportunity";
	}
	@Test(dataProvider="fetchData")
	public void createNewOpportunity(String userName, String Password, String texbox) throws InterruptedException {
		WebElement user=driver.findElementById("username");
		user.sendKeys(userName, Keys.TAB);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementById("Login").click();
		//click toggle
		driver.findElement(By.xpath("//div[@data-aura-class='uiTooltip']/div[@class='slds-icon-waffle']")).click();
		//click view All
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click sales
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//click opportunities
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@role='list']/one-app-nav-bar-item-root[2]")).click();
		//click new button
		driver.findElement(By.xpath("//div[text()='New']")).click();
		//opportunity Name
		WebElement opportunityName=	driver.findElement(By.xpath("//input[@name='Name']"));
		opportunityName.sendKeys(texbox);
		String value=opportunityName.getAttribute("value");
		System.out.println(value);
		//Select the date textbox
		WebElement click=driver.findElement(By.xpath("//input[@name='CloseDate']"));
		click.click();
		click.sendKeys("7/26/2021");
		Thread.sleep(5000);
		WebElement sDroplist=driver.findElement(By.xpath("(//div[@role='none'])[3]"));
		driver.executeScript("arguments[0].click()",sDroplist);		
		/*
		 * WebElement sDroplist=driver.findElement(By.xpath(
		 * "//label[text()='Stage']/following-sibling::div[@class='slds-form-element__control']"
		 * )); driver.executeScript("arguments[0].click()",sDroplist);
		 */
		WebElement stageDroplist=driver.findElement(By.xpath("//label[text()='Stage']/following::span[@title='Needs Analysis']"));
		stageDroplist.click();
		//click save
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(5000);
		//div[text()='']
		String successMessage=driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(successMessage);
		String replaced=successMessage.replace("\"", "");
		String subString=replaced.substring(12,47);
		if(value.equals(subString)) {
			System.out.println("Opportunity is successfully created");
		}
		else {
			System.out.println("Opportunity is not created");
		}


		//label[text()='Stage']/following::span[text()='Needs Analysis']

		//input[@name='CloseDate']//following







	}

}
