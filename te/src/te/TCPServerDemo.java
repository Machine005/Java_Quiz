package te;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
 
 
public class TCPServerDemo {
	private ServerSocket serverSocket;  
    private DataInputStream dataInputStream;  
      
    public void startServer(){  
    	Socket socket =null;
    	
    	while(socket==null) {
        try {
            serverSocket = new ServerSocket(10003);  
            socket = serverSocket.accept();  
            dataInputStream = new DataInputStream(socket.getInputStream());  
            GetMessageFromClient();  
        } catch (IOException e) {   
            e.printStackTrace();  
        }finally{
        	if(socket!=null){
        		try{
        			socket.close();
        		}catch(IOException e) { 
        			e.printStackTrace(); 
        		}
        	}
        }
    	}
        
    }  
      
    private void GetMessageFromClient(){  
        try {              
            //获取消息
        	String message="";
            byte[] body = new byte[2];
            while(dataInputStream.read(body)!=-1) {
            	message+= new String(body); 
            }
            System.out.println("客户端说："+message);  
        } catch (IOException e) {    
            e.printStackTrace();  
        }  
    }  
	public static void main(String[] args) {
		TCPServerDemo server = new TCPServerDemo();  
	    server.startServer();  
	}
 
}
