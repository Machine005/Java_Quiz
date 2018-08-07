import java.util.Collections;
import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;

public class AddingGroups {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Collection<Integer>collection=
				new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		//Arrays.asList()将数组或元素列表转换为List对象;
		Integer[]moreInts= {6,7,8,9,10};
		collection.addAll(Arrays.asList(moreInts));
		Collections.addAll(collection, 11,12,13,14,15);
		//Collections.addAll()将一个数组或一个元素列表添加进一个Collection对象
		Collections.addAll(collection, moreInts);
		List<Integer>list=Arrays.asList(16,17,18,19,20);
		list.set(1, 99);
	}

}
