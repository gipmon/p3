package Aula11.ex111.b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class FileWordsCounter {
	
	private HashSet<String> set = new HashSet<>();
	private int numberOfWords = 0;
	
	private FileWordsCounter(File file){
		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNext()){
				set.add(reader.next());
				numberOfWords++;
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static FileWordsCounter file(File file){
		return new FileWordsCounter(file);
	}
	
	public int getNumberOfWords(){
		return numberOfWords;
	}
	
	public int getNumberOfDiferentWords(){
		return set.size();
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}else if(b.getClass() != getClass()){
			return false;
		}else{
			return set.equals(((FileWordsCounter)b).set) && numberOfWords == ((FileWordsCounter)b).numberOfWords;
		}
	}
}
