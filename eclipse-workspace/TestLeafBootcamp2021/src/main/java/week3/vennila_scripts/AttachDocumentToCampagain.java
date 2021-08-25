package week3.vennila_scripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AttachDocumentToCampagain {
@Parameters({"url","username","password"})
@Test
	public void AttachDocument(String url, String username, String password) throws AWTException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
		WebElement user=driver.findElementById("username");
		user.sendKeys(username, Keys.TAB);
		driver.findElementById("password").sendKeys(password);
		driver.findElementById("Login").click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//div[@class='slds-icon-waffle']//div)[2]")).click();
		WebElement viewAll=	driver.findElementByXPath("(//button[text()='View All'])");
		viewAll.click();
		//Click Sales
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		WebElement campaigns=driver.findElement(By.xpath("//span[text()='Campaigns']"));
		driver.executeScript("arguments[0].click", campaigns);
		driver.findElement(By.xpath("(//a[text()='Bootcamp'])[1]")).click();
		driver.findElement(By.xpath("//div[text()='Upload Files']")).click();
		String file="C:\\Mohan\\PostMan_API_TestCases.pdf";
		StringSelection selection=new StringSelection(file);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		Robot robot=new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//span[text()='Done']/parent::button")).click();
		String toVerifyFileAdded=driver.findElement(By.xpath("//span[@data-aura-class='forceActionsText']")).getText();
		System.out.println(toVerifyFileAdded);
		driver.findElement(By.xpath("//span[text()='Attachments']")).click();
		Thread.sleep(5000);
		WebElement link=driver.findElement(By.xpath("(//span[text()='PostMan_API_TestCases']/ancestor::a[contains(@class,'slds-resizable')])[1]"));
		System.out.println(link.getAttribute("href"));


	}

}
