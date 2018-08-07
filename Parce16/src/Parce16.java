interface x{ String getSlip();}
public class Parce16 {
	String s;
	x a;
	private void internalTracking(boolean b) {
		if(b) {
			class TrackingSlip implements x{
				private String id;
				TrackingSlip(String s){
					id=s;
				}
				public String getSlip() {return id;}
			}
			a=new TrackingSlip("slip");
			s=a.getSlip();
		}
	}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Parce16 x=new Parce16();
		x.internalTracking(true);
		System.out.println(x.a.getSlip());
	}

}
