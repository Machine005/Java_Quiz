import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class WindowMenu extends JFrame{
	JMenuBar menubar; 
	//该类负责创建菜单条
	JMenu menu,subMenu;
	//该类负责创建菜单
	JMenuItem item1,item2;
	//该类负责创建菜单项
	
	public WindowMenu() {}
	
	public WindowMenu(String s, int x, int y, int w, int h) {
		init(s);
		setLocation(x, y);
		//将此组件移动到新位置.
		setSize(w, h);
		//调整此组件大小.
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	void init(String s) {
		setTitle(s);
		//将此帧标题设置为指定字符串.
		menubar = new JMenuBar();
		menu = new JMenu("菜单");
		subMenu = new JMenu("软件项目");
		item1 = new JMenuItem("Java话题");
		item2 = new JMenuItem("动画话题");
		item1.setAccelerator(KeyStroke.getKeyStroke('A'));
		//setAccelerator()设置在不导航菜单层次结构的情况下调用菜单项的动作侦听器的组合键.(快捷键,组合键?)
		//KeyStroke 表示键盘或等效输入设备上的关键操作.
		//getKeyStroke()返回一个KeyStroke的共享实例,表示指定字符的KEY_TYPED事件.
		item2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_DOWN_MASK));
		//KeyEvent 指示组建中发生击键的事件 VK_S常数为S的键.
		//InputEvent 所有组件级输入事件的根事件类  CTRL_DOWN_MASK 控制键扩展修改常数.
		
		menu.add(item1);
		//将菜单项添加到此菜单的末尾
		menu.addSeparator();
		//在菜单末尾附加一个新的分隔符
		menu.add(item2);
		menu.add(subMenu);
		//嵌入子菜单
		subMenu.add(new JMenuItem("汽车销售系统"));
		subMenu.add(new JMenuItem("农场信息系统"));
		menubar.add(menu);
		//将指定的菜单附加到菜单栏末尾
		setJMenuBar(menubar);
		//将菜单条添加到窗口的顶端
	}
}
