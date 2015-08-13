// Rafael Ferreira https://github.com/gipmon/p3

package Aula13.ex132;

import java.io.File;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		/*System.out.print("Ficheiro: ");
		
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		sc.close();*/
		String path = "pratica13-1.txt";
		
		WordsPairs wp = new WordsPairs(new File(path));
		System.out.println(wp);
		wp.saveInFile(new File("output.txt"));
	}
}
