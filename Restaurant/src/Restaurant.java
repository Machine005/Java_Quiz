import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static net.mindview.util.Print.*;

class Meal{
	private final int orderNum;
	Meal(int orderNum){
		this.orderNum = orderNum;
	}
	public String toString() {
		return "Meal " + orderNum;
	}
}
class WaitPerson implements Runnable{
	private Restaurant restaurant;
	public WaitPerson(Restaurant r) {restaurant = r;}
	
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while(restaurant.meal == null)
						wait();		
					}
				print("Waitperson got " + restaurant.meal);
				synchronized(restaurant.chef) {
					restaurant.meal = null;
					restaurant.chef.notifyAll();
				}
			}
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			print("WaitPerson interrupted");
		}
		
	}
	
}
class Chef implements Runnable{
	private Restaurant restaurant;
	private int count = 0;
	public Chef(Restaurant r) {restaurant = r;}
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		try {
			while(!Thread.interrupted()) {
				synchronized(this) {
					while(restaurant.meal != null)
						wait();
				}
				if(++count == 10) {
					print("Out of food, closing");
					restaurant.exec.shutdownNow();
				}
				printnb("Order up");
				synchronized(restaurant.waitPerson){
					restaurant.meal = new Meal(count);
					restaurant.waitPerson.notifyAll();
				}
				TimeUnit.MILLISECONDS.sleep(100);
			}
		}catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			print("Chef interrupted");
		}
	}
	
}
public class Restaurant {
	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);
	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}
	
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		new Restaurant();
	}

}
