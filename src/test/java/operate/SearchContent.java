package operate;

import org.openqa.selenium.WebDriver;

import pageobject.SearchPage;

public class SearchContent {

	public static void baiduSearch(WebDriver driver){
		SearchPage.searchText(driver).clear();
		SearchPage.searchText(driver).sendKeys("selenium");
		SearchPage.searchButton(driver).click();
	}
}
