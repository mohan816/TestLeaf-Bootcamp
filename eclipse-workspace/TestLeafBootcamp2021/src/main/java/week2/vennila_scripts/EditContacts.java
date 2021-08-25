package week2.vennila_scripts;

import java.util.ArrayList;
import java.util.List;
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
import utils.BaseClassData;
import week1.venniala_scripts.BaseClass;

public class EditContacts extends BaseClassData{
	@SuppressWarnings("unused")
	@BeforeClass
	public void setFileName() {
		FileName="EditContacts";
	}
	@Test(dataProvider="fetchData")
	public void editontacts(String userName, String Password) throws InterruptedException {

		WebElement user=driver.findElementById("username");
		user.sendKeys(userName, Keys.TAB);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementById("Login").click();
		driver.findElement(By.xpath("(//div[@class='slds-icon-waffle']//div)[2]")).click();
		Thread.sleep(5000);
		WebElement viewAll=	driver.findElementByXPath("(//button[text()='View All'])");
		viewAll.click();
		//click contacts
		WebElement clickContacts=driver.findElement(By.xpath("//p[text()='Contacts']"));
		driver.executeScript("arguments[0].scrollIntoView();", clickContacts);
		driver.executeScript("arguments[0].click()", clickContacts);
		Thread.sleep(5000);
		List<WebElement> totalContacts=driver.findElements(By.xpath("//th[@class='slds-cell-edit lockTrigger cellContainer']//a"));
		driver.executeScript("arguments[0].scrollIntoView();",totalContacts.get(totalContacts.size()-1));
		List<WebElement>overAllContacts=driver.findElements(By.xpath("//th[@class='slds-cell-edit lockTrigger cellContainer']//a"));
		System.out.println(overAllContacts.size());
		Thread.sleep(5000);
		List<String> nameContacts=new ArrayList<String>();
		for(int i=0;i<overAllContacts.size();i++) {
			driver.executeScript("arguments[0].scrollIntoView();",overAllContacts.get(i));
			String contactsName=overAllContacts.get(i).getText().trim();
			System.out.println(contactsName);
			nameContacts.add(contactsName);
		}
		for(int i=0;i<nameContacts.size();i++) {
			for(int j=i+1;j<nameContacts.size();j++) {
				if(nameContacts.get(i).equals(nameContacts.get(j))) {
					System.out.println(nameContacts.get(i));
					System.out.println("duplicate Value is present");
				}
				else{
					driver.executeScript("arguments[0].scrollIntoView();",overAllContacts.get(i));
					driver.findElement(By.xpath("//input[@name='Contact-search-input']")).sendKeys(nameContacts.get(i), Keys.ENTER);
					break;	
				}
			}
			break;
		}
		Thread.sleep(5000);
		WebElement contactName=driver.findElement(By.xpath("//th[@data-aura-class='forceInlineEditCell']"));
		Actions action=new Actions(driver);
		action.moveToElement(contactName).perform();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//th[@data-aura-class='forceInlineEditCell']/following::div[@data-aura-class='forceVirtualAction']")).click();
		//Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@title='Edit']")).click();
		WebElement title=driver.findElement(By.xpath("//input[@name='Title']"));
		title.clear();
		title.sendKeys("Edited the Contact");
		WebElement birthDate=driver.findElement(By.xpath("//input[@name='Birthdate']"));
		driver.executeScript("arguments[0].scrollIntoView();",birthDate);
		driver.executeScript("arguments[0].click()", birthDate);
		birthDate.clear();
		birthDate.sendKeys("10/25/1996");
		driver.findElement(By.xpath("(//label[text()='Lead Source']/following::div[@class='slds-form-element__control'])[1]")).click();
		driver.findElement(By.xpath("//label[text()='Lead Source']/following::span[text()='Purchased List']")).click();
		WebElement mobilePhone=driver.findElement(By.xpath("//input[@name='Phone']"));
		driver.executeScript("arguments[0].scrollIntoView();",mobilePhone);
		driver.executeScript("arguments[0].click()", mobilePhone);
		mobilePhone.clear();
		mobilePhone.sendKeys("8940042534");
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		Thread.sleep(5000);
		String phoneNumber=driver.findElement(By.xpath("//th[@data-aura-class='forceInlineEditCell']/following::span[@class='forceOutputPhone slds-truncate']")).getText();
		//System.out.println(phoneNumber);
		String numberToVerify="(894) 004-2534";
		if(phoneNumber.equals(numberToVerify)) {
			System.out.println("Phone Number is verified" +" "+phoneNumber);
		}


	}
}


