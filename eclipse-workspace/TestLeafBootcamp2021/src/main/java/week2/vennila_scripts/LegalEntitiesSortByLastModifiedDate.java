package week2.vennila_scripts;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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

public class LegalEntitiesSortByLastModifiedDate extends BaseClassData{
	@BeforeClass
	public void setFileName() {
		FileName="LogEntities";
	}
	@Test(dataProvider="fetchData")
	public void leagEntitiesSortByLastMOdifiedDate(String userName, String Password) throws InterruptedException, java.text.ParseException {
		/*
		 * Date date=new Date();
		 * 
		 * String date1=date.toString(); System.out.println(date1);
		 * 
		 * SimpleDateFormat formatter = new SimpleDateFormat("M/d/YYYY, hh:mm aa");
		 * System.out.println(formatter.format(date));
		 */
		
		WebElement user=driver.findElementById("username");
		user.sendKeys(userName, Keys.TAB);
		driver.findElementById("password").sendKeys(Password);
		driver.findElementById("Login").click();
		//click togge
		Thread.sleep(5000);
		driver.findElement(By.className("slds-icon-waffle")).click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement legalEntity=driver.findElement(By.xpath("//p[text()='Legal Entities']"));
		driver.executeScript("arguments[0].scrollIntoView();",legalEntity);
		driver.executeScript("arguments[0].click()", legalEntity);
		WebElement headerEntity=driver.findElement(By.xpath("//span[text()='Legal Entities']/parent::a[@title='Legal Entities']"));
		driver.executeScript("arguments[0].scrollIntoView();",headerEntity);
		driver.executeScript("arguments[0].click()", headerEntity);
		Thread.sleep(5000);
		WebElement sortButton=driver.findElement(By.xpath("//th[@title='Last Modified Date']/div//span[@title='Last Modified Date']"));
		driver.executeScript("arguments[0].scrollIntoView();", sortButton);
		driver.executeScript("arguments[0].click()", sortButton);
		Thread.sleep(5000);
		WebElement sortButton1=driver.findElement(By.xpath("//th[@title='Last Modified Date']/div//span[@title='Last Modified Date']"));
		driver.executeScript("arguments[0].scrollIntoView();", sortButton1);
		driver.executeScript("arguments[0].click()", sortButton1);
		Thread.sleep(3000);
		//get dates
		List<WebElement> dates=driver.findElements(By.xpath("//th[@class='slds-cell-edit cellContainer']/following::td//span[@data-aura-class='uiOutputDateTime']"));
		driver.executeScript("arguments[0].scrollIntoView();", dates.get(dates.size()-1));
		//driver.executeScript("arguments[0].click()", dates.get(dates.size()-1));
		List<WebElement> dates1=driver.findElements(By.xpath("//th[@class='slds-cell-edit cellContainer']/following::td//span[@data-aura-class='uiOutputDateTime']"));
		//driver.executeScript("arguments[0].scrollIntoView()", dates1.get(dates1.size()-1));
		System.out.println(dates1.size());
		/*
		 * List<WebElement> datesAdded=driver.findElements(By.
		 * xpath("//th[@class='slds-cell-edit cellContainer']/following::td//span[@data-aura-class='uiOutputDateTime']"
		 * )); System.out.println(datesAdded.size());
		 */
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy, h:mm a");
		List<Date> sortedDates=new ArrayList<Date>();
		String date;
		for(int i=0;i<dates1.size();i++) {
			driver.executeScript("arguments[0].scrollIntoView();", dates1.get(i));
			date=dates1.get(i).getText().trim();
			System.out.println(date);
			Date convertedToDate=formatter.parse(date);
			System.out.println(convertedToDate);
			sortedDates.add(convertedToDate);
			/*
			 * Date date1=formatter.parse(date); System.out.println(date1);
			 */       	
		}
		System.out.println(sortedDates);
		for(int j=0;j<sortedDates.size();j++) { for(int
				k=j+1;k<sortedDates.size();k++) {
			if(sortedDates.get(j).before(sortedDates.get(k))) {
				System.out.println("Dates are displaying in ascending order"); } else {
					System.out.println("It is not displaying in ascending order"); } } }





	}

}
