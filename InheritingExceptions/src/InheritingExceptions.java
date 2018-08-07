class SimpleException extends Exception{
	
}
public class InheritingExceptions {
	public void f()throws SimpleException{
		System.out.println("Throw SimpleException from f()");
		throw new SimpleException();
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		InheritingExceptions sed=new InheritingExceptions();
		try {
			sed.f();
		}catch(SimpleException e) {
			System.out.println("Caught it!");
		}
	}

}
