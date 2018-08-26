

import java.awt.Image;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;


public class test extends JFrame{

	//����ͼƬbgImage
	private ImageIcon bgImage = new ImageIcon("src/images/0001.PNG");
	//���ڴ����϶��¼�����ʾ��갴��ʱ�����꣬�����JFrame
	int xOld = 0;
	int yOld = 0;

	public test() {

		getContentPane().setLayout(null);
		this.setLocationRelativeTo(null);
		bgImage.setImageObserver(null);
		this.setSize(( bgImage).getIconWidth(),bgImage.getIconHeight());

		//�����϶��¼�---ȥ��Ĭ�ϱ߿�󣬲����϶��ˣ�����ʵ������
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xOld = e.getX();//��¼��갴��ʱ������
				yOld = e.getY();
			}
		});

		this.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int xOnScreen = e.getXOnScreen();
				int yOnScreen = e.getYOnScreen();
				int xx = xOnScreen - xOld;
				int yy = yOnScreen - yOld;
				test.this.setLocation(xx, yy);//������ק�󣬴��ڵ�λ��
			}
		});

		/**
		 * JLayeredPane�����������ͼ��ģ�һ�����ڱ�����һ�����ڽ���
		 * JLayeredPane ������ȷ�Χ�ֳɼ�����ͬ�Ĳ㡣�����������Ӧ�Ĳ㣬����������ȷ�������ȷ���ص�
		 * �ڵ��� add �Ĺ�����ͨ������ intֵ���Ӷ��� Component ������ layer ����
		 */
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setSize(bgImage.getIconWidth(), bgImage.getIconHeight());
		getContentPane().add(layeredPane);

		//����ͼ��Panel,�䵱����---��ײ�
		JPanel bgPanel = new JPanel();
		bgPanel.setSize(bgImage.getIconWidth(),bgImage.getIconHeight());
		layeredPane.add(bgPanel);

		//����ͼƬ����ӵ�����ͼ��Panel����
		JLabel bgLabel = new JLabel(bgImage);
		bgPanel.add(bgLabel);

		//�����棬Ҳ���Ǳ��������һ��Panel����������ӿؼ�
		JPanel mainPanel = new JPanel();
		mainPanel.setSize(200,200);
		mainPanel.setLayout(null);
		layeredPane.add(mainPanel);

		//�رհ�ť
		JButton closeButton = new JButton();
		closeButton.setIcon(new ImageIcon("src/images/closebtn.png"));
		closeButton.setSize(30, 30);
		mainPanel.add(closeButton);

		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		this.setUndecorated(true);
	}

	public static void main(String[] args) {
		test j = new test();
		j.setVisible(true);
	}

}


