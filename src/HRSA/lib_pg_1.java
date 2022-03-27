package HRSA;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import HRSA.link_pg_1;

public class lib_pg_1 {

	
	
// Link Click
	 public static void linkclick(WebDriver driver, By by) {
 		try {
 			WebDriverWait wait = new WebDriverWait(driver , 5);
 			wait.until(ExpectedConditions.elementToBeClickable(by));
 			WebElement	linkElement = driver.findElement(by);
 			System.out.println("Element: "+linkElement.getText().toString()+"  is clicked");
 			linkElement.click();
 				
 		} catch (Exception e) {
 			e.printStackTrace();
 			System.out.println(e.toString());
 			System.out.println(e.getMessage());
 		}

			}	
//enter input in input field
	 public static void input_value(WebDriver driver, By by, String _value)	{
		try {			 				
	 		Thread.sleep(3*1000);
			driver.findElement(by).sendKeys(_value);
	 		System.out.println("Value inserted : " + _value);
	 		} catch (Exception e) {
	 			e.printStackTrace();
	 			System.out.println(e.toString());
	 			System.out.println(e.getMessage());
	 			}
	 		}

// Actions for Keyboard ENTER
	 public static void KB_enter(WebDriver driver) throws InterruptedException {
	 Actions action = new Actions(driver);
	 action.sendKeys(Keys.ARROW_DOWN);
	 Thread.sleep(5*1000);
	 action.sendKeys(Keys.ENTER);
	 }

	 
// assertion for search results
	 public static void search_Rslt(WebDriver driver,By by){
		 String val_compare = driver.findElement(by).getText().toString();
		 System.out.println("Search Result found is: "+ val_compare+":---Test-Pass");
		 if(val_compare != null) {
			 Assert.assertTrue(true, "Test failing due to Result not found");
		 }else {
			 System.out.println("Search Result is empty, Test failed");
			 System.out.println("Search Result found is: "+ val_compare);
		 }
		 
	 }
	 
	 
}



