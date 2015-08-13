package Aula11.ex112;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import Aula11.ex112.pratos.Prato;

public class Ementa  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String local;
	private HashMap<DiaSemana, LinkedList<Prato>> lista = new LinkedHashMap<>();
	
	public Ementa(String nome, String local){
		if(nome.length()==0){
			throw new IllegalArgumentException("Nome da ementa inválida!");
		}
		this.nome = nome;
		if(local.length()==0){
			throw new IllegalArgumentException("Local inválido!");
		}
		this.local = local;
	}
	
	public enum DiaSemana implements Serializable{
		Segunda(0), Terca(1), Quarta(2), Quinta(3), Sexta(4), Sabado(5), Domingo(6);
		private int dia;
		
		DiaSemana(int dia){
			this.dia = dia;
		}
		
		public int intDia(){
			return dia;
		}
		
		public static DiaSemana rand(){
			switch ((int) (Math.random() * 6)){ 
				default:
				case 0:
					return DiaSemana.Segunda;
				case 1:
					return DiaSemana.Terca;
				case 2:
					return DiaSemana.Quarta;
				case 3:
					return DiaSemana.Quinta;
				case 4:
					return DiaSemana.Sexta;
				case 5:
					return DiaSemana.Sabado;
				case 6:
					return DiaSemana.Domingo;
			}
		}
	}
	
	public void removePrato(DiaSemana dia, Prato prato){
		Iterator<Prato> it = lista.get(dia).iterator();
		while(it.hasNext()){
			if(it.next().equals(prato)){
				it.remove();
			}
		}
	}
	
	public void addPrato(Prato prato, DiaSemana rand) {
		LinkedList<Prato> nova;
		if(lista.containsKey(rand)){
			nova = lista.get(rand);
		}else{
			nova = new LinkedList<>();
		}
		nova.push(prato);
		lista.put(rand, nova);
	}
	
	public int size(){
		return lista.size();
	}
	
	@Override public String toString(){
		String pratos = "";
		for(Entry<DiaSemana, LinkedList<Prato>> j : lista.entrySet()){
			pratos += "--- " + j.getKey() + " ---\n";
			Iterator<Prato> it = j.getValue().iterator();
			
			while(it.hasNext()){
				pratos += it.next() + "\n";
			}
		}
		return nome+"\nLocal: "+local+"\n"+pratos;
	}
}
