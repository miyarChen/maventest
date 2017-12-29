package cases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baidu.InitDriver;
import operate.SearchContent;

public class SearchTest {
	private static WebDriver driver = null;
	String url = "http://www.baidu.com";
	String drivername = "Firefox";
	private static InitDriver initdriver = new InitDriver();
	
	@BeforeMethod	
	public void setUp() throws Exception{
					
		driver = initdriver.startExplorer(driver, drivername, url);		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);	
	}
	
	@Test
	public static void searchTestCase() throws Exception{
		SearchContent.baiduSearch(driver);
	}
	
	@AfterMethod
	public static void tearDown() throws Exception{
		initdriver.closeExplorer(driver);
	}
}
