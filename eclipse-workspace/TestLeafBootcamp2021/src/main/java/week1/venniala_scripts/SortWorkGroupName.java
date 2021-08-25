package week1.venniala_scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import com.google.common.collect.Ordering;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SortWorkGroupName extends BaseClass {

	public void sortWorkGroupName() throws InterruptedException {
		
		//click toggle
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
		//click View All
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click Work Group Type
		WebElement workTypeGroup=driver.findElement(By.xpath("//p[text()='Work Type Groups']"));
		driver.executeScript("arguments[0].scrollIntoView();" ,workTypeGroup);
		driver.executeScript("arguments[0].click()",workTypeGroup);
		//Click work list droplist
		driver.findElement(By.xpath("//button[@title='Select List View']")).click();
		driver.findElement(By.xpath("//a[@role='option']//span[text()='All Work Type Groups']")).click();
		//droplist sort
		WebElement sort=driver.findElement(By.xpath("//th[@title='Work Type Group Name']"));
		Actions action=new Actions(driver);
		action.moveToElement(sort).click(sort);
		//Getting headers in the list
		Thread.sleep(5000);
		List<WebElement> WorkTypeGroupNames=driver.findElements(By.xpath("//th[@class='slds-cell-edit cellContainer']//a"));
		System.out.println(WorkTypeGroupNames.size());
		List<String> list=new ArrayList<String>();
		for(int i=0;i<WorkTypeGroupNames.size();i++) {
			driver.executeScript("arguments[0].scrollIntoView();",WorkTypeGroupNames.get(i));
			String eachListValue=WorkTypeGroupNames.get(i).getText();
			list.add(eachListValue);	}
		System.out.println(list);
		boolean sorted = Ordering.natural().isOrdered(list);
		System.out.println(sorted);
	}

}
