package cases;

//import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baidu.InitDriver;
import operate.LoginUser;

public class LoginMafengwoTests {
	
	WebDriver driver = null;
	String url = "https://passport.mafengwo.cn/";//马蜂窝登录页面
	String drivername = "Firefox";
	InitDriver initdriver = new InitDriver();
	
	@BeforeMethod	
	public void setUp() throws Exception{
				
		driver = initdriver.startExplorer(driver, drivername, url);		
		//driver = startExplorer(driver,drivername,url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	//定义对象数组
	@DataProvider(name="user")
	public Object[][] Users(){
		return new Object[][]{
			{"","","帐号不能为空"},
			{"testing","","密码不能为空"},
			{"","123456","账号不能为空"},
			{"error","error","账号不存在，请重新输入"},
			{"testing","123","密码不能小于4个字符"},
		};
	}
	@Test(dataProvider="user")
	public void loginTestCase(String username,String password,String expectText) throws Exception{
		
		/*String username = "testingwtd";
		String password ="a123456";*/
		LoginUser.login(driver, username, password);
		Thread.sleep(5000);
		
		String text = LoginUser.login_error_info(driver);//获取到的页面元素中的错误提示
		System.out.println(text);
		System.out.println(expectText);
		//Assert.assertEquals(text,username+"@126.com");
		assertEquals(text,expectText);				//断言
		
		
		/*LoginUser.logout(driver);*/
	}
	
	@AfterMethod
	public void teardown() throws Exception{
		driver.close();
	}
	
}
