// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.headers;

import java.io.IOException;
import java.util.LinkedList;

public class HeadersMain {
	public static void main(String[] args) throws IOException{
		HeadersWriter wr = new HeadersWriter();
		wr.printDirectoryList();
		
		/*
		FileOutputStream fos = new FileOutputStream(new File("ds"));
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(wr);
		*/
		/*
		 * agora é preciso fazer o header standart com um %text% que é costumizável de package para package no caso
		 * se ter packages (java)
		 * depois é iterar um a um até que temos o que precisamos, cada *package*, com um %text% costumizável
		 */
	}
}
