import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Example9_7 {

	public static void main(String[] args) {
		WindowActionEvent win = new WindowActionEvent();
		PoliceListen police = new PoliceListen();
		win.setMyCommandListener(police);
		win.setBounds(100, 100, 460, 360);
		win.setTitle("处理ActionEvent事件");
	}

}

class WindowActionEvent extends JFrame{
	JTextField inputText;
	JTextArea textShow;
	JButton button;
	MyCommandListener listener;
	public WindowActionEvent() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init(){
		setLayout(new FlowLayout());
		inputText = new JTextField(10);
		button = new JButton("确定");
		textShow = new JTextArea(9, 30);
		textShow.setEditable(false);
		add(inputText);
		add(button);
		add(new JScrollPane(textShow));
	}
	void setMyCommandListener(MyCommandListener listener) {
		this.listener = listener;
		listener.setJTextField(inputText);
		listener.setJTextArea(textShow);
		inputText.addActionListener(listener);
		
		button.addActionListener(listener);
	}
}
interface MyCommandListener extends ActionListener{
	//监听器/侦听器接口
	public void setJTextField(JTextField text);
	public void setJTextArea(JTextArea area);
}
class PoliceListen implements MyCommandListener{
	//监听器/侦听器接口实例
	JTextField textInput;
	JTextArea textShow;
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = textInput.getText();
		
		textShow.append(str+"的长度:"+str.length()+"\n");
	}
	@Override
	public void setJTextField(JTextField text) {
		textInput = text;
	}
	@Override
	public void setJTextArea(JTextArea area) {
		textShow = area;
	}
	
}