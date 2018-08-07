import java.util.*;

class Instrument{
	void play(int n) {System.out.println("Instrument.play() "+n);}
	//String what() {return "Instrument";}
	void abjust() {System.out.println("Adjusting Instrument");}
	@Override public String toString() {return getClass()+"";}
}
class Wind extends Instrument{
	@Override void play(int n) {System.out.println("Wind.play() "+n);}
	//@Override String what() {return "Wind";}
	@Override void abjust() {System.out.println("Adjusting Wind");}
}
class Percussion extends Instrument{
	@Override void play(int n) {System.out.println("Percussion.play() "+n);}
	//@Override String what() {return "Percussion";}
	@Override void abjust() {System.out.println("Adjusting Percussion");}
}
class Stringed extends Instrument{
	@Override void play(int n) {System.out.println("Stringed.play() "+n);}
	//@Override String what() {return "Stringed";}
	@Override void abjust() {System.out.println("Adjusting Stringed");}
}
class Woodwind extends Wind{
	@Override void play(int n) {System.out.println("Woodwind.play() "+n);}
	//@Override String what() {return "Woodwind";}
}
class Brass extends Wind{
	@Override void play(int n) {System.out.println("Brass.play() "+n);}
	@Override void abjust() {System.out.println("Adjusting Brass");}
}
public class Music3 {
	private static Random x=new Random();
	public static void tune(Instrument i) {
		i.play(6);
	}
	public static void tuneAll(Instrument []i) {
		for (Instrument s : i) {
			tune(s);
		}
	}
	private static Instrument RandomInstrument() {
		switch(x.nextInt(4))
		{
		    case 0:
		    	return new Wind();
		    case 1:
		    	return new Percussion();
		    case 2:
		    	return new Stringed();
		    case 3:
		    	return new Woodwind();
		    case 4:
		    	return new Brass();
		    default:
		    	return null;
		}
	}
	public static void main(String[] args) {
		/*Instrument[] orchestra= {
				new Wind(),
				new Percussion(),
				new Stringed(),
				new Brass(),
				new Woodwind()
		};*/
		//tuneAll(orchestra);
		Instrument[] Orchestra=new Instrument[5];
		for (int i = 0; i < Orchestra.length; i++) {
			Orchestra[i]=RandomInstrument();
		}
		for (Instrument x : Orchestra) {
			System.out.println(x.toString());
		}
	}
}