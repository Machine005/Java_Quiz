package polymorphism;
import java.util.Random;

public class RandomShapeGenerator {
	private Random x=new Random();
	public Shape next() {
		switch(x.nextInt(3)) {
		      case 0:
		    	  return new Circle();
		      case 1:
		    	  return new Square();
		      case 2:
		    	  return new Triangle();
		      default:
		    	  return null;
		}
	}
}
