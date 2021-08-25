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
import org.testng.annotations.Test;

import io.cucumber.messages.internal.com.google.common.base.CharMatcher;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SortByDate extends BaseClass {
@Test
public void sortByDate() throws InterruptedException {
		//click toggle
		driver.findElement(By.xpath("//div[@data-aura-class='uiTooltip']/div[@class='slds-icon-waffle']")).click();
		//click view All
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		//click sales
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
		//click opportunities
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@role='list']/one-app-nav-bar-item-root[2]")).click();
		//select table view
		driver.findElement(By.xpath("//div[@title='Display as Table']")).click();
		//click table
		WebElement clickTable=driver.findElement(By.xpath("//span[text()='Table']"));
		Actions action=new Actions(driver);
		action.moveToElement(clickTable).click(clickTable);
		//sort the opportunities by closing date in ascending order
	    WebElement closedDate=driver.findElement(By.xpath("//th[@title='Close Date']"));
		/* Actions action=new Actions(driver); */
		action.moveToElement(closedDate).click(closedDate);
		//table[@data-aura-class='uiVirtualDataTable']//tbody/tr[1]/td[6]
		/*
		 * List<WebElement>table=driver.findElements(By.xpath(
		 * "//table[@data-aura-class='uiVirtualDataTable']//tbody/tr")); int
		 * size=table.size(); System.out.println(size);
		 * driver.executeScript("arguments[0].scrollIntoView();", table.get(size-1));
		 * driver.executeScript("arguments[0].click()",table.get(size-1));
		 * Thread.sleep(5000);
		 */
		/*String items=driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		String removedCharacters=items.replaceAll("[a-zA-z]","");
		String itemsSize=removedCharacters.trim();
		System.out.println(itemsSize);*/
		String items=driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		int number=Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(items));
		System.out.println(number);
		int sizeTable=0;
		List<WebElement> table1=null;
		
		while(!(number==sizeTable)) {
		table1=driver.findElements(By.xpath("//table[@data-aura-class='uiVirtualDataTable']//tbody/tr"));
	    sizeTable= table1.size();
	    System.out.println(sizeTable);
	    Thread.sleep(5000);
		driver.executeScript("arguments[0].scrollIntoView();", table1.get(sizeTable-1));
		driver.executeScript("arguments[0].click()",table1.get(sizeTable-1));
		Thread.sleep(5000);
		items=driver.findElement(By.xpath("//span[@class='countSortedByFilteredBy']")).getText();
		 number=Integer.parseInt(CharMatcher.inRange('0','9').retainFrom(items));
		System.out.println(number);
		/*
		 * for(int i=0;i<sizeTable;i++) {
		 * driver.executeScript("arguments[0].scrollIntoView();",table1.get(i)); String
		 * dateName=driver.findElement(By.xpath(
		 * "//table[@data-aura-class='uiVirtualDataTable']//tbody/tr["+i+"]/td[6]")).
		 * getText(); list.add(dateName); }
		 */
		 
	}
		List<String> list=new ArrayList<String>();
		for(int i=0;i<sizeTable;i++) {
			driver.executeScript("arguments[0].scrollIntoView();", table1.get(i));
			Thread.sleep(5000);
		String text=driver.findElement(By.xpath("//table[@data-aura-class='uiVirtualDataTable']//tbody/tr["+i+"]/td[6]//span[@class='uiOutputDate']")).getText();
		list.add(text);
			
		}
		System.out.println(list);
				
}}
/*
 * Date date = new Date(); date object displays the current Date
 * SimpleDateFormat formattedDate = new SimpleDateFormat("d-M-y"); To format
 * date in dd/MM/yyyy System.err.println("Actual Date--->"+date.toString());
 * print the Normal Date Format String expectedDate =
 * formattedDate.format(date); Format date to dd/MM/yyyy
 * System.err.println("formatted date--->" +expectedDate ); Print the Formatted
 * Date
 */
