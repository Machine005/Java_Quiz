import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

class Key{
	int PID;
}
class Value{
	
}
class Box{
	Key info;
	Value value;
}
class GUI{
	Map<Key, Value> WarehouseMap;
	GUI(Map<Key, Value> WarehouseMap){
		this.WarehouseMap = WarehouseMap;
	}
	void init() {
		WarehouseMap.put(new Key(), new Value());
	}
	Key function() {
		return new Key();
	}
}
class PID{
	Queue<Box> WarehouseQueue;
	PID(Queue<Box> WarehouseQueue){
		this.WarehouseQueue = WarehouseQueue;
	}
	void init() {
		WarehouseQueue.add(new Box());
	}
}
class function{
	int info;
	function(int info){
		
	}
}
public class Threadtest {
	static Map<Key, Value> WarehouseMap = new ConcurrentHashMap<Key, Value>();
	
	Queue<Box> WarehousePutQueue = new ConcurrentLinkedQueue<Box>(); 
	Queue<Value> WarehouseOutQueue  = new LinkedBlockingQueue<Value>();
	
	public static void main(String[] args) {	
		
		
			
	}

}
