import java.awt.FlowLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Example9_12 {

	public static void main(String[] args) {
		Win win = new Win();
		win.setTitle("输入序列号");
		win.setBounds(10, 10, 460, 360);
	}

}
class Win extends JFrame{
	JTextField text[] = new JTextField[3];
	Police police;
	JButton b;
	Win() {
		setLayout(new FlowLayout());
		police = new Police();
		for(int i=0; i<3; i++) {
			text[i] = new JTextField(7);
			text[i].addFocusListener(police);
			text[i].addKeyListener(police);
			add(text[i]);
		}
		b = new JButton("确定");
		add(b);
		text[0].requestFocusInWindow();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

class Police implements KeyListener,FocusListener{

	@Override
	public void keyPressed(KeyEvent e) {
		
		JTextField t = (JTextField)e.getSource();
		if(t.getCaretPosition() >= 6) t.transferFocus();
	}
	@Override
	public void focusGained(FocusEvent e) {
		JTextField text = (JTextField)e.getSource();
		text.setText(null);
	}

	@Override
	public void focusLost(FocusEvent e) {}
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
}