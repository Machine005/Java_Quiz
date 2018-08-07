import typeinfo.pets.*;
import java.util.*;

public class CollectionSequence extends AbstractCollection<Pet>{
	private Pet[]pets=Pets.createArray(8);
	@Override
	public int size() {return pets.length;}
	public Iterator<Pet> iterator() {
		// TODO 自动生成的方法存根
		return new Iterator<Pet>() {
			private int index =0;
			public boolean hasNext() {
				return index<pets.length;
			}
			public Pet next() {return pets[index++];}
			public void remove() 
			{throw new UnsupportedOperationException();}
		};
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		CollectionSequence c=new CollectionSequence();
		InterfaceVsIterator.display(c);
		InterfaceVsIterator.display(c.iterator());
	}

}
