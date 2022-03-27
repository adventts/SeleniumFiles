package HRSA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class hrsa_SmokeTest {
	public static	WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
//inherited link_pg_1 for re-using in this script
		link_pg_1 pg_1 = new link_pg_1();

// Base url
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver.exe");
		// driver = new ChromeDriver();
		driver = new FirefoxDriver();
		 driver.manage().window().maximize();
		String URL="https://www.hrsa.gov";
		driver.navigate().to(URL);
		Thread.sleep(3*1000);

	 
// click on Find Health Center link
		lib_pg_1.linkclick(driver,pg_1.link_HealthCenter());
	
// enter a value in "enter a location" field
		lib_pg_1.input_value(driver, pg_1.input_enter_location(), "20110");
		System.out.println("input for 20110 is done");
				
		
// perform a ENTER EVent from the keyboard
		lib_pg_1.KB_enter(driver);
		System.out.println("Enter button is pressed");
		
// click on search icon
		lib_pg_1.linkclick(driver, pg_1.src_icon());
		
// Assert the results found
		lib_pg_1.search_Rslt(driver, pg_1.srch_Rslt());
		
//close browser
		System.out.println("Quiting browser");
		driver.quit();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*
	 Actions actionMouseHover = new Actions(driver); 
	 actionMouseHover.moveToElement(driver.findElement(By.xpath("/html/body/div[4]/div/div[1]/div[2]/div/div/div/div/ul/li[1]/a")));
	 Thread.sleep(10*1000);
List <WebElement>dropdowns = driver.findElements(By.xpath("//div[4]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/ul[1]/li[1]/ul[1]/li"));
dropdowns.get(2).click();
System.out.println("list items selected");
*/


	 
		}

	}
	 
