package week1.venniala_scripts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadExcel;

public class BaseClass {
	public ChromeDriver driver;
	public String FileName;

	@BeforeMethod
	public void preCondition() {
		WebDriverManager.chromedriver().setup();
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver=new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://login.salesforce.com/");
		

	}
	@AfterMethod
	public void postConditio(){
		driver.close();

	}
	@DataProvider(name="fetchData")
	public String[][] sendData() throws IOException{
		ReadExcel excel=new ReadExcel();
				return excel.excelData(FileName);
	}
}
/*https://github.com/TestLeafPages/Research/blob/master/PdfFileDownload.java*/