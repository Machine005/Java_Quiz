import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Example9_6 {

	public static void main(String[] args) {
		// TODO �Զ����ɵķ������
		WindowActionEvent win = new WindowActionEvent();
		win.setTitle("����ActionEvent�¼�");
		win.setBounds(100, 100, 310, 260);
	}

}


class WindowActionEvent extends JFrame{
	JTextField text;
	ActionListener listener;
	//������/������
	public WindowActionEvent() {
		setLayout(new FlowLayout());
		text = new JTextField(10);
		add(text);
		listener = new ReaderListen();
		//��ʼ��������/������
		text.setActionCommand("132456");
		text.addActionListener(listener);
		//���ָ���Ķ����������ԴӴ��ı��ֶν��ն����¼�
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
class ReaderListen implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO �Զ����ɵķ������
		String str = e.getActionCommand();
		System.out.println(str+":"+str.length());
	}
	
}
