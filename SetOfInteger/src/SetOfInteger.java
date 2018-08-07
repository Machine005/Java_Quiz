import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class SetOfInteger {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Random rand=new Random(47);
		Set<Integer>intset=new HashSet<Integer>();
		for(int i=0;i<10000;i++) {
			intset.add(rand.nextInt(30));
		}
		System.out.println(intset);
	}

}
