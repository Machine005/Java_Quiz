import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class WindowMenu extends JFrame{
	JMenuBar menubar; 
	//���ฺ�𴴽��˵���
	JMenu menu,subMenu;
	//���ฺ�𴴽��˵�
	JMenuItem item1,item2;
	//���ฺ�𴴽��˵���
	
	public WindowMenu() {}
	
	public WindowMenu(String s, int x, int y, int w, int h) {
		init(s);
		setLocation(x, y);
		//��������ƶ�����λ��.
		setSize(w, h);
		//�����������С.
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	void init(String s) {
		setTitle(s);
		//����֡��������Ϊָ���ַ���.
		menubar = new JMenuBar();
		menu = new JMenu("�˵�");
		subMenu = new JMenu("�����Ŀ");
		item1 = new JMenuItem("Java����");
		item2 = new JMenuItem("��������");
		item1.setAccelerator(KeyStroke.getKeyStroke('A'));
		//setAccelerator()�����ڲ������˵���νṹ������µ��ò˵���Ķ�������������ϼ�.(��ݼ�,��ϼ�?)
		//KeyStroke ��ʾ���̻��Ч�����豸�ϵĹؼ�����.
		//getKeyStroke()����һ��KeyStroke�Ĺ���ʵ��,��ʾָ���ַ���KEY_TYPED�¼�.
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		//KeyEvent ָʾ�齨�з����������¼� VK_S����ΪS�ļ�.
		//InputEvent ��������������¼��ĸ��¼���  CTRL_DOWN_MASK ���Ƽ���չ�޸ĳ���.
		
		menu.add(item1);
		//���˵�����ӵ��˲˵���ĩβ
		menu.addSeparator();
		//�ڲ˵�ĩβ����һ���µķָ���
		menu.add(item2);
		menu.add(subMenu);
		//Ƕ���Ӳ˵�
		subMenu.add(new JMenuItem("��������ϵͳ"));
		subMenu.add(new JMenuItem("ũ����Ϣϵͳ"));
		menubar.add(menu);
		//��ָ���Ĳ˵����ӵ��˵���ĩβ
		setJMenuBar(menubar);
		//���˵�����ӵ����ڵĶ���
	}
}
