class MyException extends Exception{
	public MyException() {}
	public MyException(String msg) {super(msg);}
}
public class FullConstructors {
	public static void f() throws MyException{
		System.out.println("Trowing MyException from f()");
		throw new MyException();
	}
	public static void g()throws MyException{
		System.out.println("Throwing MyException from g()");
		throw new MyException("Originated in g()");
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			f();
		}catch(MyException e) {
			e.printStackTrace(System.out);
		}
		try {
			g();
		}catch(MyException e) {
			e.printStackTrace(System.out);
		}
	}

}
