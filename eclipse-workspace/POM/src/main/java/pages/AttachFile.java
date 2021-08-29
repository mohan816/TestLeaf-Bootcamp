package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class AttachFile extends BaseClass {
	
	
	public AttachFile(ChromeDriver driver,Properties prop) {
		this.driver=driver;
		this.prop=prop;
		}
	Set<String> windows1=driver.getWindowHandles();
	List<String> win1=new ArrayList<String>(windows1);
	
	public AttachFile selectFile() {
		driver.switchTo().window(win1.get(1));
		driver.findElement(By.xpath("//input[@id='file']")).sendKeys("C:\\Mohan\\PostMan_API_TestCases.pdf");
		return this;
	}
	public AttachFile clickAttachFileButton() {
		driver.findElement(By.xpath("//input[@id='Attach']")).click();
		return this;
	}
	public EventPage clickDone() {
		driver.findElement(By.xpath("//input[@name='cancel']")).click();
		driver.switchTo().window(win1.get(0));
		return new EventPage(driver,prop);
	}
}
