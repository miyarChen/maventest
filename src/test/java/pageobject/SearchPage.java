package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchPage {

	private static WebElement element = null;
	public static WebElement searchText(WebDriver driver){
		
		element = driver.findElement(By.id("kw"));
		return element;
	}
	
	public static WebElement searchButton(WebDriver driver){
		
		element = driver.findElement(By.id("su"));
		return element;
	}
}
