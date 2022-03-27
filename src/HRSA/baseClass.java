package HRSA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class baseClass {
	
	public static WebDriver driver;
	public static void brow_FF() throws InterruptedException {
		System.out.println("This is before method");
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver.exe");
	// System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver.exe");
	// driver = new ChromeDriver();
	driver = new FirefoxDriver();
	 driver.manage().window().maximize();
	 driver.navigate().to("https://www.hrsa.gov");
	 Thread.sleep(3*1000);
	}
	
}
 