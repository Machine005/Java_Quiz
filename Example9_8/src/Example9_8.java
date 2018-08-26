import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Example9_8 {

	public static void main(String[] args) {
		WindowOperation win = new WindowOperation();
		win.setBounds(100, 100, 390, 360);
		win.setTitle("计算器");
	}

}
class WindowOperation extends JFrame{
	JTextField inputNumberOne, inputNumberTwo;
	JComboBox choiceFuhao;
	JTextArea textShow;
	JButton button;
	OperatorListener operator;
	ComputerListener computer;
	public WindowOperation() {
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init() {
		setLayout(new FlowLayout());
		inputNumberOne = new JTextField(5);
		inputNumberTwo = new JTextField(5);
		choiceFuhao = new JComboBox();
		button = new JButton("计算");
		choiceFuhao.addItem("选择运算符号:");
		String []a = {"+","-","*","/"};
		for(int i = 0; i<a.length; i++) {
			choiceFuhao.addItem(a[i]);
		}
		textShow = new JTextArea(9, 30);
		textShow.setEditable(false);
		operator = new OperatorListener();
		computer = new ComputerListener();
		operator.setJComboBox(choiceFuhao);
		operator.setWorkTogether(computer);
		computer.setJTextFieldOne(inputNumberOne);
		computer.setJTextFieldTwo(inputNumberTwo);
		computer.setJTextArea(textShow);
		choiceFuhao.addItemListener(operator);
		
		button.addActionListener(computer);
		add(inputNumberOne);
		add(choiceFuhao);
		add(inputNumberTwo);
		add(button);
		add(new JScrollPane(textShow));
	}
}

class OperatorListener implements ItemListener{
	JComboBox choice;
	ComputerListener workTogether;
	public void setJComboBox(JComboBox box) {
		choice = box;
	}
	public void setWorkTogether(ComputerListener computer) {
		workTogether = computer;
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		String fuhao = choice.getSelectedItem().toString();
		workTogether.setFuhao(fuhao);
	}
}
class ComputerListener implements ActionListener{
	JTextField inputNumberOne, inputNumberTwo;
	JTextArea textShow;
	String fuhao;
	public void setJTextFieldOne(JTextField t) {
		inputNumberOne = t;
	}
	public void setJTextFieldTwo(JTextField t) {
		inputNumberTwo = t;
	}
	public void setJTextArea(JTextArea area) {
		textShow = area;
	}
	public void setFuhao(String s) {
		fuhao = s;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		try {
			double number1 = Double.parseDouble(inputNumberOne.getText());
			double number2 = Double.parseDouble(inputNumberTwo.getText());
			double result = 0;
			if(fuhao.equals("+")) {
				result = number1 + number2;
			}
			else if(fuhao.equals("-")) {
				result = number1 - number2;
			}
			else if(fuhao.equals("*")) {
				result = number1 * number2;
			}
			else if(fuhao.equals("/")) {
				result = number1 / number2;
			}
			textShow.append(number1+" "+fuhao+" "+number2+" ="+result+'\n');
		}catch(Exception exp) {
			textShow.append("\n请输入数字字符\n");
		}
	}
	
}