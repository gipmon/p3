// Rafael Ferreira https://github.com/gipmon/p3

/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula8.ex82;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class FileParser {
	private LinkedList<Ask> array = new LinkedList<Ask>();
	
	public FileParser(File file){
		try {
			FileReader fileReader = new FileReader(file);
			Scanner reader = new Scanner(fileReader);
			while(reader.hasNextLine()){
				parseLine(reader.nextLine());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void parseLine(String line){
		String[] atributos = line.split("&&");
		String questoes[] = {atributos[2], atributos[3], atributos[4], atributos[5]};
		array.add(new Ask(atributos[6], atributos[1], atributos[0], questoes, atributos[2]));
	}
	
	public Ask[] getAsks(){
		return array.toArray(new Ask[0]);
	}
}
