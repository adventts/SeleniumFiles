package OpenBrowserworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HowToOpenBrowsers {

	public static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("This is before methos");
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\drivers\\geckodriver.exe");
//	 System.setProperty("webdriver.chrome.driver","C:\\Selenium\\drivers\\chromedriver.exe");
//	 driver = new ChromeDriver();
    driver = new FirefoxDriver();
	 driver.manage().window().maximize();
//	 driver.navigate().to("");
//	 Thread.sleep(10*1000);

	}

}
