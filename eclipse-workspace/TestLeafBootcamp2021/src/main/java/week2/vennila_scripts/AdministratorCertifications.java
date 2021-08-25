package week2.vennila_scripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseClassData;
import utils.ReadExcel;

public class AdministratorCertifications extends BaseClassData{
	@BeforeClass
	public void setFileName() {
		FileName="sheet1";
	}
	@Test(dataProvider="fetchData",dependsOnMethods="week1.venniala_scripts.CreateAccounts.createAccount")
	public void administratorCertifications(String userName, String Password) throws InterruptedException {

		WebElement user=driver.findElementById("username");
		user.sendKeys(userName, Keys.TAB);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementById("Login").click();
		Thread.sleep(10000);
		//click learn more
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Thread.sleep(5000);
		Set<String> allWindows=driver.getWindowHandles();
		List<String> totalList=new ArrayList<String>(allWindows);
		driver.switchTo().window(totalList.get(1));
		//Move to Element
		WebElement resources=driver.findElement(By.xpath("//button/span[text()='Resources']"));
		Actions action=new Actions(driver);
		action.moveToElement(resources).build().perform();
		//click salesforce Certification
		driver.findElement(By.xpath("//span[text()='Salesforce Certification ']/parent::a")).click();
		allWindows=driver.getWindowHandles();
		List<String> totalList1=new ArrayList<String>(allWindows);
		driver.switchTo().window(totalList1.get(2));
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[text()='Salesforce Administrator']")).click();
		List<WebElement> salesforceCertifications=driver.findElements(By.xpath("//div[contains(@class,'slds-grid ')]//div[contains(@class,'Fz(16px) ')]/a"));
		List<String> totalCertifications=new ArrayList<String>();
		for(int i=0;i<salesforceCertifications.size();i++) {
			String certification=salesforceCertifications.get(i).getText();
			System.out.println(certification);
			totalCertifications.add(certification);
		}
		List<String> certificationToVerify=new ArrayList<String>();
		certificationToVerify.add("Administrator");
		certificationToVerify.add("Advanced Administrator");
		certificationToVerify.add("CPQ Specialist");
		certificationToVerify.add("Marketing Cloud Administrator");
		certificationToVerify.add("Platform App Builder");

		boolean toVerifyCertificationsArePresent=totalCertifications.equals(certificationToVerify);
		System.out.println(toVerifyCertificationsArePresent);
	}
	
}


