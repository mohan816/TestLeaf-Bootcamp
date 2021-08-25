package week3.vennila_scripts;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import week1.venniala_scripts.BaseClass;

public class Assessment1 extends BaseClass {
	@BeforeClass
	public void setFileName() {
		FileName="assessment1";
	}
	@Test(dataProvider="fetchData")
	public void assessment1(String name) throws AWTException, InterruptedException {
		driver.manage().window().maximize();
		WebElement user = driver.findElementById("username");
		user.sendKeys("makaia@testleaf.com", Keys.TAB);
		driver.findElementById("password").sendKeys("SelBootcamp$123");
		driver.findElementById("Login").click();
		driver.findElement(By.className("slds-icon-waffle")).click();
		//click Community
		driver.findElement(By.xpath("//a[text()='Community']")).click();
		List<WebElement> lightingName = driver.findElements(By.xpath("//div[text()='Lightning']/ancestor::td/preceding-sibling::td[3]"));
		driver.executeScript("arguments[0].scrollIntoView();", lightingName.get(lightingName.size()-1));
		driver.executeScript("arguments[0].click()", lightingName.get(lightingName.size()-1));
		List<WebElement> lightingName1 = driver.findElements(By.xpath("//div[text()='Lightning']/ancestor::td/preceding-sibling::td[3]"));
		List<WebElement>appName=driver.findElements(By.xpath("//div[text()='Lightning']/ancestor::td/preceding-sibling::th"));
		System.out.println(lightingName1.size());
		for(int i=0;i<lightingName1.size();i++) {
			driver.executeScript("arguments[0].scrollIntoView();", lightingName1.get(i));
			String text1=appName.get(i).getText();
			System.out.print(text1);
			System.out.print("  ");
			String text=lightingName1.get(i).getText();
			System.out.print(text);
			System.out.println();
		}
		driver.findElement(By.xpath("//span[@class='uiImage']")).click();
		driver.findElement(By.xpath("//a[text()='Switch to Salesforce Classic']")).click();
		driver.findElement(By.id("createNewButton")).click();
		driver.findElement(By.xpath("//a[text()='Event']")).click();
		driver.findElement(By.xpath("//input[@id='evt5']")).sendKeys(name);
		String startDate=LocalDate.now().plusDays(1).format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		driver.findElement(By.xpath("//input[@id='StartDateTime']")).clear();
		driver.findElement(By.xpath("//input[@id='StartDateTime']")).sendKeys(startDate);
		String endDate=LocalDate.now().plusDays(2).format(DateTimeFormatter.ofPattern("M/d/yyyy"));
		driver.findElement(By.xpath("//input[@id='EndDateTime']")).clear();
		driver.findElement(By.xpath("//input[@id='EndDateTime']")).sendKeys(endDate);
		driver.findElement(By.xpath("//a[@title='Name Lookup (New Window)']")).click();
		Set<String> windows=driver.getWindowHandles();
		List<String> win=new ArrayList<String>(windows);
		driver.switchTo().window(win.get(1));
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("aa bb");
		driver.findElement(By.xpath("//input[@name='go']")).click();
		driver.switchTo().defaultContent();
		driver.switchTo().frame("resultsFrame");
		driver.findElement(By.xpath("//th[@scope='row']/a")).click();
		driver.switchTo().window(win.get(0));
		driver.findElement(By.xpath("//input[@value='Attach File']")).click();
		Set<String> windows1=driver.getWindowHandles();
		List<String> win1=new ArrayList<String>(windows1);
		driver.switchTo().window(win1.get(1));
		driver.findElement(By.xpath("//input[@id='file']")).sendKeys("C:\\Mohan\\PostMan_API_TestCases.pdf");
		driver.findElement(By.xpath("//input[@id='Attach']")).click();
		driver.findElement(By.xpath("//input[@name='cancel']")).click();
		driver.switchTo().window(win1.get(0));
		String uploadedFile=driver.findElement(By.xpath("(//span[@class='advisory'])[1]")).getText();
		System.out.println(uploadedFile);
		String fileName="PostMan_API_TestCases.pdf";
		if(fileName.equalsIgnoreCase(uploadedFile)) {
			System.out.println("Verified the file name");
		}
		else {
			System.out.println("Not Verified");
		}
		
		WebElement saveButton=driver.findElement(By.xpath("(//input[@name='save'])[1]"));
		driver.executeScript("arguments[0].scrollIntoView();", saveButton);
		driver.executeScript("arguments[0].click()", saveButton);
		
		}
}




