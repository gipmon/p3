package Aula11.ex111.c;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class FileWords{
	
	private HashMap<String, Integer> hm = new HashMap<>();
	
	public FileWords(File file){
		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNext()){
				String next = reader.next().toLowerCase();
				if(hm.containsKey(next)){
					hm.put(next, hm.get(next)+1);
				}else{
					hm.put(next, 1);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String listOccurrences(){
		String turn = "";
		for(Entry<String, Integer> v : hm.entrySet()){
			turn += v.getKey() + "\t" + v.getValue() + "\n";
		}
		return turn;
	}
}
