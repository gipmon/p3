// Rafael Ferreira https://github.com/gipmon/p3

package treino.pratico.corte;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class WordPairs {

	
	private Map<String, TreeMap<String, Integer>> data;
	private String previousWord;
	private String toReturn;
	
	public WordPairs(){
		data = new TreeMap<String, TreeMap<String, Integer>>();
	}
	
	public void add(String word){
		if(!data.containsKey(word))
			data.put(word, new TreeMap<String, Integer>());
		
		if(previousWord!=null){
			if(!data.get(previousWord).containsKey(word))
				data.get(previousWord).put(word, 0);
			data.get(previousWord).put(word, data.get(previousWord).get(word)+1);
		}
		previousWord = word;
	}
	
	public void updateToString(){
		toStringRunOnce();
	}
	
	@Override
	public String toString(){
		if(toReturn==null)
			toStringRunOnce();
		return toReturn;
	}
	
	private void toStringRunOnce(){
		for(Entry<String, TreeMap<String, Integer>> argSet : this.data.entrySet()){
			
		}
		Iterator<Map.Entry<String,TreeMap<String, Integer>>> argSet = this.data.entrySet().iterator();
		toReturn="";
		while(argSet.hasNext()){
			
			Map.Entry<String, TreeMap<String, Integer>> tmpEntry = argSet.next();
			
			Iterator<Map.Entry<String, Integer>> tmpIterator = tmpEntry.getValue().entrySet().iterator();
			if(!tmpIterator.hasNext())
				continue;
			toReturn += String.format("%s={", tmpEntry.getKey());
			
			while(tmpIterator.hasNext()){
				Map.Entry<String, Integer> tmp = tmpIterator.next();
				toReturn += String.format("%s=%d%s",tmp.getKey(), tmp.getValue(), tmpIterator.hasNext() ? ", ":"}\r\n");
			}
		}		
	}
}