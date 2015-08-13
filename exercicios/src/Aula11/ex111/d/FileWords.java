package Aula11.ex111.d;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class FileWords{
	
	private TreeMap<String, Integer> tm = new TreeMap<>(new MyComp());
	
	public FileWords(File file){
		try {
			Scanner reader = new Scanner(file);
			while(reader.hasNext()){
				String next = reader.next().toLowerCase();
				if(tm.containsKey(next)){
					tm.put(next, tm.get(next)+1);
				}else{
					tm.put(next, 1);
				}
			}
			reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String listOccurrences(){
		String turn = "";
		for(Entry<String, Integer> v : tm.entrySet()){
			turn += v.getKey() + "\t" + v.getValue() + "\n";
		}
		return turn;
	}
	
	public class MyComp implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}

	}
}
