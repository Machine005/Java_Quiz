import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSplitPane;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.ScrollPaneConstants;
import javax.swing.JPopupMenu;


public class test {

	private JFrame frame;
	private final JPanel panel_2 = new JPanel();
	

	private int xx, yy;
	private boolean isDraging = false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test window = new test();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public test() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(Color.WHITE);
		
		frame.setUndecorated(true);
		frame.setBounds(448, 156, 1024, 768);
		
		frame.setShape(new RoundRectangle2D.Double(0.0, 0.0, frame.getWidth()+1, frame.getHeight()+1, 26.0, 26.0));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(211, 211, 211));
		panel_5.setBorder(null);
		panel_5.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_5.setAlignmentX(Component.LEFT_ALIGNMENT);
		frame.getContentPane().add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.Y_AXIS));
		
		Component verticalStrut_1 = Box.createVerticalStrut(10);
		panel_5.add(verticalStrut_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(null);
		panel_5.add(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(211, 211, 211));
		panel_4.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		JButton btnNewButton_8 = new JButton();
		btnNewButton_8.setBackground(new Color(211, 211, 211));
		panel_7.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_8.setBorder(null);
		btnNewButton_8.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\close1.png"));
		
		Component horizontalStrut = Box.createHorizontalStrut(14);
		panel_7.add(horizontalStrut);
		
		JButton btnNewButton_9 = new JButton();
		btnNewButton_9.setBackground(new Color(211, 211, 211));
		panel_7.add(btnNewButton_9);
		btnNewButton_9.setBorder(null);
		btnNewButton_9.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\minimize.png"));
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(14);
		panel_7.add(horizontalStrut_1);
		
		JButton btnNewButton_10 = new JButton();
		btnNewButton_10.setBackground(new Color(211, 211, 211));
		panel_7.add(btnNewButton_10);
		btnNewButton_10.setBorder(null);
		btnNewButton_10.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\fullscreen.png"));
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(430);
		panel_7.add(horizontalStrut_3);
		
		JLabel lblNewLabel = new JLabel("\u7A97\u4F53");
		panel_7.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setIcon(null);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(420);
		panel_7.add(horizontalStrut_4);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Component verticalStrut = Box.createVerticalStrut(20);
		verticalStrut.setBackground(new Color(211, 211, 211));
		panel_5.add(verticalStrut);
		
		JPanel panel_6 = new JPanel();
		panel_5.add(panel_6);
		panel_6.setLayout(new BoxLayout(panel_6, BoxLayout.X_AXIS));
		
		JMenuBar menuBar = new JMenuBar();
		panel_6.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu menu = new JMenu("Menu");
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("New menu item");
		menu.add(menuItem);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		menuBar.add(horizontalGlue_1);
		
		JSplitPane splitPane_2 = new JSplitPane();
		splitPane_2.setResizeWeight(0.01);
		splitPane_2.setBackground(new Color(211, 211, 211));
		splitPane_2.setEnabled(false);
		splitPane_2.setBorder(null);
		splitPane_2.setOpaque(false);
		splitPane_2.setDividerSize(0);
		frame.getContentPane().add(splitPane_2);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(null);
		splitPane.setOpaque(false);
		splitPane_2.setRightComponent(splitPane);
		splitPane.setResizeWeight(0.67);
		splitPane.setDividerSize(0);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.04);
		splitPane_1.setBorder(null);
		splitPane_1.setOpaque(false);
		splitPane_1.setDividerSize(0);
		splitPane_1.setEnabled(false);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(211, 211, 211));
		panel.setBorder(null);
		splitPane_1.setLeftComponent(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JButton btnNewButton_1 = new JButton();
		btnNewButton_1.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_1.setBackground(new Color(211, 211, 211));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\rectangle-1091.png"));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(15);
		panel.add(horizontalStrut_2);
		
		JButton button = new JButton();
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		button.setBackground(new Color(211, 211, 211));
		button.setBorder(null);
		button.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\288.png"));
		panel.add(button);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(10);
		panel.add(horizontalStrut_5);
		panel.add(btnNewButton_1);
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(10);
		panel.add(horizontalStrut_6);
		
		JButton btnNewButton_4 = new JButton();
		btnNewButton_4.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_4.setBackground(new Color(211, 211, 211));
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\rectangle-1298.png"));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(btnNewButton_4);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(211, 211, 211));
		panel_1.setBorder(null);
		splitPane_1.setRightComponent(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setAlignmentY(Component.TOP_ALIGNMENT);
		scrollPane.setBorder(null);
		scrollPane.setOpaque(false);
		panel_1.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setBorder(null);
		panel_2.setBackground(new Color(211, 211, 211));
		panel_2.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_2.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_2.setBorder(null);
		panel_1.add(panel_2);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		JButton btnNewButton_3 = new JButton("send");
		btnNewButton_3.setBackground(new Color(211, 211, 211));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_2 = new JButton("close");
		btnNewButton_2.setBackground(new Color(211, 211, 211));
		panel_2.add(btnNewButton_2);
		panel_2.add(btnNewButton_3);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane_1.setVerticalScrollBarPolicy(   
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		scrollPane_1.setBorder(null);
		scrollPane_1.setOpaque(false);
		scrollPane_1.setEnabled(false);
		splitPane.setLeftComponent(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEnabled(false);
		textArea_1.setBorder(null);
		scrollPane_1.setViewportView(textArea_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(211, 211, 211));
		panel_3.setBorder(null);
		panel_3.setEnabled(false);
		
		splitPane_2.setLeftComponent(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		Component verticalStrut_2 = Box.createVerticalStrut(15);
		panel_3.add(verticalStrut_2);
		
		JButton btnNewButton_5 = new JButton();
		btnNewButton_5.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_5.setBackground(new Color(211, 211, 211));
		btnNewButton_5.setBorder(null);
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\182.png"));
		btnNewButton_5.setSize(5, 5);
		panel_3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton();
		btnNewButton_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_6.setBackground(new Color(211, 211, 211));
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\177.png"));
		btnNewButton_6.setBorder(null);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		Component verticalStrut_3 = Box.createVerticalStrut(10);
		panel_3.add(verticalStrut_3);
		btnNewButton_6.setSize(5, 5);
		panel_3.add(btnNewButton_6);
		
		Component verticalStrut_4 = Box.createVerticalStrut(10);
		panel_3.add(verticalStrut_4);
		
		JButton btnNewButton_7 = new JButton();
		btnNewButton_7.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton_7.setBackground(new Color(211, 211, 211));
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\180.png"));
		btnNewButton_7.setBorder(null);
		btnNewButton_7.setSize(5, 5);
		panel_3.add(btnNewButton_7);
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(40);
		panel_3.add(horizontalStrut_7);
		
		frame.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				isDraging = true;
				xx = e.getX();
				yy = e.getY();
			}
			public void mouseReleased(MouseEvent e) {
				isDraging = false;
			}
		});
		frame.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				if (isDraging) {
					int left = frame.getLocation().x;
					int top = frame.getLocation().y;
					frame.setLocation(left + e.getX() - xx, top + e.getY() - yy);
				}
			}
		});
	}
	
	
}
