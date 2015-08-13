package treino.pratico.corte;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {
		
		System.out.print("Introduza o nome do ficheiro: ");
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		sc.close();
		
		Scanner fout = new Scanner(new File(fileName));
		fout.useDelimiter(" |\t|\r\n|\n|\r|\n\r|\\.|,|:|'|‘|’|;|\\?|!|-|\\*|\\{|}|=|\\+|&|/|\\(|\\)|\\[|]|”|“|\"|\'");
		
		WordPairs wp = new WordPairs();
		
		String tmp="";
		while(fout.hasNext()){
			tmp = fout.next().toLowerCase();
			if(tmp.length()>=3)
				wp.add(tmp);
		}
		fout.close();
		
		PrintWriter pw = new PrintWriter(new File("output.txt"));
		pw.print(wp.toString()); 
		pw.close();
	}
}
