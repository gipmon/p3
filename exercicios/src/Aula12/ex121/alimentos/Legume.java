// Rafael Ferreira https://github.com/gipmon/p3

package Aula12.ex121.alimentos;

import Aula11.ex112.pratos.Vegetariano;

/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */

public class Legume extends Alimento implements Vegetariano{
	
	private static final long serialVersionUID = 1L;
	private String nome;
	
	public Legume(String nome, double calorias, double peso, double proteinas) {
		super(proteinas, calorias, peso);
		this.nome = nome;
	}

	@Override public String getNome() {
		return this.nome;
	}
	
	@Override public boolean equals(Object b){
		return super.equals(b) && nome.equals(((Legume)b).nome);
	}
	
	@Override public String toString(){
		return "Legume "+nome+", "+super.toString();
	}

}
