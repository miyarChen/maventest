/*
 * author：miyar chen
 */
package baidu;


import java.awt.FlowLayout;
import java.util.Scanner;

import javax.swing.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baidu.InitDriver;
//import baidu.Baidu;
import baidu.BaiduLaunchFrame;
import operate.ReadCSV;
public class BaiduMain extends JFrame{
	
	/**
	 * 
	 *//*
	private static final long serialVersionUID = 1L;

	public void launchFrame(){
		this.setSize(300, 300);//设置宽度和高度
		this.setLocation(700, 466);//设置初始位置
		this.setVisible(true);//设置可见
		this.setTitle("浏览器选择");
		JLabel label = new JLabel("请输入浏览器名称");
		//JTextField textField = new JTextField();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton submit = new JButton("提交");
		//panel.add(textField);
		panel.add(label);
		panel.add(submit);
		getContentPane().add(panel);
	}
	*/
	
	public static void main(String args[]) {
		WebDriver driver = null;
		String url="http://www.baidu.com";
		//String driverName="Firefox";
		//String driverName="Chrome";
		//String driverName="IE";
		String driverName;
		
		//new BaiduMain().launchFrame();
		
		System.out.println("可选择的浏览器：Firefox Chrome IE");
		System.out.print("请输入浏览器名称:");
		
		Scanner str = new Scanner(System.in);
		driverName=str.next();		
		driverName=driverName.intern();//检查字符串池里是否存在driverName的值，如果存在，就返回池里的字符串；如果不存在，该方法会 把driverName的值添加到字符串池中，然后再返回它的引用
	    InitDriver initDriver = new InitDriver();
	    driver=initDriver.startExplorer(driver, driverName, url);
	    
	    str.close();
	    
	    WebElement element = driver.findElement(By.id("kw"));
	    element.sendKeys("selenium");
	    WebElement element_submit = driver.findElement(By.id("su"));
	    element_submit.click();
	    
	    WebElement element_set = driver.findElement(By.linkText("设置"));
	    element_set.click();
	   // Baidu bd = new Baidu();
	   // bd.baiduSearch(driver);
	    
	    initDriver.closeExplorer(driver);
	    System.out.println("success!");
	    System.out.println("******************");
	    
	    String filePath="F:/autotest/maventest/src/test/resources/test.csv";
	    ReadCSV.readCSVFile(filePath);
	}
}
