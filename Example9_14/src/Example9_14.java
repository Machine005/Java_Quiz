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
		// TODO �Զ����ɵķ������
		WindowButton win = new WindowButton("������");
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
				//�ô��ڵ�������Ļ��Դ�������ͷŻص�����ϵͳ�����ұ��Ϊ������ʾ.
				}});
		setLayout(new FlowLayout());
		buttonGetNumber = new JButton("�õ�һ�������");
		add(buttonGetNumber);
		hintLabel = new JLabel("������Ĳ²�: ", JLabel.CENTER);
		hintLabel.setBackground(Color.cyan);
		inputGuess = new JTextField("0", 10);
		add(hintLabel);
		add(inputGuess);
		buttonEnter = new JButton("ȷ��");
		add(buttonEnter);
		buttonEnter.addActionListener(this);
		buttonGetNumber.addActionListener(this);
		setBounds(100, 100, 150, 150);
		setVisible(true);
		validate(); 
		//��֤������������������. �˷�����ʹ�����ٴβ����������.
		//�Ѿ�����������,���޸Ĵ������������ʱ,Ӧ���ø÷���.
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == buttonGetNumber) {
			//getSource()���ش����¼��Ķ���
			number = (int)(Math.random()*100)+1;
			hintLabel.setText("������Ĳ²�: ");
		}
		else if(e.getSource() == buttonEnter) {
			int guess = 0;
			try {
				guess = Integer.parseInt(inputGuess.getText());
				
				if(guess == number) hintLabel.setText("�¶���");
				else if(guess > number) {
					hintLabel.setText("̫����");
					inputGuess.setText(null);
				}
				else if(guess < number) {
					hintLabel.setText("̫С��");
					inputGuess.setText(null);
				}
			}catch(NumberFormatException event) {
				
			}
		}
		
	}
	
}