package Aula13.ex131;

import java.util.Iterator;
import java.io.Serializable;

public class Pais implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	private Localidade capital;
	private MyList<Regiao> regioes;
	
	public Pais(String nome, Localidade capital, MyList<Regiao> regioes){
		this.nome = nome;
		this.setCapital(capital);
		this.regioes = regioes;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Localidade getCapital() {
		return capital;
	}

	public void setCapital(Localidade capital) {
		this.capital = capital;
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}else if(b.getClass()!=getClass()){
			return false;
		}else{
			return (((Pais)b).nome).equals(nome) &&
					(((Pais)b).capital).equals(capital) &&
					(((Pais)b).regioes).equals(regioes);
		}
	}
	
	@Override public String toString(){
		String out = "PAIS: "+nome+" "+capital+"\nLista:\n";
		Iterator<Regiao> it = regioes.iterator();
		while(it.hasNext()){
			out += it.next();
		}
		return out;
	}

}
