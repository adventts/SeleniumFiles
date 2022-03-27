package OpenBrowserworks;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class smokeTest_CVS {
static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver.exe");
//		 System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver.exe");
//		 driver = new ChromeDriver();
	    driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		 driver.navigate().to("https://www.vdh.virginia.gov/mabs/");
		 Thread.sleep(10*1000);
		 String titleText = "COVID";
		 if(driver.getTitle().contains(titleText)) {
			 System.out.println("Correct page is in display");
		 }else {
			 System.out.println("Page didn't display correctly");
		 }

		 System.out.println("Eelement check begins");
		WebElement search_input =  driver.findElement(By.xpath("//*[@id='panel-2-2-1-0']/div/div/div/a"));
		if(search_input.isDisplayed()) {
			Assert.assertTrue(true, "Element not displayed");
			search_input.click();
			System.out.println("COVID-19 Treatment Locator is clicked");
			
		Thread.sleep(5*1000);
			WebElement input_YourLocation = driver.findElement(By.xpath("//*[@id='wpsl-search-input']"));
			if (input_YourLocation.isDisplayed()) {
				Assert.assertTrue(true, "element not found for Your Location");
				input_YourLocation.sendKeys("21090");
				System.out.println("zip code inserted in location field");
			}
			
			Thread.sleep(5*1000);
			List <WebElement>listItem_results = driver.findElements(By.xpath("//*[@id='wpsl-results']/div/div/ul"));
				if(listItem_results.isEmpty()) {
					System.out.println("Items for Results not found");
					}else {
						Assert.assertTrue(true, "Results element not correct");
						
						for(WebElement list_item : listItem_results) {
							listItem_results.get(0);
						}
						
						System.out.println(" item is selected: "+listItem_results.get(0).getText());
					}
			
				WebElement link_search = driver.findElement(By.xpath("//*[@id=\"wpsl-search-btn\"]"));
				if(link_search.isEnabled()) {
					Assert.assertTrue(true, "Search link is not available");
					link_search.click();
					Assert.assertTrue(true);
					WebElement searchResult  = driver.findElement(By.xpath("//*[@id='wpsl-result-list']"));
					if (searchResult!=null) {
						System.out.println("Results are displayed correctly");
					String	itemsInResults = searchResult.getSize().toString();
					Thread.sleep(5*1000);
					System.out.println("Results are :  "+("\n")+"========================================"+searchResult.getText()+("\n"));
					}
				}
				
				System.out.println("going to back page");
				driver.navigate().back();
				Thread.sleep(3*1000);
				WebElement link_Home = driver.findElement(By.xpath("/html/body/div[3]/header/nav/div/div/ul/li[1]/a"));
				if(link_Home.isDisplayed()) {
					Assert.assertTrue(true, "Link Home doesn't display");
					link_Home.click();
					System.out.println("link home is clicked");
				}else {
					System.out.println("link home can't be clicked, not displayed");
				}
				
				WebElement link_health_dept = driver.findElement(By.xpath("/html/body/div[3]/header/nav/div/div/ul/li[5]/a"));
				if(link_health_dept.isDisplayed()) {
					Assert.assertTrue(true, "Link Health Department doesn't display");
					link_health_dept.click();
					System.out.println("link Health  is clicked");
					
				List<WebElement> count_H_Dept = driver.findElements(By.xpath("/html/body/div[3]/div[3]/div/main/article/div/div[3]/div[1]/ul/li"));
				if(count_H_Dept.size()>=9) {
					System.out.println(count_H_Dept.size());
					Assert.assertTrue(true,"List items are not fully displaying");
					System.out.println("Links are found");
				}else {
					System.out.println("Links are NOT found");
				}
				
				}
				
		
			Thread.sleep(3*1000);
			driver.quit();
			
		}
		 
	}

}
