

class Pair{
	private int x,y;
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return "x: " + x + ", y:" + y;
	}
	public class PairValuesNotEqualException extends RuntimeException{
		public PairValuesNotEqualException() {
			super("Pair values not equal: "+ Pair.this);
		}
	}
	public void checkState() {
		if(x != y) {
			throw new PairValuesNotEqualException();
		}
	}
}

abstract class PairManager{
	AtomicInteger checkCounter = newk
}




public class CriticalSection {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根

	}

}
