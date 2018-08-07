
interface Selector{
	boolean end();
	Object current();
	void next();
}

public class Sequence {
	private Object []items;
	private int next=0;
	public Sequence(int size) {items=new Object[size];}
	public void add(Object x) {
		if(next<items.length)
			items[next++]=x;
	}
	private class SequenceSelector implements Selector{
		private int i=0;
		@Override
		public boolean end() {
			// TODO 自动生成的方法存根
			return i==items.length;
		}

		@Override
		public Object current() {
			// TODO 自动生成的方法存根
			return items[i];
		}

		@Override
		public void next() {
			// TODO 自动生成的方法存根
			if(i<items.length) i++;
		}
	}
	public Selector selector() {
		return new SequenceSelector();
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Sequence sequence=new Sequence(10);
		for (int i = 0; i < sequence.items.length; i++) {
			sequence.add(Integer.toString(i));
		}
		Selector selector=sequence.selector();
		while(!selector.end()) {
			System.out.println(selector.current()+"");
			selector.next();
		}
	}
}
