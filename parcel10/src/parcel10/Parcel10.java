package parcel10;
interface Destination{void f();};
public class Parcel10 {
	public Destination destination(final String dest, final float price)
	{
		return new Destination() {
			private int cost;
			{
				cost=Math.round(price);
				if(cost >100)
					System.out.println("over budget");
			}
			private String label=dest;
			public String readLabel() {return label;}
			public int readCost() {return cost;}
			@Override
			public void f() {	
			}
		};
	}
	class b{}
	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Parcel10.b x= new Parcel10().new b();
	}

}
