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
	    // ������Ҫ�Ƿ�ʹ�� BufferedImage.TYPE_INT_ARGB
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
		    // ʹ�� setRenderingHint ���ÿ����
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
 
        JFrame frame = new JFrame("Բ�ΰ�ť");
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
		        // ��ȡ��ť����Ѵ�С
		        Dimension size = getPreferredSize();
//		        size.width = size.height = Math.max(size.width, size.height);
		        size.width = size.height = 128;
		        setPreferredSize(size);
		       
		        setContentAreaFilled(false);
		        this.setBorderPainted(false); // �����Ʊ߿�
		        this.setFocusPainted(false); // �����ƽ���״̬
		    }
		 
		    // ��Բ�İ�ť�ı����ͱ�ǩ
		    protected void paintComponent(Graphics g) {
		 
		        if (getModel().isArmed()) {
		            g.setColor(Color.lightGray); // ���ʱ����
		        } else {
		            g.setColor(getBackground());
		        }
		        // fillOval������һ�����ε�������Բ��������������Բ��
		        // ������Ϊ������ʱ����������Բ����Բ
		        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
		 
		        super.paintComponent(g);
		    }
		 
		    // �ü򵥵Ļ�����ť�ı߽硣
		    protected void paintBorder(Graphics g) {
		        g.setColor(Color.white);
		        // drawOval���������ε�������Բ��������䡣ֻ����һ���߽�
		        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
		    }
		 
		    // shape�������ڱ��水ť����״�����������������ť�¼�
		    Shape shape;
		 
		    public boolean contains(int x, int y) {
		 
		        if ((shape == null) || (!shape.getBounds().equals(getBounds()))) {
		            // ����һ����Բ�ζ���
		            shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
		        }
		        // �ж�����x��y�����Ƿ����ڰ�ť��״�ڡ�
		        return shape.contains(x, y);
		    }
}
