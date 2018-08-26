import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class WindowBoxLayout extends JFrame{
	Box baseBox, boxv1, boxv2;
	public WindowBoxLayout() {
		setLayout(new java.awt.FlowLayout());
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init() {
		boxv1 = Box.createVerticalBox();
		boxv1.add(new JLabel("ÐÕÃû"));
		boxv1.add(Box.createVerticalStrut(8));
		boxv1.add(new JLabel("email"));
		boxv1.add(Box.createVerticalStrut(8));
		boxv1.add(new JLabel("Ö°Òµ"));
		
		boxv2 = Box.createVerticalBox();
		boxv2.add(new JTextField(10));
		boxv2.add(Box.createVerticalStrut(8));
		boxv2.add(new JTextField(10));
		boxv2.add(Box.createVerticalStrut(8));
		boxv2.add(new JTextField(10));
		baseBox = Box.createHorizontalBox();
		baseBox.add(boxv1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(boxv2);
		add(baseBox);
	}
	
}
