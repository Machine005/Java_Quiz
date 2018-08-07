package test_main;
import mypackage.*;
public class main_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShowBoard board = new ShowBoard();
		board.showMess(new OutputEnglish());
		board.showMess(new OutputAlphabet(){
			public void output(){
				for(char c='0'; c<='9'; c++)
					System.out.println(c);}});
		}

}
