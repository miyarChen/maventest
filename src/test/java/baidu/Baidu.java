package baidu;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

public class Baidu {
	
	public Baidu(){
		
	}
	
	
	@Test
	public void baiduSearch(WebDriver driver){
		WebElement element = driver.findElement(By.id("kw"));
	    element.sendKeys("selenium");
	    WebElement element_submit = driver.findElement(By.id("su"));
	    element_submit.click();
	    
	    WebElement element_set = driver.findElement(By.linkText("����"));
	    element_set.click();
	}

}
