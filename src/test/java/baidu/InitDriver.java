/*
 * author：miyar chen
 */
package baidu;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class InitDriver {
	
	private WebDriver driver;
	private String driverName;
	private String firefoxPath="C:\\Program Files (x86)\\Mozilla firefox\\firefox.exe";
	private String chromePath="C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe";
	private String iePath="C:\\Program Files (x86)\\Internet Explorer\\IEDriverServer.exe";
	private String url;
	
	public InitDriver(){
		
	}
	
	public InitDriver(WebDriver driver,String driverName,String url){
		
		this.driver=driver;
		this.driverName=driverName;
		this.url=url;
		startExplorer(this.driver,this.driverName,this.url);
	}
	
	/*
	 * 启动Firefox浏览器
	 */
	public WebDriver startFirefox(WebDriver driver,String path){
		
		System.setProperty("webdriver.firefox.bin", path);
		driver = new FirefoxDriver();      
		return driver;
    }
	
	/*
	 * 启动Chrome浏览器
	 */
	public WebDriver startChrome(WebDriver driver,String path){
		
		System.setProperty("webdriver.chrome.driver", path);
		
		driver = new ChromeDriver();
		
		return driver;
	}
	
	/*
	 * 启动IE浏览器
	 */
	public WebDriver startIE(WebDriver driver,String path){
		
		System.setProperty("webdriver.ie.driver", path);
		
		driver = new  InternetExplorerDriver();
		
		return driver;
	}
	
	/*
	 * 1.设置浏览器路径
	 * 2.跳转URL
	 * 3.浏览器窗口最大化
	 */
	public WebDriver startExplorer(WebDriver driver,String driverName,String url){
		
			//if(driverName.equalsIgnoreCase("Firefox")){
			if(driverName=="Firefox"){
				
				driver=this.startFirefox(driver,firefoxPath);
			}
			//else if(driverName.equalsIgnoreCase("Chrome")){
			else if(driverName=="Chrome"){
				driver=this.startChrome(driver,chromePath);
			}
			//else if(driverName.equalsIgnoreCase("IE")){
			else if(driverName=="IE"){
				driver=this.startIE(driver,iePath);
			}
		    else {
		    	System.out.println("暂时不支持该浏览器，只支持Firefox，Chrome，IE");
		    }
			
			driver.get(url);//跳转到URL,"http://10.0.0.239:8282"
	        
		    driver.manage().window().maximize();  //浏览器窗口最大化

		return driver;
	}

	/*
	 * 关闭浏览器
	 */
	public void closeExplorer(WebDriver driver){
		driver.close();
	}

}
