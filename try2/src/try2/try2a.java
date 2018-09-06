package try2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class try2a {
	//static Socket sck2,sck3;
	static ServerSocket ssck;
	public static void main(String[] args) throws InterruptedException, IOException {
				ssck = new ServerSocket(2000);
			//	sck2 = ssck.accept();
				Thread receive1 = new Thread(new receive(0,ssck));
			//	Thread send = new Thread(new send(new BufferedOutputStream(sck2.getOutputStream()), 1));	
				//send.start();
				receive1.start();
			//	Thread.sleep(1000);
			//	sck3 = ssck.accept();
				Thread receive2 = new Thread(new receive(1,ssck));
				receive2.start();
				
				Thread.sleep(5000);
	}

}
