import typeinfo.pets.*;
import java.util.*;

public class MapOfList {
	public static Map<Person, List<? extends Pet>>
	petPeople=new HashMap<Person, List<? extends Pet>>();
	static {
		petPeople.put(new Person("Dawn"),
				Arrays.asList(
						new Cymric("Molly"),new Mutt("Spot")));
		petPeople.put(new Person("Kate"),
				Arrays.asList(new Cat("Shackleton"),
						new Cymric("Elsie May"),new Mutt("Margrett")));
		petPeople.put(new Person("Marilyn"),
				Arrays.asList(
						new Pug("Louie aka Louis Snorkelstein Dupree"),
						new Cat("Stanford aka Stinky el Negro"),
						new Cat("Pinkola")));
		petPeople.put(new Person("Luke"),
				Arrays.asList(
						new Rat("Fuzzy"),new Rat("Fizzy")));
		petPeople.put(new Person("Isaac"),
				Arrays.asList(
						new Rat("Freckly")));
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		System.out.println("People: "+petPeople.keySet());
		System.out.println("Pets: "+petPeople.values());
		for (Person person : petPeople.keySet()) {
			System.out.print(person+" has:");
			for (Pet pet : petPeople.get(person)) {
				System.out.println("   "+pet);
			}
		}
	}

}
