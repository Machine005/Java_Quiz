import javax.swing.*;
import java.awt.*;


public class Example9_1 {

	public static void main(String[] args) {
		
		JFrame window1 = new JFrame("第一个窗口");
		JFrame window2 = new JFrame("第二个窗口");
		
		Container con = window1.getContentPane();
		//Container 一个通用的抽象窗口
		//getContenPane 返回此帧的 ContentPane对象
		
		con.setBackground(Color.yellow);
		//setBackground 父类 Component 方法  设置此组建背景色.
		//Color 类用于封装中的默认 sRGB 色彩空间的颜色
		
		window1.setBounds(60, 100, 188, 108);
		window2.setBounds(260, 100, 188, 108);
		//设置窗口的初始位置 ,即距屏幕左面x个像素,距屏幕上方y个像素,窗口的宽是width,高是height。
		
		window1.setVisible(true);
		//设置窗口是否可见,窗口默认不可见
		window1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//该方法用来设置单机窗体右上角的关闭图标后,程序会做出怎么样的处理
		//operation 取JFrame类中的常量根据参数operation取值做出不同的处理
		//DO_NOTHING_ON_CLOSE(什么也不做)
		//HIDE_ON_CLOSE(隐藏当前窗口)
		//DISPOSE_ON_CLOSE(隐藏当前窗口,并释放窗体占有的其他资源)
		//EXIT_ON_CLOSE(结束窗口所在的应用程序)
		
		window2.setVisible(true);
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
