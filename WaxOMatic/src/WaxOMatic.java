import static net.mindview.util.Print.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
	private boolean waxOn = false;
	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
		//���������߳�
	}
	public synchronized void buffed() {
		waxOn = false;
		notifyAll();
	}
	public synchronized void waitForWaxing() throws InterruptedException{
		while(waxOn == false) 
			wait();
	}
	public synchronized void waitForBuffing()throws InterruptedException{
		while(waxOn == true)
			wait();
	}
}

class WaxOn implements Runnable{
	private Car car;
	public WaxOn(Car c) { car = c;}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		try {
			while(!Thread.interrupted()) {
				//���Ե�ǰ�߳��Ƿ����ж�
				printnb("Wax On! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed();
				car.waitForBuffing();
			}
		}catch(InterruptedException e) {
			print("Exiting via interrupt");
		}
		print("Ending Wax On task");
	}
	
}
class WaxOff implements Runnable{
	private Car car;
	public WaxOff(Car c) { car = c;}
	@Override
	public void run() {
		// TODO �Զ����ɵķ������
		while(!Thread.interrupted()) {
			//���Ե�ǰ�߳��Ƿ����ж�
			try {
				car.waitForWaxing();
				printnb("Wax Off! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			} catch (InterruptedException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
				print("Exiting via interrupt");
			}
		}
		print("Ending Wax Off task");
	}
	
}

public class WaxOMatic {

	public static void main(String[] args) throws InterruptedException {
		// TODO �Զ����ɵķ������
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		//�������ٻ����̳߳�
		exec.execute(new WaxOff(car));
		//�ڽ���ĳʱ��ִ�и�������
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
