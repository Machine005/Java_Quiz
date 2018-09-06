import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Example9_14 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		WindowButton win = new WindowButton("猜数字");
	}

}
class WindowButton extends JFrame implements ActionListener{
	int number;
	JLabel hintLabel;
	JTextField inputGuess;
	JButton buttonGetNumber, buttonEnter;
	
	WindowButton(String s){
		super(s);
		addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dispose();
				//该窗口的所有屏幕资源，将被释放回到操作系统，并且标记为不可显示.
				}});
		setLayout(new FlowLayout());
		buttonGetNumber = new JButton("得到一个随机数");
		add(buttonGetNumber);
		hintLabel = new JLabel("输入你的猜测: ", JLabel.CENTER);
		hintLabel.setBackground(Color.cyan);
		inputGuess = new JTextField("0", 10);
		add(hintLabel);
		add(inputGuess);
		buttonEnter = new JButton("确定");
		add(buttonEnter);
		buttonEnter.addActionListener(this);
		buttonGetNumber.addActionListener(this);
		setBounds(100, 100, 150, 150);
		setVisible(true);
		validate(); 
		//验证此容器及其多有子组件. 此方法会使容器再次布置其子组件.
		//已经布置容器后,再修改此容器的子组件时,应调用该方法.
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonGetNumber) {
			//getSource()返回触发事件的对象
			number = (int)(Math.random()*100)+1;
			hintLabel.setText("输入你的猜测: ");
		}
		else if(e.getSource() == buttonEnter) {
			int guess = 0;
			try {
				guess = Integer.parseInt(inputGuess.getText());
				
				if(guess == number) hintLabel.setText("猜对了");
				else if(guess > number) {
					hintLabel.setText("太大了");
					inputGuess.setText(null);
				}
				else if(guess < number) {
					hintLabel.setText("太小了");
					inputGuess.setText(null);
				}
			}catch(NumberFormatException event) {
				
			}
		}
		
	}
	
}