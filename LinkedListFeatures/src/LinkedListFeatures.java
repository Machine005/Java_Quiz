import typeinfo.pets.*;
import java.util.*;

public class LinkedListFeatures {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		LinkedList<Pet>pets=new LinkedList<Pet>(Pets.arrayList(5));
		System.out.println(pets);
		System.out.println("pets.getFirst(): "+pets.getFirst());
		System.out.println("pets.element(): "+pets.element());
		System.out.println("pets.peek(): "+pets.peek());
		System.out.println("pets.remove(): "+pets.remove());
		System.out.println("pets.removeFirst(): "+pets.removeFirst());
		System.out.println("pets.poll(): "+pets.poll());
		System.out.println(pets);
		pets.addFirst(new Rat());
		System.out.println("After addFirst(): "+pets);
		pets.add(Pets.randomPet());
		System.out.println("After add(): "+pets);
		pets.addLast(new Hamster());
		System.out.println("After addLast(): "+pets);
		System.out.println("pets.removeLast(): "+pets.removeLast());
	}

}
