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

public class func_HealthDeptt_Locator_Param {
public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException   {
		
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
		 method_Click_Link(By.xpath("//*[@id=\"menu-item-111\"]/a"));
		 //Health dept locator link
	 	 method_Click_Link(By.xpath("//ul[@id='sidebar']/li[1]/div/ul/li[1]"));
	 	 // enter zip code
		 _input_Text(By.xpath(("//*[@id='wpsl-search-input']")), "20110");
		 
		
		 //select radius miles
		driver.findElement(By.xpath("//span[contains(text(),'25 mi')]")).click();
			 Thread.sleep(3000);
			 driver.findElement(By.xpath("//form/div[2]/div[1]/div/select/option[@value='100']")).submit();
			 System.out.println("search radius is inserted");
		

		 //select Results numbers
		 driver.findElement(By.xpath("//form[1]/div[2]/div[2]/div[1]/span[1]")).click();
		 Thread.sleep(3*1000);
		 System.out.println("Results input is clicked");
		 driver.findElement(By.xpath("//article[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[3]/input[1]")).click();
		 System.out.println("search button is clicked");
		 Thread.sleep(15000);
	
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

	
	 // Generic class/method for links to click
	public static void method_Click_Link(By by) throws InterruptedException {
		try {
		WebElement link_click = driver.findElement(by);
		 new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable((link_click)));
		 Thread.sleep(5*1000);
		 if(link_click.isDisplayed()) {
			 Assert.assertTrue(true, "Element not found");
			 link_click.click();
		 	}else {
			 System.out.println("Element isn't clicked, not found");
		 	}
		 System.out.println("Link: "+link_click.getText()+"is clicked successfully");
	} catch (Throwable e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.toString()+":      print of error message");
		System.out.println(e.getMessage() +":     print of getMessage");
		}
	}
	
	// Generic function/method to insert Text --> (1)
		public static void _input_Text(By by, String text) throws InterruptedException {
				WebElement input_text = driver.findElement(by);
				new WebDriverWait(driver, Duration.ofSeconds(30)).until(ExpectedConditions.elementToBeClickable(( input_text)));
				Thread.sleep(5*1000);
				input_text.sendKeys(text);
				System.out.println("Link: "+ input_text.toString()+"is inserted successfully");
			}
		
}