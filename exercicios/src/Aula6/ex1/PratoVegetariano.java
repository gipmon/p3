// Rafael Ferreira https://github.com/gipmon/p3

package Aula6.ex1;
/**
 * @author Ant�nio Rafael Ferreira
 * nmec 67405
 */

public class PratoVegetariano extends Prato{

	private static final long serialVersionUID = 1L;
	public PratoVegetariano(String nome) {
		super(nome);
	}
	
	public boolean addIngrediente(Vegetariano v){
		return super.addIngrediente((Alimento)v);
	}
	
	@Override public String toString(){
		return "Vegetariano "+super.toString();
	}
	
}
