package week2.vennila_scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.BaseClassData;
import week1.venniala_scripts.BaseClass;

public class EditWorkTypeDebugScript extends BaseClassData{
	@BeforeClass
	public void setFileName() {
		FileName="CertificationSortOrder";
	}
	@Test(dataProvider="fetchData")

	public void editWorkType(String userName, String Password) {
		WebElement user=driver.findElementById("username");
		user.sendKeys("makaia@testleaf.com", Keys.TAB);
		driver.findElementById("password").sendKeys("SelBootcamp$123");
		driver.findElementById("Login").click();
		driver.findElement(By.className("slds-r5")).click();

		driver.findElement(By.xpath("//button[text()='View All']")).click();

		WebElement clickWorkType=driver.findElement(By.xpath("//p[text()='Work Types']"));
		driver.executeScript("arguments[0].scrollIntoView();",clickWorkType);
		driver.executeScript("arguments[0].click()", clickWorkType);
		driver.findElement(By.xpath("(//th[@data-aura-class='forceInlineEditCell']//a)[1]")).click();
		driver.findElement(By.xpath("//li[@data-aura-class='oneActionsDropDown']/div")).click();
		driver.findElement(By.xpath("//a[@title='Edit']")).click();

		WebElement textbox=driver.findElement(By.xpath("//span[text()='Work Type Name']/following::input[@class=' input']"));
		textbox.clear();
		textbox.sendKeys("Mohan");
		driver.findElement(By.xpath("(//span[text()='Save'])[2]")).click();
		System.out.println(driver.findElement(By.xpath("//span[contains(@class,'toastMessage slds-text-heading--small')]")).getText());
	}

}
