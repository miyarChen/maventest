package baidu;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BaiduLaunchFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public  void launchFrame(){
		
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
}
