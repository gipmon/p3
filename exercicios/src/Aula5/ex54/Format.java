package Aula5.ex54;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Map.Entry;
import java.util.Set;

public class Format{
	
	LinkedHashMap<String, Pessoa> list;
	
	public Format(){
		this.list = new LinkedHashMap<String, Pessoa>();
	}
	
	public Format(LinkedHashMap<String, Pessoa> list){
		this.list = list;
	}
	
	public static Set<Entry<String, Pessoa>> importData(File f){
		try {
			Scanner sc = new Scanner(f);
			String firstline = sc.nextLine();
			if(firstline.equals("Nokia")){
				return (new Nokia()).getFrom(f);
			}else if(firstline.equals("CSV")){
				return (new CSV()).getFrom(f);
			}else if(firstline.equals("vCard")){
				return (new vCard()).getFrom(f);
			}else{
				return null;
			}
		}catch(FileNotFoundException e){
			throw new IllegalArgumentException("Ficheiro n‹o encontrado!");
		}	
	}
	
	public static void backup(String name, String tec, Pessoa[] array){
		if(!tec.equals("Nokia") && !tec.equals("CSV") && !tec.equals("vCard")){
			throw new IllegalArgumentException("Tecnologia inv‡lida!");
		}
		if(tec.equals("CSV")){
			(new CSV()).write(array, new File(name));
		}else if(tec.equals("Nokia")){
			(new Nokia()).write(array, new File(name));
		}else if(tec.equals("vCard")){
			(new vCard()).write(array, new File(name));
		}
	}
	
	public void update(LinkedHashMap<String, Pessoa> list){
		this.list = list;
	}
	
	public void add(String key, Pessoa value){
		list.put(key, value);
	}
	
	public void add(String name, Data ddn, int cc){
		list.put(name, new Pessoa(name, cc, ddn));
	}
	
	public static boolean fileOK(File f){
		if(!f.exists()){
			throw new IllegalArgumentException("Ficheiro n‹o existe!");
		}
		if(!f.canRead()){
			throw new IllegalArgumentException("N‹o Ž poss’vel ler o ficheiro!");
		}
		if(f.isDirectory()){
			throw new IllegalArgumentException("ƒ um direct—rio!");
		}
		return true;
	}
	
	public Set<Entry<String, Pessoa>> entrySet(){
		return list.entrySet();
	}
}
