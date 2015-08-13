// Rafael Ferreira https://github.com/gipmon/p3

package Aula13.ex132;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class WordsPairs {
	
	private Map<String, Pair> pairs;
	private char[] spacer = {' ','\t','\n','.',',',':','\'','‘','’',';','?',
			'!','-','*','{','}','=','+','&','/','(',')','[',']','”','“','\"'}; 
	
	public WordsPairs(File file){
		if(!file.exists()){
			throw new IllegalArgumentException("Ficheiro não existe!");
		}
		
		String content = "";
		
		try{
			InputStream in = new FileInputStream(file);
			Reader reader = new InputStreamReader(in);
			Scanner sc = new Scanner(reader);
			while(sc.hasNextLine()){
				String tmp = sc.nextLine();
				if(tmp.length()==0){
					content += ' ';
				}else{
					content += tmp;
				}
			}
			sc.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		
		if(content.length()!=0){
			pairs = regexSplit(content);
		}else{
			throw new IllegalArgumentException("Ficheiro sem conteúdo!");
		}
	}
	
	private Map<String, Pair> regexSplit(String content){
		Map<String, Pair> newPairs = new TreeMap<>();
		
		String key = "";
		String value = "";
		
		for(char c: content.toCharArray()){
			if(isSpacer(c)){
				if(value.length() >= 3){
					if(key.length()==0){
						key = value;
					}else{
						key = key.toLowerCase();
						value = value.toLowerCase();
						
						if(!newPairs.containsKey(key)){
							newPairs.put(key, new Pair(value));	
						}else{
							newPairs.get(key).newNextParValue(value);
						}
						key = value; // value now is the key! :D
					}
				}	
				value = "";				
			}else{
				value += c;
			}
		}
		
		return newPairs;
	}
	
	private boolean isSpacer(char toCompare){
		for(char e : spacer){
			if(e == toCompare)
				return true;
		}
		return false;
	}
	
	private class Pair{
		private Map<String, Integer> pairValues = new LinkedHashMap<>(); 
		
		public Pair(String key){
			this.pairValues.put(key, 1);
		}
		
		public void newNextParValue(String key){
			if(pairValues.containsKey(key)){
				this.pairValues.put(key, this.pairValues.get(key)+1);
			}else{
				this.pairValues.put(key, 1);
			}
		}
		
		@Override public boolean equals(Object b){
			if(b==null){
				return false;
			}else if(b.getClass()!=getClass()){
				return false;
			}else{
				return (((Pair)b).pairValues).equals(pairValues);
			}
		}
		
		@Override public String toString(){
			String out = "";
			for(Entry<String, Integer> entry : pairValues.entrySet()){
				out = entry.getKey()+"="+entry.getValue()+", " + out;
			}
			out = out.substring(0, out.length()-2);
			return out;
		}
	}
	
	public void saveInFile(File saveOn){
		try {
			OutputStream os = new FileOutputStream(saveOn);
			Writer wr = new PrintWriter(os);
			wr.write(toString());
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override public String toString(){
		String out = "";
		
		for(Entry<String, Pair> entry : pairs.entrySet()){
			out += entry.getKey()+"={"+entry.getValue()+"}\n";
		}
		
		return out;
	}
}
