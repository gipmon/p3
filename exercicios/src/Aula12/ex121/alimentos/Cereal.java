package Aula12.ex121.alimentos;

import Aula11.ex112.pratos.Vegetariano;

/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */

public class Cereal extends Alimento implements Vegetariano{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	
	public Cereal(String nome, double calorias, double peso, double proteinas) {
		super(proteinas, calorias, peso);
		if(nome.length()==0){
			throw new IllegalArgumentException("Nome do cereal inv?lido!");
		}
		this.nome = nome;
	}
	
	@Override public String getNome() {
		return this.nome;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && nome.equals(((Cereal)b).nome);
	}
	
	@Override public String toString(){
		return "Cereal "+nome+" "+super.toString();
	}
}
