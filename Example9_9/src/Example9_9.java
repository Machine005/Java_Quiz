import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Example9_9 {

	public static void main(String[] args) {
		WindowDocument win = new WindowDocument();
		win.setBounds(100, 100, 590, 500);
		win.setTitle("排序单词");
	}

}
class WindowDocument extends JFrame{
	JTextArea inputText,showText;
	JMenuBar menubar;
	JMenu menu;
	JMenuItem itemCopy,itemCut,itemPaste;
	TextListener textChangeListener;
	HandleListener handleListener;
	WindowDocument(){
		init();
		setLayout(new FlowLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init() {
		inputText = new JTextArea(15, 20);
		showText = new JTextArea(15, 20);
		showText.setLineWrap(true); //文本自动换行
		showText.setWrapStyleWord(true); //文本区以单词为界自动换行
		menubar = new JMenuBar();
		menu = new JMenu("编辑");
		itemCopy = new JMenuItem("复制(C)");
		itemCut = new JMenuItem("剪切(T)");
		itemPaste = new JMenuItem("粘贴(P)");
		itemCopy.setAccelerator(KeyStroke.getKeyStroke('c')); //设置快捷方式
		itemCut.setAccelerator(KeyStroke.getKeyStroke('t'));
		itemPaste.setAccelerator(KeyStroke.getKeyStroke('p'));
		itemCopy.setActionCommand("copy");
		itemCut.setActionCommand("Cut");
		itemPaste.setActionCommand("paste");
		menu.add("itemCopy");
		menu.add("itemCut");
		menu.add("itemPaste");
		menubar.add(menu);
		setJMenuBar(menubar);
		add(new JScrollPane(inputText));
		add(new JScrollPane(showText));
		textChangeListener = new TextListener();
		handleListener = new HandleListener();
		textChangeListener.setInputText(inputText);
		textChangeListener.setShowtext(showText);
		handleListener.setInputText(inputText);
		handleListener.setShowText(showText);
		
		inputText.getDocument().addDocumentListener(textChangeListener);
		itemCopy.addActionListener(handleListener);
		itemCut.addActionListener(handleListener);
		itemPaste.addActionListener(handleListener);
	}
}
class TextListener implements DocumentListener{
	JTextArea inputText,showText;
	public void setInputText(JTextArea text) {
		inputText = text;
	}
	public void setShowtext(JTextArea text) {
		showText = text;
	}
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO 自动生成的方法存根
		changedUpdate(e);
	}
	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO 自动生成的方法存根
		changedUpdate(e);
	}
	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO 自动生成的方法存根
		String  str = inputText.getText();
		
		String regex = "[\\s\\d\\p{Punct}]+";
		String words[] = str.split(regex);
		Arrays.sort(words);
		showText.setText(null);
		for(int i=0; i<words.length; i++) {
			showText.append(words[i]+",");
		}
	}
	
}

class HandleListener implements ActionListener{
	JTextArea inputText, showText;
	public void setShowText(JTextArea text) {
		showText = text;
	}
	public void setInputText(JTextArea text) {
		inputText = text;
	}
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		
		if(str.equals("copy")) showText.copy();
		else if(str.equals("cut")) showText.cut();
		else if(str.equals("paste")) inputText.paste();
		
		
	}
}