package Aula12.ex123;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Agenda{

	private HashMap<String, Pessoa> pessoas = new HashMap<String, Pessoa>(); 
	
	public void add(String key, Pessoa nova){
		pessoas.put(key, nova);
	}
	
	public void load(String name){
		File f = new File(name);
		
		if(PluginManager.fileOK(f)){
			for(Entry<String, Pessoa> set : PluginManager.importData(f)){
				add(set.getKey(), set.getValue());
			}
		}
	}
	
	public void backup(String name, String plugin){
		PluginManager.backup(name, plugin, pessoas(0));
	}
	
	public void remove(String key){
		pessoas.remove(key);
	}
	
	public String list(int ordem){ // 0 => Normal, 1 => Ordenado por nome, 2=> ordenado por CC 
		String out = "";
		
		for(Pessoa pessoa : pessoas(ordem)){
			out += "----------\n"+pessoa.toString()+"\n";
		}
		
		return out+"----------";
	}
	
	private Pessoa[] pessoas(int order){ // 0 => Normal, 1 => Ordenado por nome, 2=> ordenado por CC
		String[] keys = keys(order);
		Pessoa[] p = new Pessoa[keys.length];
		
		for(int i=0; i<keys.length; i++){
			p[i] = pessoas.get(keys[i]);
		}
		
		return p;
	}
	
	private String[] keys(int order){ // 0 => Normal, 1 => Ordenado por nome, 2=> ordenado por CC
		Set<String> set = pessoas.keySet();
		String[] keys = set.toArray(new String[0]);
		
		if(order==1 || order==2){ 
			TreeMap<String, String> tree = new TreeMap<String, String>();
			if(order==1){
				for(String key : keys){
					tree.put(pessoas.get(key).getName(), key);
				}
			}else{
				for(String key : keys){
					tree.put(pessoas.get(key).getCC(), key);
				}
			}
			int i = 0;
			for(Map.Entry<String, String> entry : tree.entrySet()){
				keys[i++] = entry.getValue();
			}
		}
		
		return keys;
	}
	
	public int many(){
		return pessoas.size();
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}
		if(getClass()!=b.getClass()){
			return false;
		}
		return pessoas.equals(((Agenda)b).pessoas);
	}
}
