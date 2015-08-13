// Rafael Ferreira https://github.com/gipmon/p3

package treino.javaio;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ReaderTXT {
	Map<String, Integer> map = new HashMap<>();
	
	public ReaderTXT(File file){
		reader(file);
	}
	
	public void reader(File file){
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()){
				String lol = sc.next();
				if(lol.contains("a")){
					int i = 1;
					if(map.containsKey(lol)){
						i = map.get(lol) + 1;
					}
					map.put(lol, i);
				}
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override public String toString(){
		String out = "";
		for(Entry<String, Integer> set : map.entrySet()){
			out += "[Palavra]: "+set.getKey()+" n: "+set.getValue()+"\n";
		}
		return out;
	}
}
