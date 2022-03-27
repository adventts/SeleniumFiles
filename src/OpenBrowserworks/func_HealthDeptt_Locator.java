package OpenBrowserworks;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class func_HealthDeptt_Locator {
public static WebDriver driver;

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
		 
		 //Health topic link
		 driver.findElement(By.xpath("//*[@id=\"menu-item-111\"]/a")).click();
		 Thread.sleep(5000);
		 System.out.println("Health topic a-z clicked");
		 
		 // Health dept locator link
		WebElement health_Dept_Locator =  driver.findElement(By.xpath("//ul[@id='sidebar']/li[1]/div/ul/li[1]"));
		 new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable((health_Dept_Locator)));
//		 Thread.sleep(3000);
		 health_Dept_Locator.click();
		 System.out.println("Health department locator is clicked");
		 Thread.sleep(5000);
		 
		 // enter zip code
		 driver.findElement(By.xpath("//*[@id='wpsl-search-input']")).sendKeys("20110");
		 Thread.sleep(3000);
		 System.out.println("zip code is inserted");
		 
		 //select radius miles
		try {
			driver.findElement(By.xpath("//span[contains(text(),'25 mi')]")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//form/div[2]/div[1]/div/select/option[@value='1001']")).submit();
			 System.out.println("search radius is inserted");
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.toString()+"print of toString");
			System.out.println(e.getMessage() +"print of getMessage");
		}finally {
			driver.quit();
		}
/*		 
	 	 List<WebElement> allLists = driver.findElements(By.xpath("/html/body/div[3]/div[2]/div/main/article/div/div/div[1]/div/form/div[2]/div[1]/div/div/ul/li"));
		 Thread.sleep(3000);
		 allLists.get(3).click();
		 System.out.println("miles is selected");
	*/	 
		 //select Results numbers
		 driver.findElement(By.xpath("//form[1]/div[2]/div[2]/div[1]/span[1]")).click();
		 Thread.sleep(3*1000);
		 System.out.println("Results input is clicked");
		 driver.findElement(By.xpath("//article[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/input[1]")).click();
		 System.out.println("search button is clicked");
		 Thread.sleep(15000);
	
		 
//		 List<WebElement> resultsList = driver.findElements(By.xpath("//div[@style='height: 150px;']//ul"));
//		 resultsList.get(3).click();
//		 System.out.println("Result List to select found as: "+resultsList.size());
//		 Thread.sleep(3000);
//		 resultsList.get(2).click();
//		 System.out.println(resultsList.get(3).toString()+"is selected");
		 
		 //clicks on Search button
		// Thread.sleep(3000);
		// driver.findElement(By.xpath("//input[@id='wpsl-search-btn']")).click();
		 
		 //compare how many resutls are dipslayed
		 List<WebElement> listOfAddress = driver.findElements(By.xpath("//div[@id='wpsl-stores']/ul/li/div[@class='wpsl-store-location']"));
		 Thread.sleep(3*1000);
		 System.out.println("Total results of Address displays : "+ listOfAddress.size());
		 int linkCount = listOfAddress.size();
		
		 System.out.println("List of addresses are :"+linkCount);
		 if(linkCount >0 ) {
			 Assert.assertTrue(true, "List of Address dipslays");
			System.out.println(linkCount +": found total link");
		 } else {
			 System.out.println("List of addresses didn't display correctly, test is failed ");
		 }
		 
		 // Close browser
		 driver.quit();
		 System.out.println("Browser closed successfully");
	//don't write below	 
	}

}