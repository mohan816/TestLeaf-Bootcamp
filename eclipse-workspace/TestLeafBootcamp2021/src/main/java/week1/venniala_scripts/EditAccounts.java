package week1.venniala_scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class EditAccounts extends BaseClass {
	@BeforeClass
	public void setFileName() {
		FileName="EditAccounts";
	}
	@Test(dataProvider="fetchData")
	public void editAccounts(String userName, String Password) throws InterruptedException{
		WebElement user=driver.findElementById("username");
		user.sendKeys(userName, Keys.TAB);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementById("Login").click();
        driver.findElement(By.className("slds-icon-waffle")).click();
		Thread.sleep(5000);
		WebElement viewAll = driver.findElementByXPath("(//button[text()='View All'])");
		viewAll.click();
		WebElement accountClick = driver.findElementByXPath("(//p[text()='Accounts'])");
		driver.executeScript("arguments[0].scrollIntoView();", accountClick);
		driver.executeScript("arguments[0].click()", accountClick);
		Thread.sleep(5000);
		WebElement textBox=	 driver.findElement(By.xpath("//input[@class='slds-input']"));
		textBox.sendKeys("Mohanrajan",Keys.ENTER);
		Thread.sleep(5000);
		WebElement dropList= driver.findElement(By.xpath("(//a[@title='Mohanrajan'])[1]//ancestor::tr/td[6]"));
		 dropList.click();
		 driver.findElement(By.xpath("//a[@title='Edit']")).click();
		 driver.findElement(By.xpath("(//label[text()='Type']/following::div[@role='none'])[1]")).click();
		 Thread.sleep(10000);
		 driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
		 WebElement industryDroplist=driver.findElement(By.xpath("(//label[text()='Industry']/following::div[@role='none'])[1]"));
		 driver.executeScript("arguments[0].scrollIntoView();",industryDroplist);
		 driver.executeScript("arguments[0].click()",industryDroplist);
		 driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Healthcare']")).click();
		 driver.findElement(By.xpath("(//textarea[@autocomplete='street-address'])[1]")).sendKeys("gudiyatham");
		 driver.findElement(By.xpath("(//textarea[@autocomplete='street-address'])[2]")).sendKeys("vellore");
		 WebElement customerDroplist=driver.findElement(By.xpath("(//label[text()='Customer Priority']/following::div[@role='none'])[1]"));
		 driver.executeScript("arguments[0].scrollIntoView();",customerDroplist);
		 driver.executeScript("arguments[0].click()",customerDroplist);
		 driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Low']")).click();
		 WebElement slaDropList=driver.findElement(By.xpath("(//label[text()='SLA']/following::div[@role='none'])[1]"));
		 driver.executeScript("arguments[0].scrollIntoView();",slaDropList);
		 driver.executeScript("arguments[0].click()",slaDropList);
		 driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='Silver']")).click();
		 WebElement activeDroplist=driver.findElement(By.xpath("(//label[text()='Active']/following::div[@role='none'])[1]"));
		 driver.executeScript("arguments[0].scrollIntoView();",activeDroplist);
		 driver.executeScript("arguments[0].click()",activeDroplist);
		 driver.findElement(By.xpath("//lightning-base-combobox-item[@data-value='No']")).click();
		 driver.findElement(By.xpath("//input[@name='Phone']")).clear();
		 WebElement phone=driver.findElement(By.xpath("//input[@name='Phone']"));
		 driver.executeScript("arguments[0].scrollIntoView();",phone);
		 phone.sendKeys("8940042534");
		 
		 /*
		  * WebElement phon1=driver.findElement(By.xpath("//input[@name='Phone']"));
		  * phon1.click(); phon1.sendKeys("8940042534");
		  */
		 WebElement upsellOpportunity=driver.findElement(By.xpath("(//label[text()='Upsell Opportunity']/following::div[@role='none'])[1]"));
		 driver.executeScript("arguments[0].scrollIntoView();",upsellOpportunity);
		 driver.executeScript("arguments[0].click()",upsellOpportunity);
		 driver.findElement(By.xpath("(//lightning-base-combobox-item[@data-value='No'])[1]")).click();
		 driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		 Thread.sleep(5000);
		 driver.findElement(By.xpath("(//a[@title='Mohanrajan'])[1]")).click();
		 driver.findElement(By.xpath("//a[text()='Details']")).click();
		 String phoneNumber="(894) 004-2534";
		 String numberPhone=driver.findElement(By.xpath("(//a[text()='"+phoneNumber+"'])[1]")).getText();
		 System.out.println(numberPhone);	
		 if(phoneNumber.equals(numberPhone)) {
			 System.out.println("Account Edited Successfully");
		 }
		 else {
			 System.out.println("Account is not edited");
		 }


















		 /*
		  * Actions action=new Actions(driver); action.sendKeys(Keys.ENTER);
		  * Thread.sleep(10000);
		  * driver.findElement(By.xpath("//table[@role='grid']//tbody/tr[1]/td[6]"));
		  */
		 /*
		  * WebElement dropList= driver.findElement(By.xpath(
		  * "(//a[@title='Mohanrajan'])[1]//ancestor::tr/td[6]"));
		  * driver.executeScript("arguments[0];",dropList);
		  * driver.executeScript("arguments[0].click()",dropList);
		  */
		 //driver.findElement(By.xpath("(//table[@role='grid']//tbody/tr/td)[6]//div[contains(@class,'forceVirtualActionMarker')]//a[@title='Show 3 more actions']//lightning-primitive-icon")).click();



		 /*
		  * //driver.findElement(By.xpath("//div[text()='New']")).click();

		  * 
		  * Thread.sleep(5000);
		  * driver.findElement(By.xpath("(//a[@title='Mohanrajan'])[1]")).click();
		  * 
		  * 
		  * WebDriverWait stale=new WebDriverWait(driver,Duration.ofSeconds(30));
		  * WebElement
		  * searchClick=stale.until(ExpectedConditions.visibilityOf(driver.findElement(By
		  * .xpath("(//a[@title='Mohanrajan'])[1]")))); searchClick.click();
		  * WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
		  * WebElement
		  * droplistClick=wait.until(ExpectedConditions.visibilityOf(driver.findElement(
		  * By.xpath("//a[contains(@title,'Show')]")))); droplistClick.click();
		  * 
		  * driver.findElement(By.xpath("//a[@title='Edit']")).click();
		  * driver.findElement(By.xpath("(//div[@role='none'])[4]")).click();
		  * driver.findElement(By.xpath("//span[@title='Technology Partner']")).click();
		  * driver.findElement(By.xpath("(//div[@role='none'])[6]")).click();
		  * driver.findElement(By.xpath("//span[@title='Healthcare']")).click();
		  * driver.findElement(By.name("street")).sendKeys("Gudiyatham");
		  * driver.findElement(By.name("street")).sendKeys("Vellore");
		  */

	}

}
