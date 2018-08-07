class ThreeException extends Exception{}

public class FinallyWorks {
	static int count=0;
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		while(true) {
			try { 
				if(count++==0)
					throw new ThreeException();
				System.out.println("No exception");
			}catch(ThreeException e) {
				System.out.println("ThreeException");
			}finally {
				System.out.println("In finally clause");
				if(count==2)break;
			}
		}
	}

}
