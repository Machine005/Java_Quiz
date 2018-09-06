import static net.mindview.util.Print.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Car{
	private boolean waxOn = false;
	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
		//唤醒所有线程
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
		// TODO 自动生成的方法存根
		try {
			while(!Thread.interrupted()) {
				//测试当前线程是否已中断
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
		// TODO 自动生成的方法存根
		while(!Thread.interrupted()) {
			//测试当前线程是否已中断
			try {
				car.waitForWaxing();
				printnb("Wax Off! ");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
				print("Exiting via interrupt");
			}
		}
		print("Ending Wax Off task");
	}
	
}

public class WaxOMatic {

	public static void main(String[] args) throws InterruptedException {
		// TODO 自动生成的方法存根
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		//创建高速缓存线程池
		exec.execute(new WaxOff(car));
		//在将来某时刻执行给定命令
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
