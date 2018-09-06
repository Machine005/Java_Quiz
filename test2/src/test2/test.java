package test2;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

class Key{
	private String IpPort;
	private int PID;
	Key(String IpPort, int PID){
		this.IpPort = IpPort;
		this.PID = PID;
	}

    // Hash code depends only on 'id' which cannot be
    // changed once object is created. So hash code will not change
    // on object's state change
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + PID;
    	return IpPort.hashCode()+result;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Key other = (Key) obj;
        if (PID != other.PID)
            return false;
        if(IpPort.equals(other.IpPort)==false) 	
        	return false;
        return true;
    }

}
class value{
	String value;
	value(String value){
		this.value = value;
	}
	public String toString() {
		return value;
	}
}

class Threada implements Runnable{
	private Key key;
	private test Test;
	Threada(Key key,test Test){
		this.key = key;
		this.Test = Test;
	}
	public void run() {
		synchronized(this) {
				try {
					//while(true) {
					wait();
					//}
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				System.out.println(test.conMap.get(key));
				test.conMap.get(key).value = "2222";
				System.out.println(test.conMap.get(key));
			}
			
		}
}
class threadPut implements Runnable{
	private test Test;
	threadPut(test Test){
		this.Test = Test;
	}
	 public void run() {     
     	synchronized(this) {
     			synchronized(Test.threada1) {
     				Test.conMap.putIfAbsent(new Key("192.168.1.101:11",2), new value("1000"));
     				Test.threada1.notify();
     			}
     		    synchronized(Test.threada2) {
     		        Test.conMap.putIfAbsent(new Key("192.168.1.101:11",1), new value("1001"));  
     		        Test.threada2.notify();
     		    }
     		    try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}   
     	}
	 }
}

public class test {
	static Map<Key, value> conMap = new ConcurrentHashMap<Key, value>();
	
    Threada threada1;
    Threada threada2;
    test(){
    	threada1 = new Threada(new Key("192.168.1.101:11",2), this);
    	threada2 = new Threada(new Key("192.168.1.101:11",1), this);
    	
    	Thread thread = new Thread(new threadPut(this));
	    Thread threada11 = new Thread(threada1);
	    Thread threada22 = new Thread(threada2);
	    threada11.start();
	    threada22.start();
	    thread.start();
    }
    
	public static void main(String[] args) throws InterruptedException {
		new test();
	}
}
