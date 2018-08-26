import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JScrollPane;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class GUI {

	private JFrame frame;
	private int xx, yy;
	private boolean isDraging = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setUndecorated(true);		
		frame.setOpacity(0.76f);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.setBounds(448, 156, 1280, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setShape(new RoundRectangle2D.Double(0.0, 0.0, frame.getWidth()+1, frame.getHeight()+1, 26.0, 26.0));	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(221, 220, 221));
		panel.setBorder(null);
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(221, 220, 221));
		panel.add(panel_7);
		panel_7.setLayout(new BoxLayout(panel_7, BoxLayout.X_AXIS));
		
		Component horizontalGlue_2 = Box.createHorizontalGlue();
		panel_7.add(horizontalGlue_2);
		
		Component verticalStrut_1 = Box.createVerticalStrut(60);
		panel_7.add(verticalStrut_1);
		
		JButton btnNewButton_7 = new JButton();
		panel_7.add(btnNewButton_7);
		btnNewButton_7.setBackground(new Color(221, 220, 221));
		btnNewButton_7.setBorder(null);
		btnNewButton_7.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\fullscreen.png"));
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(20);
		panel_7.add(horizontalStrut_4);
		
		JButton btnNewButton_8 = new JButton();
		panel_7.add(btnNewButton_8);
		btnNewButton_8.setBackground(new Color(221, 220, 221));
		btnNewButton_8.setBorder(null);
		btnNewButton_8.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\minimize.png"));
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(20);
		panel_7.add(horizontalStrut_5);
		
		JButton btnNewButton_9 = new JButton();
		panel_7.add(btnNewButton_9);
		btnNewButton_9.setBackground(new Color(221, 220, 221));
		btnNewButton_9.setBorder(null);
		btnNewButton_9.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\close1.png"));
		
		Component horizontalStrut_6 = Box.createHorizontalStrut(20);
		panel_7.add(horizontalStrut_6);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(221, 220, 221));
		panel.add(panel_5);
		panel_5.setLayout(new BoxLayout(panel_5, BoxLayout.X_AXIS));
		
		Component verticalStrut = Box.createVerticalStrut(30);
		panel_5.add(verticalStrut);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(192, 192, 193));
		panel.add(panel_6);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_6.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(53, 64, 80));
		panel_1.setBorder(null);
		frame.getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		
		JButton btnNewButton = new JButton("New button");
		panel_1.add(btnNewButton);
		
		Component verticalStrut_2 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_2);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel_1.add(btnNewButton_1);
		
		Component verticalStrut_3 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_3);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel_1.add(btnNewButton_2);
		
		Component verticalStrut_4 = Box.createVerticalStrut(20);
		panel_1.add(verticalStrut_4);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(1);
		splitPane.setResizeWeight(0.7);
		frame.getContentPane().add(splitPane, BorderLayout.CENTER);
		splitPane.setBorder(null);
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		splitPane.setLeftComponent(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(240, 240, 240));
		scrollPane.setViewportView(textArea);
		
		JPanel panel_3 = new JPanel();
		splitPane.setRightComponent(panel_3);
		panel_3.setLayout(new BoxLayout(panel_3, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(null);
		panel_3.add(scrollPane_1);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBackground(new Color(240, 240, 240));
		scrollPane_1.setViewportView(textArea_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(240, 240, 240));
		scrollPane_1.setColumnHeaderView(panel_4);
		panel_4.setLayout(new BoxLayout(panel_4, BoxLayout.X_AXIS));
		
		Component horizontalStrut_7 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_7);
		
		JButton btnNewButton_3 = new JButton();
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\288.png"));
		panel_4.add(btnNewButton_3);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_3);
		
		JButton btnNewButton_4 = new JButton();
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\rectangle-1298.png"));
		btnNewButton_4.setBorder(null);
		panel_4.add(btnNewButton_4);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_2);
		
		JButton btnNewButton_5 = new JButton();
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\asus\\Desktop\\Mac\u7CFB\u7EDF\u684C\u9762Mockup+-+Desktop+Kit\\Mac\u7CFB\u7EDF\u684C\u9762Mockup - Desktop Kit\\rectangle-1091.png"));
		btnNewButton_5.setBorder(null);
		panel_4.add(btnNewButton_5);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_4.add(horizontalStrut_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 240, 240));
		panel_3.add(panel_2);
		panel_2.setBorder(null);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
		
		Component horizontalGlue = Box.createHorizontalGlue();
		panel_2.add(horizontalGlue);
		
		JButton btnNewButton_6 = new JButton("send");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_6.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(btnNewButton_6);
		
		Component rigidArea = Box.createRigidArea(new Dimension(30, 0));
		panel_2.add(rigidArea);
		
		
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
