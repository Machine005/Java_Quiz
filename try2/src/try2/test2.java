package try2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class test2 {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try(ServerSocket ssck=new ServerSocket(10000);
				Socket sck=ssck.accept();
				BufferedReader is=new BufferedReader(new InputStreamReader(sck.getInputStream()));
				BufferedWriter os=new BufferedWriter(new OutputStreamWriter(sck.getOutputStream()))) {
			String info;
			info=is.readLine();
			System.out.println(info);
			
			os.write("asfasdf");
			os.newLine();
			os.flush();
			
			info=is.readLine();
			System.out.println(info);
			
			
			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

}
