import java.util.ArrayList;

class Apple{
	private static long counter;
	private final long id = counter++;
	public long id() {return id;}
}
class Orange{}
public class ApplesAndOrangesWithoutGenerics {
	@SuppressWarnings("uncheck")
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//ArrayList apples=new ArrayList();
		ArrayList<Apple> apples=new ArrayList();
		for(int i = 0; i < 3; i++) {
			apples.add(new Apple());
		}
		//apples.add(new Orange());
		for (int i = 0; i < 3; i++) {
			System.out.println(((Apple)apples.get(i)).id());
		}
		for (Apple apple : apples) {
			System.out.println(apple.id());
		}
	}

}
