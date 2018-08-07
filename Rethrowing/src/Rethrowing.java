
public class Rethrowing {
	public static void f()throws Exception{
		System.out.println("originating the exception in f()");
		throw new Exception("thrown from f()");
	}
	public static void g()throws Exception{
		try {
			f();
		}catch(Exception e) {
			System.out.println("Inside g().e.printStackTrace()");
			e.printStackTrace(System.out);
			throw e;
		}
	}
	public static void h()throws Exception{
		try {
			f();
		}catch(Exception e) {
			System.out.println("Inside e().e.printStackTrace()");
			e.printStackTrace(System.out);
			throw (Exception)e.fillInStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		try {
			g();
		}catch(Exception e) {
			System.out.println("main: printStrace()");
			e.printStackTrace(System.out);
			e.printStackTrace(System.out);
			for (StackTraceElement s : e.getStackTrace()) {
				System.out.println(s.getMethodName());
			}
		}
		try {
			h();
		}catch(Exception e) {
			System.out.println("main: printStrace()");
			e.printStackTrace(System.out);
			for (StackTraceElement s : e.getStackTrace()) {
				System.out.println(s.getMethodName());
			}
		}
	}

}
