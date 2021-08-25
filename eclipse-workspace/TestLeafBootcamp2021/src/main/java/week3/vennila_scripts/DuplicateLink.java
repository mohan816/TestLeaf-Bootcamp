package week3.vennila_scripts;


	import java.util.ArrayList;
	import java.util.HashSet;
	import java.util.List;
	import java.util.Set;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;

	import io.github.bonigarcia.wdm.WebDriverManager;

	public class DuplicateLink {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to("https://www.rahulshettyacademy.com/AutomationPractice/");
			List<WebElement> AllLinks = driver.findElements(By.xpath("//li[@class='gf-li']//a"));
			System.out.println(AllLinks.size());

			Set<String> allLinks = new HashSet<String>();
			List<String> listlinks = new ArrayList<String>();
			for (WebElement webElement : AllLinks) {
				allLinks.add(webElement.getText());
				listlinks.add(webElement.getText());
			}

			System.out.println(listlinks);
			System.out.println(listlinks.size());

			System.out.println(allLinks);
			System.out.println(allLinks.size());

			for (String string : allLinks) {
				  int sizes = driver.findElements(By.xpath(String.format(
				  "//li[@class='gf-li']//a[text()='%s']", string))) .size();
				 
				if (sizes > 1) {
					System.out.println("it is duplicate " + string);
				}
			}

		}
}
