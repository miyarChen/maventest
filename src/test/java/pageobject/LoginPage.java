package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	private static WebElement element = null;
	
	public static WebElement login_UserName(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='_j_login_form']/div[1]/input"));
		return element;
	}
	
	public static WebElement login_Password(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='_j_login_form']/div[2]/input"));
		return element;
	}
	
	public static WebElement login_Button(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='_j_login_form']/div[5]/button"));
		return element;
	}
	
	/*public static WebElement login_User(WebDriver driver){
		element = driver.findElement(By.id("spnUID"));
		return element;
		
	}*/
	
	/*public static WebElement logout_Button(WebDriver driver){
		element = driver.findElement(By.linkText("退出"));
		return element;
	}
	*/
	//马蜂窝网站的错误提示xpath路径每个都不一样，所以导致获取的内容不正确
	public static WebElement login_Error_Hint(WebDriver driver){
		element = driver.findElement(By.xpath(".//*[@id='_j_login_form']/div[1]/div"));
		return element;
	}
}
