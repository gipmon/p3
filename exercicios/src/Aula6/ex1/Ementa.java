package Aula6.ex1;
/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */

import java.io.Serializable;

public class Ementa  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private String local;
	private Pratos lista = new Pratos();
	
	public Ementa(String nome, String local){
		if(nome.length()==0){
			throw new IllegalArgumentException("Nome da ementa inv‡lida!");
		}
		this.nome = nome;
		if(local.length()==0){
			throw new IllegalArgumentException("Local inv‡lido!");
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
	
	public class Pratos  implements Serializable{
		
		private static final long serialVersionUID = 1L;
		private DiaLista[] dias = new DiaLista[6];
		
		private class DiaLista implements Serializable{
			private static final long serialVersionUID = 1L;

			class Node implements Serializable{
				private static final long serialVersionUID = 1L;
				
				Node next;
				Prato prato;
				DiaSemana dia;
				public Node(Prato prato, DiaSemana dia){
					this.prato = prato;
					this.dia = dia;
				}
			}
			
			Node top = null;
			int size = 0;
			
			public void add(Prato prato, DiaSemana dia){
				Node novo = new Node(prato, dia);
				novo.next = top;
				top = novo;
				size++;
			}
			
			public boolean remove(Prato prato){
				Node tmp = top;
				if(top.prato.equals(prato) && top.next==null){
					top = null;
					return true;
				}else if(top.prato.equals(prato) && top.next!=null){
					top = top.next;
					return true;
				}
				while(tmp.next!=null){
					if(tmp.next.prato.equals(prato)){
						tmp.next = tmp.next.next;
						return true;
					}
					tmp = tmp.next;
				}
				return false;
			}
			
			@SuppressWarnings("unused")
			public Prato[] toArray(){
				Node tmp = top;
				Prato[] array = new Prato[size];
				int i = 0;
				while(tmp!=null){
					array[i++] = tmp.prato;
					tmp = tmp.next;
				}
				return array;
			}
			
			@Override public String toString(){
				Node tmp = top;
				String out = "";
				while(tmp!=null){
					out += "\n"+tmp.prato+", dia "+tmp.dia;
					tmp = tmp.next;
				}
				return out;
			}
			
		}
		
		public void addPrato(Prato prato, DiaSemana dia){
			if(dias[dia.intDia()]==null){
				dias[dia.intDia()] = new DiaLista();
			}
			dias[dia.intDia()].add(prato, dia);
		}
		
		public boolean remove(Prato prato, DiaSemana dia){
			if(dias[dia.intDia()]==null){
				throw new IllegalArgumentException("Ementas n‹o definidas para esse dia!");
			}
			return dias[dia.intDia()].remove(prato);
		}
		
		public int size(){
			int size = 0;
			for(DiaLista dia : dias){
				if(dia!=null){
					size += dia.size;
				}
			}
			return size;
		}
		
		@Override public String toString(){
			String out = "";
			for(DiaLista dia : dias){
				if(dia!=null){
					out += dia.toString();
				}
			}
			return out;
		}
	}
	
	public boolean removePrato(Prato prato, DiaSemana dia){
		return lista.remove(prato, dia);
	}
	
	public void addPrato(Prato prato, DiaSemana rand) {
		lista.addPrato(prato, rand);
	}
	
	public int size(){
		return lista.size();
	}
	
	@Override public String toString(){
		return nome+"\nLocal: "+local+"\n"+lista.toString();
	}
}
