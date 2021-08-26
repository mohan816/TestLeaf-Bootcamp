package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class HomePage extends BaseClass{
	public HomePage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public HomePage clickAppLauncher() {
		driver.findElement(By.className("slds-icon-waffle")).click();
		return this;
	}
	public AppLauncherPage clickViewAll() {
		WebElement viewAll=	driver.findElementByXPath("(//button[text()='View All'])");
		viewAll.click();
		return new AppLauncherPage(driver);
	}
	public OpportunityPage clickOpportunities() throws InterruptedException {
		Thread.sleep(5000);
		WebElement clickOpportunity=driver.findElement(By.xpath("//a[@title='Opportunities']"));
		driver.executeScript("arguments[0].click()",clickOpportunity);
		return new OpportunityPage(driver);
	}
	public AccountPage clickAccounts() {
		driver.findElement(By.xpath("//div[@role='list']/one-app-nav-bar-item-root[6]")).click();
		return new AccountPage(driver);
	}
	public HomePage clickCommunity() {
		driver.findElement(By.xpath("//a[text()='Community']")).click();
		return this;
	}
	public HomePage getAppAndDeveloperName() {
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
		return this;
	}
	public HomePage clickViewProfile() {
		driver.findElement(By.xpath("//span[@class='uiImage']")).click();
		return this;
	}
	public SalesforceClassic clickSwitchToSalesforceClassic() {
		driver.findElement(By.xpath("//a[text()='Switch to Salesforce Classic']")).click();
		return new SalesforceClassic(driver);
	}
	

}
