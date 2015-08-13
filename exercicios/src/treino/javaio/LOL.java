// Rafael Ferreira https://github.com/gipmon/p3

package treino.javaio;

import java.io.File;
import java.util.Scanner;

public class LOL {
	public static void main(String[] args){
		//Scanner sc = new Scanner(System.in);
		ReaderTXT rd = new ReaderTXT(new File("pratica13-1.txt"));//new File(sc.next()));
		System.out.println(rd);
	}
}
