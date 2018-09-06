package try2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

class receive implements Runnable{
	ServerSocket ssck;
	int k;
	receive(int i,ServerSocket ssck1){
		this.k = i;
		ssck = ssck1;
	}
	@Override
	public void run() {
		try(
			Socket sck = ssck.accept();
			InputStream is = new BufferedInputStream(sck.getInputStream());	){
			
		System.out.println("This is Thread:"+ k);
		int i = -1, j=0;
		byte []by = new byte[200];
		
			while((i = is.read())!= -1) {			
				by[j++] = (byte) i;
				System.out.println("Thread"+k+":"+i);
			}
			//System.out.println(new String(by));
		}catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
	
}
class send implements Runnable{
	OutputStream os;
	int i;
	send(OutputStream os, int i){
		this.os = os;
		this.i = i;
	}
	@Override
	public void run() {
		System.out.println("This is Thread:"+ i);
		
		for(int i = 0; i<101; i++) {
			try {
				os.write(i);
				os.flush();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
}
class send1 implements Runnable{
	OutputStream os;
	int i;
	send1(OutputStream os, int i){
		this.os = os;
		this.i = i;
	}
	@Override
	public void run() {
		System.out.println("This is Thread:"+ i);
		
		for(int i = 101; i>0; i--) {
			try {
				os.write(i);
				os.flush();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		}
	}
	
}
public class try2 {
	static Socket sck1,sck12;
	public static void main(String[] args) throws UnknownHostException, IOException, InterruptedException {
		
		sck1 = new Socket("192.168.1.195", 2000);	
		//Thread receive = new Thread(new receive(new BufferedInputStream(sck1.getInputStream()), 2));
		Thread send1 = new Thread(new send(new BufferedOutputStream(sck1.getOutputStream()), 3));
		//receive.start();
		send1.start();
		sck12 = new Socket("192.168.1.195", 2000);
		Thread send2 = new Thread(new send1(new BufferedOutputStream(sck12.getOutputStream()), 3));
		//Thread.sleep(1500);
		send2.start();
		
		
		Thread.sleep(5000);
		sck1.shutdownOutput();
		sck1.shutdownInput();
		sck1.close();
		sck12.close();
	}

}
