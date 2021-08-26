package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class AccountDetailsPage extends BaseClass{
	
	public AccountDetailsPage(ChromeDriver driver) {
		this.driver=driver;
	}
	
	public AccountDetailsPage clickDetails() {
		driver.findElement(By.xpath("//a[text()='Details']")).click();
     	return this;
	}
	public AccountDetailsPage verifyPhoneNumber() {
		String phoneNumber="(894) 004-2534";
		 String numberPhone=driver.findElement(By.xpath("(//a[text()='"+phoneNumber+"'])[1]")).getText();
		 System.out.println(numberPhone);	
		 if(phoneNumber.equals(numberPhone)) {
			 System.out.println("Account Edited Successfully");
		 }
		 else {
			 System.out.println("Account is not edited");
		 }
		 return this;
	}
	public AccountDetailsPage verifyAccountName(String name) {
		
		String expected=driver.findElement(By.xpath("//lightning-formatted-text[text()='"+name+"']")).getText();
		System.out.println(expected);
		if(name.equals(expected)) {
			System.out.println("Account is Created with name"+" "+expected);		
	}
		return this;
	}

}
