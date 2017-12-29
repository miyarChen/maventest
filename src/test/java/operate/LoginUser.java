package operate;

import org.openqa.selenium.WebDriver;

import pageobject.LoginPage;

public class LoginUser {
	
	//登录方法
	public static void login(WebDriver driver,String username,String password ){
		LoginPage.login_UserName(driver).clear();
		LoginPage.login_UserName(driver).sendKeys(username);
		
		LoginPage.login_Password(driver).clear();
		LoginPage.login_Password(driver).sendKeys(password);
		
		LoginPage.login_Button(driver).click();
	}
	
	//登录用户
	/*public static String login_user_info(WebDriver driver){
		String text = LoginPage.login_User(driver).getText();
		return text;
	}*/
	//获取登录错误提示
	public static String login_error_info(WebDriver driver){
		String text = LoginPage.login_Error_Hint(driver).getText();
		return text;
	}
	//用户退出
	/*public static void logout(WebDriver driver){
		LoginPage.logout_Button(driver).click();
	}*/
}
