import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class test {
		
	public static void main(String[] args) {
		File a=new File("C:\\Users\\asus\\Desktop\\123\\11\\12345.txt");
		try (FileWriter k=new FileWriter(a)){
			k.write("eqwrqwer");
			System.out.println(a.getName()+a.length());
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO 自动生成的 catch 块
			e1.printStackTrace();
		}

		
	}

}
