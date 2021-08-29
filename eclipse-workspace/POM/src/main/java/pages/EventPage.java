package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class EventPage extends BaseClass {
	public String uploadedFile;

	public EventPage(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
	}
	public EventPage enterName(String name) {
		driver.findElement(By.xpath("//input[@id='evt5']")).sendKeys(name);
		return this;
	}
	public EventPage enetrStart() {
		String startDate=LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		driver.findElement(By.xpath("//input[@id='StartDateTime']")).clear();
		driver.findElement(By.xpath("//input[@id='StartDateTime']")).sendKeys(startDate);
		return this;
	}
	public EventPage enterEnd() {
		String endDate=LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		driver.findElement(By.xpath("//input[@id='EndDateTime']")).clear();
		driver.findElement(By.xpath("//input[@id='EndDateTime']")).sendKeys(endDate);
		return this;	
	}
	public LookUpPage clickLookUp() {
		driver.findElement(By.xpath("//a[@title='Name Lookup (New Window)']")).click();
		return new LookUpPage(driver);
	}
	public AttachFile clickAttachFile() {
		driver.findElement(By.xpath("//input[@value='Attach File']")).click();
		return new AttachFile(driver,prop);
	}
	public EventPage getAttachmentText() {
		uploadedFile=driver.findElement(By.xpath("(//span[@class='advisory'])[1]")).getText();
		System.out.println(uploadedFile);
		return this;
	}
	public EventPage verifyFileName() {
		String fileName="PostMan_API_TestCases.pdf";
		if(fileName.equalsIgnoreCase(uploadedFile)) {
			System.out.println("Verified the file name");
		}
		else {
			System.out.println("Not Verified");
		}
		return this;
	}
	public EventPage clickSave() {
		WebElement saveButton=driver.findElement(By.xpath("(//input[@name='save'])[1]"));
		driver.executeScript("arguments[0].scrollIntoView();", saveButton);
		driver.executeScript("arguments[0].click()", saveButton);
		return this;
	}
}
