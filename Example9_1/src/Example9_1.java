import javax.swing.*;
import java.awt.*;


public class Example9_1 {

	public static void main(String[] args) {
		
		JFrame window1 = new JFrame("��һ������");
		JFrame window2 = new JFrame("�ڶ�������");
		
		Container con = window1.getContentPane();
		//Container һ��ͨ�õĳ��󴰿�
		//getContenPane ���ش�֡�� ContentPane����
		
		con.setBackground(Color.yellow);
		//setBackground ���� Component ����  ���ô��齨����ɫ.
		//Color �����ڷ�װ�е�Ĭ�� sRGB ɫ�ʿռ����ɫ
		
		window1.setBounds(60, 100, 188, 108);
		window2.setBounds(260, 100, 188, 108);
		//���ô��ڵĳ�ʼλ�� ,������Ļ����x������,����Ļ�Ϸ�y������,���ڵĿ���width,����height��
		
		window1.setVisible(true);
		//���ô����Ƿ�ɼ�,����Ĭ�ϲ��ɼ�
		window1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//�÷����������õ����������ϽǵĹر�ͼ���,�����������ô���Ĵ���
		//operation ȡJFrame���еĳ������ݲ���operationȡֵ������ͬ�Ĵ���
		//DO_NOTHING_ON_CLOSE(ʲôҲ����)
		//HIDE_ON_CLOSE(���ص�ǰ����)
		//DISPOSE_ON_CLOSE(���ص�ǰ����,���ͷŴ���ռ�е�������Դ)
		//EXIT_ON_CLOSE(�����������ڵ�Ӧ�ó���)
		
		window2.setVisible(true);
		window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
