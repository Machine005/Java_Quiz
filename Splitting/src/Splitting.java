import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitting {
	public static String knights=
		"Then, when you have found the shrubbery, you must "+
	    "cut down the mightiest tree in the forest... "+
		"with... a herring!";
	public static String str="Aasd asd ads.";
	
	public static void split(String regex) {
		System.out.println(Arrays.toString(knights.split(regex)));
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		//split(" ");
		//split("\\W+");
		//split("n\\W+");
		//System.out.println(str.matches
		//("(\\p{Upper})(\\w+)(\\s+)(\\w+)(\\s+)(\\w+)(\\p{Punct})"));
		
		
		System.out.println(str.matches(
				"(\\p{Upper})(.*?)(\\p{Punct})"));
		
	}

}
  
  
 