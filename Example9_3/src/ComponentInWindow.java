import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ComponentInWindow extends JFrame{
	JTextField text;
	//创建单行文本框
	JTextArea area;
	//创建多行文本区
	JButton button;
	//按钮
	JCheckBox checkBox1, checkBox2, checkBox3;
	//选择框
	JRadioButton radio1, radio2;
	//单选框
	JComboBox comBox;
	//下拉列表
	ButtonGroup group;
	//按钮组
	
	public ComponentInWindow() {
		init();
		setVisible(true);
		//设置窗口是否可见
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置点击关闭图标后程序会做怎能么样的处理
	}
	void init() {
		setLayout(new FlowLayout());
		//设置窗口布局
		add(new JLabel("文本框:"));
		text = new JTextField(10);
		add(text);
		add(new JLabel("按钮:"));
		button = new JButton("确定");
		add(button);
		add(new JLabel("选择框"));
		checkBox1 = new JCheckBox("喜欢音乐"); 
		checkBox2 = new JCheckBox("喜欢旅游");
		checkBox3 = new JCheckBox("喜欢篮球");
		add(checkBox1);
		add(checkBox2);
		add(checkBox3);
		add(new JLabel("单选按钮:"));
		group = new ButtonGroup();
		radio1 = new JRadioButton("男");
		radio2 = new JRadioButton("女");
		group.add(radio1);
		group.add(radio2);
		add(radio1);
		add(radio2);
		add(new JLabel("下拉列表:"));
		comBox = new JComboBox();
		comBox.addItem("音乐天地");
		comBox.addItem("武术天地");
		comBox.addItem("象棋乐园");
		add(comBox);
		add(new JLabel("文本区"));
		area = new JTextArea(6, 12);
		add(new JScrollPane(area));
		
	}
}
