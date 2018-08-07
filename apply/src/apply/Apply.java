package apply;

import java.util.Arrays;

class Processor{
	public String name(){
		return getClass().getSimpleName();
//		返回源代码中给出的基础类的简单名称。 
//		如果基础类是匿名的，则返回一个空字符串。 
//		数组的简单名称是附加了“[]”的组件类型的简单名称。 
//		特别是组件类型为匿名的数组的简单名称是“[]”。 

	}
	Object process(Object input){
		return input;
	}
}
class Upcase extends Processor{
	String process(Object input){
		return ((String)input).toUpperCase();
		//将此 String所有字符转换为大写，使用默认语言环境的规则。
	}
}
class Downcase extends Processor{
	String process(Object input){
		return ((String)input).toLowerCase();
		//使用默认语言环境的规则将此 String所有字符转换为小写。 
	}
}
class Splitter extends Processor{
	String process(Object input){
		return Arrays.toString(((String)input).split(""));
	}
}
public class Apply {
	public static void process(Processor p, Object s){
		System.out.println("Using Processor "+p.name());
		System.out.println(p.process(s));
	}
	public static String s=
			"Disagreement with beliefs is by definition incorrect";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		process(new Upcase(),s);
		process(new Downcase(), s);
		process(new Splitter(), s);
		char []x={'a','b','c'};
		System.out.println(x);
	}

}
