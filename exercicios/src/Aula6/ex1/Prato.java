package Aula6.ex1;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Prato implements Comparable, Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private LinkedHashMap<Integer, Alimento> composicao = new LinkedHashMap<Integer, Alimento>();
	
	public Prato(String nome, Alimento... a){
		if(nome.length()==0){
			throw new IllegalArgumentException("Nome do prato inv‡lido!");
		}
		this.nome = nome;
		for(Alimento b : a){
			int key = composicao.size();
			while(composicao.containsKey(key)){
				key++;
			}
			composicao.put(key, b);
		}
	}
	
	public boolean addIngrediente(Alimento a, int... key){
		if(!composicao.containsValue(a)){
			
			int keyValue;
			if(key.length==0){
				keyValue = composicao.size();
				while(composicao.containsKey(key)){
					keyValue++;
				}
			}else if(key.length!=1){
				throw new IllegalArgumentException("Valor de key inv‡lido!");
			}else{
				keyValue = key[0];
			}
			
			composicao.put(keyValue, a);
			return true;
		}
		return false;
	}
	
	public void removeIngrediente(int key){
		if(!composicao.containsKey(key)){
			throw new IllegalArgumentException("N‹o existe esse ingrediente no Prato!");
		}
		composicao.remove(key);
	}
	
	public String getNome(){
		return nome;
	}
	
	public double getCalorias(){
		Alimento[] array = composicao.entrySet().toArray(new Alimento[0]);
		
		double sumCalorias = 0;
		
		for(Alimento a : array){
			sumCalorias += a.calTotalCalorias();
		}
		
		return sumCalorias;
	}
	
	public double getProteinas(){
		Alimento[] array = composicao.entrySet().toArray(new Alimento[0]);
		
		double sumProteinas = 0;
		
		for(Alimento a : array){
			sumProteinas += a.calTotalProteinas();
		}
		
		return sumProteinas;
	}
	
	public double getPesoTotal(){
		Alimento[] array = composicao.entrySet().toArray(new Alimento[0]);
		
		double sumPesoTotal = 0;
		
		for(Alimento a : array){
			sumPesoTotal += a.getPeso();
		}
		
		return sumPesoTotal;
	}
	
	public Alimento[] getAlimentos(){
		return composicao.entrySet().toArray(new Alimento[0]);
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}else if(getClass()!=b.getClass()){
			return false;
		}
		return nome.equals(((Prato)b).nome) && composicao.equals(((Prato)b).composicao);
	}
	
	@Override public String toString(){
		String out= "Prato \'"+nome+"\' composto por "+composicao.size()+" Ingredientes\n"
			+ "-- Ingredientes: ";
		for(Entry<Integer, Alimento> a : composicao.entrySet()){
			out += a.getValue()+" ID: "+a.getKey()+"\n";
		}
		return out;
	}

	@Override public int compareTo(Object b) {
		double thisCalorias = getCalorias();
		double bCalorias = ((Prato)b).getCalorias();
		
		if(thisCalorias < bCalorias){
			return -1;
		}else if(thisCalorias == bCalorias){
			return 0;
		}else{
			return 1;
		}	
	}
}
