import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader fr = new BufferedReader(new FileReader(new File("MenuText.txt")));
			String sor;
			while((sor = fr.readLine()) != null){
				System.out.println(sor);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
