package ranzhi;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BoxDriver {
	
	WebDriver baseDriver = null;
	
	public BoxDriver(){
		
	}
	
	//找到一个指定输入框(selector)，并且输入指定的字符(text)
	//type(selector, text)
	//不用在业务逻辑中，使用多次的 findElement(By.id(...))
	
	
	public void type(String selector, String text) {
		WebElement we = this.locateElement(selector);
		we.clear();
		we.sendKeys(text);
		}
	
	//找到一个可以点击的元素(selector)，并且点击(click)
		//click(selector)
	public void click(String selector) {
		this.locateElement(selector).click();
		}
	
	//找到一个指定的frame，并且切换进去

	//switchToFrame(selector)

	public void switchToFrame(String selector) {
		
		WebElement we = this.locateElement(selector);
		this.baseDriver.switchTo().frame(we);
	}
	
	//找到一个指定的select，并且通过index进行选择

	//selectByIndex(selector, index)

	public void selectByIndex(String selector, int index) {
	WebElement we = this.locateElement(selector);
	Select s = new Select(we);
	s.selectByIndex(index);
	}
	
	/*
	 * 以上的代码是封装了locateElement()的几种方法，在具体使用封装过的代码的时候，只需要简单的调用即可。接下来的重点，是介绍 locateElement(selector)的封装方式。

查找元素：findElement(By...)
支持各种的查找：8种方式都需要支持，必须通过 selector 显示出分类
selector中需要包含一个特殊符号
实例化 封装好的类的时候，需要约定好是什么特殊符号
强制性用硬编码 hard code来实例化，例如 , 或者 ? 或者 其他非常用字符 =>
或者，构造方法中，传递 this.byChar
要把查找到元素的返回给调用的地方：必须要有返回值，类型是 WebElement
	 */
	private WebElement locateElement(String selector) {
		  WebElement we;
		  // 如果定位符中 有 分隔符，那么就从分隔符处分成两段
		  // 第一段是By
		  // 第二段是真正的定位符
		  // 如果没有分隔符，就默认用 id 定位
		  if (!selector.contains(this.byChar)) {
		    // 用 id 定位
		    we = this.baseDriver.findElement(By.id(selector));
		  } else {
		    // 用 分隔符 分成两个部分
		    String by = selector.split(this.byChar)[0];
		    String value = selector.split(this.byChar)[1];
		    we = findElementByChar(by, value);
		  }
		  return we;
		}
	
	//接下来的重点，是实现 findElementByChar(by, value)
	private WebElement findElementByChar(String by, String value) {
	  WebElement we = null;
	  switch (by.toLowerCase()) {
	    case "id":
	    case "i":
	      we = this.baseDriver.findElement(By.id(value));
	      break;
	    case "css_selector":
	    case "css":
	    case "cssselector":
	    case "s":
	      we = this.baseDriver.findElement(By.cssSelector(value));
	      break;
	    case "xpath":
	    case "x":
	      we = this.baseDriver.findElement(By.xpath(value));
	      break;
	    case "link_text":
	    case "link":
	    case "text":
	    case "linktext":
	    case "l":
	      we = this.baseDriver.findElement(By.linkText(value));
	      break;
	      //TODO: other by type
	  }
	  return we;
	}
	//调用的具体示例：
	private void logIn(String account, String password) throws InterruptedException {
		  BoxDriver driver = this.baseDriver;
		  driver.type("account", account);
		  driver.type("password", password);
		  driver.click("submit");
		  // 点击登录按钮后，需要等待浏览器刷新
		  Thread.sleep(2000);
		}
}
