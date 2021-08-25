package week1.venniala_scripts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifySorting extends BaseClass{
@Test
	public void verifySort() throws InterruptedException {
		driver.findElement(By.className("slds-icon-waffle")).click();
		Thread.sleep(5000);
		WebElement viewAll = driver.findElementByXPath("(//button[text()='View All'])");
		viewAll.click();
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		driver.findElement(By.xpath("//div[@role='list']/one-app-nav-bar-item-root[6]")).click();
	    driver.findElement(By.xpath("//span[text()='Account Name']"));
        driver.findElement(By.xpath("//th[@title='Account Name']/div")).click();
        Thread.sleep(5000);
        List<WebElement> rows=driver.findElements(By.xpath("//table[@data-aura-class='uiVirtualDataTable']//tbody/tr"));
        driver.executeScript("arguments[0].scrollIntoView();",rows.get(rows.size()-1));
        List<WebElement> rowsCount=driver.findElements(By.xpath("//table[@data-aura-class='uiVirtualDataTable']//tbody/tr"));
        System.out.println(rowsCount.size());
        Thread.sleep(5000);
        List<String> totalAccountNames=new ArrayList<String>();
        for(int i=1;i<=rowsCount.size();i++) {
        driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']//tbody/tr["+i+"]/th//a")).getText();
        System.out.println(totalAccountNames);
        	     }
        
		
	}}
         

	
 
