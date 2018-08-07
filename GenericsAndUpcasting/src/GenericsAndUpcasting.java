import java.util.ArrayList;
class Apple{
	private static long counter;
	private final long id = counter++;
	public long id() {return id;}
}
class GrannySmith extends Apple{}
class Gala extends Apple{}
class Fuji extends Apple{}
class Braceburn extends Apple{}

public class GenericsAndUpcasting {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		ArrayList<Apple>apples=new ArrayList();
		apples.add(new GrannySmith());
		apples.add(new Gala());
		apples.add(new Fuji());
		apples.add(new Braceburn());
		for (Apple apple : apples) {
			System.out.println(apple);
		}
	}

}
