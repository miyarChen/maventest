package baidu;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BaiduLaunchFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	public  void launchFrame(){
		
		this.setSize(300, 300);//���ÿ�Ⱥ͸߶�
		this.setLocation(700, 466);//���ó�ʼλ��
		this.setVisible(true);//���ÿɼ�
		this.setTitle("�����ѡ��");
		JLabel label = new JLabel("���������������");
		//JTextField textField = new JTextField();
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		JButton submit = new JButton("�ύ");
		//panel.add(textField);
		panel.add(label);
		panel.add(submit);
		getContentPane().add(panel);
	}
}
