import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Example9_6 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		WindowActionEvent win = new WindowActionEvent();
		win.setTitle("处理ActionEvent事件");
		win.setBounds(100, 100, 310, 260);
	}

}


class WindowActionEvent extends JFrame{
	JTextField text;
	ActionListener listener;
	//监视器/侦听器
	public WindowActionEvent() {
		setLayout(new FlowLayout());
		text = new JTextField(10);
		add(text);
		listener = new ReaderListen();
		//初始化监视器/侦听器
		text.setActionCommand("132456");
		text.addActionListener(listener);
		//添加指定的动作侦听器以从此文本字段接收动作事件
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class ReaderListen implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String str = e.getActionCommand();
		System.out.println(str+":"+str.length());
	}
	
}
