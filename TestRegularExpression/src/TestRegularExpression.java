import java.util.regex.*;

public class TestRegularExpression {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		String []str= 
		{"Arline ate eighti apples andi one orange while Anita hadn't anyi",
				"(?i)((^[aeiou])|(\\s+[aeiou]))\\w+?[aeiou]\\b"
				};
//		if(args.length<2) {
//			System.out.print("Usage:\njava TestRegularExpression "+
//		"characterSequence regularExpression+");
//			System.exit(0);
//		}
		System.out.println("Input: \""+str[0]+"\"");
		for (String arg : str) {
			System.out.println("Regular expression: \""+arg+"\"");
			Pattern p=Pattern.compile(arg); 
			Matcher m=p.matcher(str[0]);
			while(m.find()) {
				System.out.println("Match \""+m.group()+"\"at positions "+
			m.start()+"-"+(m.end()-1));
			}
		}
	}

}
