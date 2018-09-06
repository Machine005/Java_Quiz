package test3;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Transparency;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class CircleIcon{
	BufferedImage bi1,bi2;
	public CircleIcon(File file) throws IOException{
		bi1 = ImageIO.read(file);
	    // 根据需要是否使用 BufferedImage.TYPE_INT_ARGB
	    bi2 = new BufferedImage(bi1.getWidth(), bi1.getHeight(),
	            BufferedImage.TYPE_INT_RGB);
	}
	public ImageIcon init() {
		Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, bi1.getWidth(), bi1
		            .getHeight());
		Graphics2D g2 = bi2.createGraphics();
		g2.setBackground(Color.WHITE);
		g2.fill(new Rectangle(bi2.getWidth(), bi2.getHeight()));
		g2.setClip(shape);
		    // 使用 setRenderingHint 设置抗锯齿
		g2.drawImage(bi1, 0, 0, null);
	    g2.dispose();
	    return new ImageIcon(bi2);
	}
	public static void main(String[] args) throws IOException {
        JButton button = new JCircleButton("1234");
        
      //  CircleIcon kk=new CircleIcon(new File("E:\\repo\\pro\\Java_Quiz\\GUI_Communication\\icon\\182.png"));      
        BufferedImage image = ImageIO.read(new File("E:\\repo\\pro\\Java_Quiz\\GUI_Communication\\icon\\182.png"));
		BufferedImage rounded = makeRoundedCorner(image, 40);
		
        button.setIcon(new ImageIcon(rounded));
        button.setBackground(Color.orange);
 
        JFrame frame = new JFrame("圆形按钮");
        frame.getContentPane().setBackground(Color.pink);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.getContentPane().add(button);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    }
	public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
		int w = image.getWidth();
		int h = image.getHeight();
		
		Ellipse2D.Double shape = new Ellipse2D.Double(0, 0, image.getWidth(), image
	            .getHeight());
		
		BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = output.createGraphics();
		g2.setComposite(AlphaComposite.Src);
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setColor(Color.WHITE);
		g2.fill(new Rectangle(output.getWidth(), output.getHeight()));
		
		g2.setClip(shape);
		
		g2.setComposite(AlphaComposite.SrcAtop);
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
		return output;
	}
}
	class JCircleButton extends JButton{
		  public JCircleButton(String label) {
		        super(label);
		        // 获取按钮的最佳大小
		        Dimension size = getPreferredSize();
//		        size.width = size.height = Math.max(size.width, size.height);
		        size.width = size.height = 128;
		        setPreferredSize(size);
		       
		        setContentAreaFilled(false);
		        this.setBorderPainted(false); // 不绘制边框
		        this.setFocusPainted(false); // 不绘制焦点状态
		    }
		 
		    // 画圆的按钮的背景和标签
		    protected void paintComponent(Graphics g) {
		 
		        if (getModel().isArmed()) {
		            g.setColor(Color.lightGray); // 点击时高亮
		        } else {
		            g.setColor(getBackground());
		        }
		        // fillOval方法画一个矩形的内切椭圆，并且填充这个椭圆，
		        // 当矩形为正方形时，画出的椭圆便是圆
		        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		 
		        super.paintComponent(g);
		    }
		 
		    // 用简单的弧画按钮的边界。
		    protected void paintBorder(Graphics g) {
		        g.setColor(Color.white);
		        // drawOval方法画矩形的内切椭圆，但不填充。只画出一个边界
		        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
		    }
		 
		    // shape对象用于保存按钮的形状，有助于侦听点击按钮事件
		    Shape shape;
		 
		    public boolean contains(int x, int y) {
		 
		        if ((shape == null) || (!shape.getBounds().equals(getBounds()))) {
		            // 构造一个椭圆形对象
		            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		        }
		        // 判断鼠标的x、y坐标是否落在按钮形状内。
		        return shape.contains(x, y);
		    }
}
