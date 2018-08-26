import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

class MyFrame extends JFrame{
	Boy police;
	MyFrame(String s){
		super(s);
		police = new Boy();
		setBounds(100, 100, 200, 300);
		setVisible(true);
		addWindowListener(police);
		validate();
	}
	
	
}
class Boy extends WindowAdapter{
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
}
public class Example9_13 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new MyFrame("窗口");
	}

}
