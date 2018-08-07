import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
 
public class TCPClientDemo {
 
	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
        //1.建立TCP连接
		String ip="192.168.101.3";   //服务器端ip地址
		int port=10003;        //端口号
		Socket sck=new Socket(ip,port);
		//2.传输内容
		OutputStream os=sck.getOutputStream();   //输出流
		String content="这是一个java客户端";
		
		byte[] bstream=content.getBytes();
		//System.out.println(new String(bstream));
		
		os.write(bstream);
		//3.关闭连接
		sck.close();
	}
 
}
