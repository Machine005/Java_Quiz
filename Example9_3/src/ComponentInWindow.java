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
	//���������ı���
	JTextArea area;
	//���������ı���
	JButton button;
	//��ť
	JCheckBox checkBox1, checkBox2, checkBox3;
	//ѡ���
	JRadioButton radio1, radio2;
	//��ѡ��
	JComboBox comBox;
	//�����б�
	ButtonGroup group;
	//��ť��
	
	public ComponentInWindow() {
		init();
		setVisible(true);
		//���ô����Ƿ�ɼ�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//���õ���ر�ͼ�������������ô���Ĵ���
	}
	void init() {
		setLayout(new FlowLayout());
		//���ô��ڲ���
		add(new JLabel("�ı���:"));
		text = new JTextField(10);
		add(text);
		add(new JLabel("��ť:"));
		button = new JButton("ȷ��");
		add(button);
		add(new JLabel("ѡ���"));
		checkBox1 = new JCheckBox("ϲ������"); 
		checkBox2 = new JCheckBox("ϲ������");
		checkBox3 = new JCheckBox("ϲ������");
		add(checkBox1);
		add(checkBox2);
		add(checkBox3);
		add(new JLabel("��ѡ��ť:"));
		group = new ButtonGroup();
		radio1 = new JRadioButton("��");
		radio2 = new JRadioButton("Ů");
		group.add(radio1);
		group.add(radio2);
		add(radio1);
		add(radio2);
		add(new JLabel("�����б�:"));
		comBox = new JComboBox();
		comBox.addItem("�������");
		comBox.addItem("�������");
		comBox.addItem("������԰");
		add(comBox);
		add(new JLabel("�ı���"));
		area = new JTextArea(6, 12);
		add(new JScrollPane(area));
		
	}
}