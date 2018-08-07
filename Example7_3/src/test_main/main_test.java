package test_main;

import mypackage.HelloMachine;
import mypackage.SpeakHello;

public class main_test {
	public static void main(String argv[]){
		// TODO Auto-generated method stub
		HelloMachine machine=new HelloMachine();
		machine.turnOn( new SpeakHello(){
			public void speak(){
				System.out.println("hello,you are welcome!");
			}
		});
		machine.turnOn( new SpeakHello() {
			public void speak(){
				System.out.println("ƒ„∫√£¨ª∂”≠π‚¡Ÿ£°");}});
	}
}
