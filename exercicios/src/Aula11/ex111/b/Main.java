package Aula11.ex111.b;

import java.io.File;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("Ficheiro a ler: ");
		Scanner sc = new Scanner(System.in);
		String ficheiro = sc.next();
		sc.close();
		FileWordsCounter fwc = FileWordsCounter.file(new File(ficheiro));
		
		System.out.println("Número Total de Palavras: " + fwc.getNumberOfWords());
		System.out.println("Número de Diferentes Palavras: " + fwc.getNumberOfDiferentWords());
	}

}
