import java.util.Arrays;

import interfaceprocessor.Processor;
import interfaceprocessor.Apply;

public abstract class StringProcessor implements Processor{
	public String name(){
		return getClass().getSimpleName();
	}
	public abstract String process(Object input);
	public static String s=
			"Disagreement with beliefs is by definition incorrect";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Apply.process(new Upcase(),s);
		Apply.process(new Downcase(), s);
		Apply.process(new Splitter(), s);
	}
}
class Upcase extends StringProcessor{
	public String process(Object input){
		return ((String)input).toUpperCase();
		//将此 String所有字符转换为大写，使用默认语言环境的规则。
	}
}
class Downcase extends StringProcessor{
	public String process(Object input){
		return ((String)input).toLowerCase();
		//使用默认语言环境的规则将此 String所有字符转换为小写。 
	}
}
class Splitter extends StringProcessor{
	public String process(Object input){
		return Arrays.toString(((String)input).split(" "));
	}
}