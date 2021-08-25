package week1.venniala_scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CreateAccounts extends BaseClass {
	@BeforeClass
	public void setFileName() {
		FileName="Accounts";
	}
	@Test(dataProvider="fetchData")
	public void createAccount(String userName, String Password, String name1) {
		WebElement user=driver.findElementById("username");
		user.sendKeys(userName, Keys.TAB);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementById("Login").click();
		driver.findElement(By.xpath("(//div[@class='slds-icon-waffle']//div)[2]")).click();
		WebElement viewAll=	driver.findElementByXPath("(//button[text()='View All'])");
		viewAll.click();
		WebElement accountClick=driver.findElementByXPath("(//p[text()='Accounts'])");
		driver.executeScript("arguments[0].scrollIntoView();",accountClick);
		driver.executeScript("arguments[0].click()",accountClick);
		driver.findElement(By.xpath("//div[text()='New']")).click();
		driver.findElement(By.xpath("//input[@name='Name']")).sendKeys("Mohanrajan");
		WebElement ownershipDroplist=driver.findElement(By.xpath("(//div[@role='none'])[5]"));
		driver.executeScript("arguments[0].scrollIntoView();",ownershipDroplist);
		driver.executeScript("arguments[0].click()",ownershipDroplist);
		driver.findElement(By.xpath("//span[text()='Public']")).click();
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
		driver.findElement(By.xpath("//a[text()='Details']")).click();
		String name=name1;
		String expected=driver.findElement(By.xpath("//lightning-formatted-text[text()='Mohanrajan']")).getText();
		System.out.println(expected);
		if(name.equals(expected)) {
			System.out.println("Account is Created with name"+" "+expected);
		}






		/*WebElement ele1=driver.findElement(By.xpath("//p[text()='Dashboards']"));
        driver.executeScript();
        driver.executeScript("arguments[0].click()",ele1);
		/JavascriptExecutor js=(JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,350)", "");
		 */
		/*
		 * Actions action=new Actions(driver);
		 * action.moveToElement(accountClick).click(accountClick).build().perform();
		 */
















	}

}
