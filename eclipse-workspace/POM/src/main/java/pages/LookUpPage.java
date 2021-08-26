package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LookUpPage extends BaseClass {
	
	public LookUpPage(ChromeDriver driver) {
		this.driver=driver;	
	}
	
	Set<String> windows;
	List<String> win;
	
	public LookUpPage enterValueInSearch() {
		windows=driver.getWindowHandles();
		win=new ArrayList<String>(windows);
		driver.switchTo().window(win.get(1));
		driver.switchTo().frame("searchFrame");
		driver.findElement(By.id("lksrch")).sendKeys("aa bb");
		driver.findElement(By.xpath("//input[@name='go']")).click();
		driver.switchTo().defaultContent();
		return this;
	}
	public EventPage clickSearchResults()  {
		driver.switchTo().frame("resultsFrame");
		driver.findElement(By.xpath("//th[@scope='row']/a")).click();
		driver.switchTo().window(win.get(0));
		return new EventPage(driver);
	}

}
