package HRSA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class link_pg_1 {

	WebDriver driver;

// xpath for link health Center
	public By link_HealthCenter() {
		By Find_H_Center = By.xpath("//a[@class='hrsahome-call-to-action__button']");
		return Find_H_Center;
		}
// xpath for input field 
	public By input_enter_location() {
		By enter_locaiton = By.xpath("//form/input[@title='Enter a location']");
		return enter_locaiton;
		
	}	
	
 // search icon xpath
	public By src_icon() {
		By src_icon = By.xpath("//span[@class='esri-icon-search']");
		return src_icon;
	}
	
//	Search Result xpath
	public By srch_Rslt () {
		By srch_Rslt = By.xpath("//a[@id='FilterResultsLink']");
		return srch_Rslt;
	}
}


