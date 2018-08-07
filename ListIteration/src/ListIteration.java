import java.util.*;
import typeinfo.pets.*;

public class ListIteration {
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		List<Pet>pets=Pets.arrayList(8);
		ListIterator<Pet>it=pets.listIterator();
		while (it.hasNext()) {
			System.out.print(it.next()+", "+it.nextIndex()+", "
					+it.previousIndex()+":");
		}
		System.out.println();
		while (it.hasPrevious()) {
			System.out.print(it.previous().id()+"");
		}
		System.out.println();
		System.out.println(pets);
		it=pets.listIterator(3);
		while(it.hasNext()) {
			it.next();
			it.set(Pets.randomPet());
		}
		System.out.println(pets);
	}

}
