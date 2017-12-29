package ranzhi;

public class BasePage {

	// 基类的变量，所有继承的类，都可以使用
	BoxDriver baseDriver;
	
	//默认的构造方法，无参数的构造方法
	public BasePage() {
	}
	
	//传递 driver的构造方法
	public BasePage(BoxDriver driver) {
	    this.baseDriver = driver;
	}
	
	
    private String START_BUTTON_SELECTOR = "s,#start > div";
    private final String EXIT_MENU_TEXT = "l,%s";
    
    //每个子类都需要的系统功能：

    //open

    public void open(String url) throws InterruptedException {
        this.baseDriver.navigate(url);
        Thread.sleep(2000);
    }
    
    
}
